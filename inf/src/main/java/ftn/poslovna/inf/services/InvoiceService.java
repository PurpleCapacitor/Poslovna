package ftn.poslovna.inf.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.swing.text.AbstractDocument.Content;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.poslovna.inf.converters.InvoiceConverter;
import ftn.poslovna.inf.domain.Invoice;
import ftn.poslovna.inf.domain.InvoiceItem;
import ftn.poslovna.inf.domain.InvoiceType;
import ftn.poslovna.inf.domain.Order;
import ftn.poslovna.inf.domain.OrderItem;
import ftn.poslovna.inf.domain.PriceTableItem;
import ftn.poslovna.inf.dto.InvoiceDTO;
import ftn.poslovna.inf.repository.InvoiceRepository;

@Service
public class InvoiceService {
	
	@Autowired
	InvoiceRepository invoiceRepository;
	
	@Autowired
	InvoiceConverter invoiceConverter;
	
	public List<Invoice> findAll() {
		return invoiceRepository.findAll();
	}
	
	public Invoice findOne(Long id) {
		Optional<Invoice> inv = invoiceRepository.findById(id);
		return inv.get();
	}
	
	public Invoice saveInvoice(InvoiceDTO dto) {
		Invoice inv = invoiceConverter.DtoToEntity(dto);
		return invoiceRepository.save(inv);
	}

	public Invoice deleteInvoice(Long id) {
		Invoice i = this.findOne(id);
		if(i == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant");
		}
		invoiceRepository.delete(i);
		return i;
	}

	public Invoice generate(Order order) {
		Set<OrderItem> items = order.getOrdetItems();
		Invoice newInvoice = new Invoice();
		newInvoice=invoiceRepository.save(newInvoice);
		newInvoice.setInvoiceNum(newInvoice.getId().intValue());
		Date today = new Date();
		newInvoice.setAccountingDate(today);
		newInvoice.setCurrencyDate(today);
		newInvoice.setInvoiceDate(today);
		newInvoice.setBusinessYear(order.getBusinessYear());
		newInvoice.setBuyer(order.getBuyer());
		newInvoice.setSeller(order.getSeller());
		newInvoice.setAccountNum(order.getBusinessYear().getCompany().getAccountNum());
		newInvoice.setAccountNumExtra(order.getBusinessYear().getCompany().getAccountNumExtra());
		newInvoice.setInvoiceType(InvoiceType.formating);
		newInvoice=invoiceRepository.save(newInvoice);
		newInvoice.setGoodsTotal(0); //pocetni sumovi
		newInvoice.setDiscount(0); //pocetni sumovi
		newInvoice.setTax(0); //pocetni sumovi
		newInvoice.setTotalAmount(0); //pocetni sumovi
		for(OrderItem item : items){
			InvoiceItem newInvoiceItem = new InvoiceItem();
			newInvoiceItem.setCatalog(item.getCatalog());
			newInvoiceItem.setInvoice(newInvoice);
			newInvoiceItem.setName(item.getName());
			newInvoiceItem.setAmount(item.getAmount());
			for(PriceTableItem pti : item.getCatalog().getPriceTableItems()){
				if(pti.getItemName().equals(item.getName())){
					newInvoiceItem.setPrice(pti.getItemPrice()); //jedinicna cena
					break;
				}
			}
			float value = newInvoiceItem.getAmount()*newInvoiceItem.getPrice(); //vrednost = cena * kolicina
			newInvoiceItem.setValue(value);
			newInvoiceItem.setDiscountPercentage(0);
			if(newInvoiceItem.getAmount()>=5){
				newInvoiceItem.setDiscountPercentage(10);
			}
			if(newInvoiceItem.getAmount()>=20){
				newInvoiceItem.setDiscountPercentage(20);
			}
			float discount = newInvoiceItem.getValue()*newInvoiceItem.getDiscountPercentage()/100; //iznos rabata = vrednost * rabat procenat / 100
			newInvoiceItem.setDiscount(discount);
			float itemBase = newInvoiceItem.getValue()-newInvoiceItem.getDiscount(); //osnovica PDV = vrednost - iznos rabata
			newInvoiceItem.setItemBase(itemBase);
			newInvoiceItem.setTaxRate(item.getCatalog().getGroup().getTax().getActiveTaxRate().getTaxRate());
			float tax = newInvoiceItem.getItemBase()*newInvoiceItem.getTaxRate()/100; // iznos PDV = osnovicaPDV * PDV/100
			newInvoiceItem.setTax(tax);
			float totalAmount = itemBase+tax; // ukupan iznos = osnovica PDV + iznos PDV
			newInvoiceItem.setTotalAmount(totalAmount);
			newInvoice.setGoodsTotal(newInvoice.getGoodsTotal()+newInvoiceItem.getValue());
			newInvoice.setDiscount(newInvoice.getDiscount()+newInvoiceItem.getDiscount());
			newInvoice.setTax(newInvoice.getTax()+newInvoiceItem.getTax());
			newInvoice.setTotalAmount(newInvoice.getTotalAmount()+newInvoiceItem.getTotalAmount()); //sumirati sve na kraju
		}
		newInvoice.setInvoiceType(InvoiceType.calculated);
		newInvoice=invoiceRepository.save(newInvoice);
		return newInvoice;
	}

	public Invoice export(Invoice invoice) throws JAXBException {
		JAXBContext jc = JAXBContext.newInstance(Content.class);
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(invoice, System.out);
		return invoice;
	}

}
