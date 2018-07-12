package ftn.poslovna.inf.services;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
import ftn.poslovna.inf.repository.InvoiceItemRepository;
import ftn.poslovna.inf.repository.InvoiceRepository;

@Service
public class InvoiceService {
	
	@Autowired
	InvoiceRepository invoiceRepository;
	
	@Autowired
	InvoiceItemRepository invoiceItemRepository;
	
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
		inv.setInvoiceDate(new Date());
		inv.setInvoiceType(InvoiceType.formating);
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
		Invoice invoice = new Invoice();
		invoice=invoiceRepository.save(invoice);
		invoice.setInvoiceNum(invoice.getId().intValue());
		Date today = new Date();
		invoice.setAccountingDate(today);
		invoice.setCurrencyDate(today);
		invoice.setInvoiceDate(today);
		invoice.setBusinessYear(order.getBusinessYear());
		invoice.setBuyer(order.getBuyer());
		invoice.setSeller(order.getSeller());
		invoice.setAccountNum(order.getBusinessYear().getCompany().getAccountNum());
		invoice.setAccountNumExtra(order.getBusinessYear().getCompany().getAccountNumExtra());
		invoice.setInvoiceType(InvoiceType.formating);
		invoice=invoiceRepository.save(invoice);
		invoice.setGoodsTotal(0); //pocetni sumovi
		invoice.setDiscount(0); //pocetni sumovi
		invoice.setTax(0); //pocetni sumovi
		invoice.setTotalAmount(0); //pocetni sumovi
		for(OrderItem item : items){
			InvoiceItem invoiceItem = new InvoiceItem();
			invoiceItem.setCatalog(item.getCatalog());
			invoiceItem.setInvoice(invoice);
			invoiceItem.setName(item.getName());
			invoiceItem.setAmount(item.getAmount());
			for(PriceTableItem pti : item.getCatalog().getPriceTableItems()){
				if(pti.getItemName().equals(item.getName())){
					invoiceItem.setPrice(pti.getItemPrice()); //jedinicna cena
					break;
				}
			}
			float value = invoiceItem.getAmount()*invoiceItem.getPrice(); //vrednost = cena * kolicina
			invoiceItem.setValue(value);
			invoiceItem.setDiscountPercentage(0);
			if(invoiceItem.getAmount()>=5){
				invoiceItem.setDiscountPercentage(10);
			}
			if(invoiceItem.getAmount()>=20){
				invoiceItem.setDiscountPercentage(20);
			}
			float discount = invoiceItem.getValue()*invoiceItem.getDiscountPercentage()/100; //iznos rabata = vrednost * rabat procenat / 100
			invoiceItem.setDiscount(discount);
			float itemBase = invoiceItem.getValue()-invoiceItem.getDiscount(); //osnovica PDV = vrednost - iznos rabata
			invoiceItem.setItemBase(itemBase);
			invoiceItem.setTaxRate(item.getCatalog().getGroup().getTax().getActiveTaxRate().getTaxRate());
			float tax = invoiceItem.getItemBase()*invoiceItem.getTaxRate()/100; // iznos PDV = osnovicaPDV * PDV/100
			invoiceItem.setTax(tax);
			float totalAmount = itemBase+tax; // ukupan iznos = osnovica PDV + iznos PDV
			invoiceItem.setTotalAmount(totalAmount);
			invoice.setGoodsTotal(invoice.getGoodsTotal()+invoiceItem.getValue());
			invoice.setDiscount(invoice.getDiscount()+invoiceItem.getDiscount());
			invoice.setTax(invoice.getTax()+invoiceItem.getTax());
			invoice.setTotalAmount(invoice.getTotalAmount()+invoiceItem.getTotalAmount()); //sumirati sve na kraju
			invoiceItemRepository.save(invoiceItem);
		}
		invoice.setInvoiceType(InvoiceType.calculated);
		invoice=invoiceRepository.save(invoice);
		return invoice;
	}

	public Invoice export(Invoice invoice) throws JAXBException {
		JAXBContext jc = JAXBContext.newInstance(Invoice.class);
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(invoice, System.out);
		String fileName="invoice"+invoice.getId()+".xml";				
		marshaller.marshal(invoice, new File(fileName));
		return invoice;
	}

	public Invoice facture(Invoice invoice) {
		invoice.setGoodsTotal(0); //pocetni sumovi
		invoice.setDiscount(0); //pocetni sumovi
		invoice.setTax(0); //pocetni sumovi
		invoice.setTotalAmount(0); //pocetni sumovi
		for(InvoiceItem invoiceItem : invoice.getInvoiceItems()){
			invoice.setGoodsTotal(invoice.getGoodsTotal()+invoiceItem.getValue());
			invoice.setDiscount(invoice.getDiscount()+invoiceItem.getDiscount());
			invoice.setTax(invoice.getTax()+invoiceItem.getTax());
			invoice.setTotalAmount(invoice.getTotalAmount()+invoiceItem.getTotalAmount()); //sumirati sve na kraju
		}		
		invoice.setAccountingDate(new Date());
		invoice.setCurrencyDate(new Date());
		invoice.setInvoiceType(InvoiceType.calculated);
		return invoiceRepository.save(invoice);
	}

}
