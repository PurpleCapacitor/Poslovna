package ftn.poslovna.inf.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.poslovna.inf.converters.InvoiceItemConverter;
import ftn.poslovna.inf.domain.InvoiceItem;
import ftn.poslovna.inf.domain.PriceTableItem;
import ftn.poslovna.inf.dto.InvoiceItemDTO;
import ftn.poslovna.inf.repository.InvoiceItemRepository;


@Service
public class InvoiceItemService {
	
	@Autowired
	InvoiceItemRepository invoiceItemRepository;
	
	@Autowired
	InvoiceItemConverter invoiceItemConverter;
	
	public List<InvoiceItem> findAll() {
		return invoiceItemRepository.findAll();
	}
	
	public InvoiceItem findOne(Long id) {
		Optional<InvoiceItem> inv = invoiceItemRepository.findById(id);
		return inv.get();
	}
	
	public InvoiceItem saveInvoiceItem(InvoiceItemDTO dto) {
		InvoiceItem inv = invoiceItemConverter.DtoToEntity(dto);
		for(PriceTableItem pti : inv.getCatalog().getPriceTableItems()){
			if(pti.getItemName().equals(inv.getName())){
				inv.setPrice(pti.getItemPrice()); //jedinicna cena
				break;
			}
		}
		float value = inv.getAmount()*inv.getPrice(); //vrednost = cena * kolicina
		inv.setValue(value);
		inv.setDiscountPercentage(0);
		if(inv.getAmount()>=5){
			inv.setDiscountPercentage(10);
		}
		if(inv.getAmount()>=20){
			inv.setDiscountPercentage(20);
		}
		float discount = inv.getValue()*inv.getDiscountPercentage()/100; //iznos rabata = vrednost * rabat procenat / 100
		inv.setDiscount(discount);
		float itemBase = inv.getValue()-inv.getDiscount(); //osnovica PDV = vrednost - iznos rabata
		inv.setItemBase(itemBase);
		inv.setTaxRate(inv.getCatalog().getGroup().getTax().getActiveTaxRate().getTaxRate());
		float tax = inv.getItemBase()*inv.getTaxRate()/100; // iznos PDV = osnovicaPDV * PDV/100
		inv.setTax(tax);
		float totalAmount = itemBase+tax; // ukupan iznos = osnovica PDV + iznos PDV
		inv.setTotalAmount(totalAmount);
		return invoiceItemRepository.save(inv);
	}

	public InvoiceItem deleteInvoiceItem(Long id) {
		InvoiceItem i = this.findOne(id);
		if(i == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant");
		}
		invoiceItemRepository.delete(i);
		return i;
	}
}
