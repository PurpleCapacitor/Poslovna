package ftn.poslovna.inf.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ftn.poslovna.inf.domain.InvoiceItem;
import ftn.poslovna.inf.dto.InvoiceItemDTO;
import ftn.poslovna.inf.repository.CatalogRepository;
import ftn.poslovna.inf.repository.InvoiceRepository;

@Component
public class InvoiceItemConverter {

	@Autowired
	CatalogRepository catalogRepository;

	@Autowired
	InvoiceRepository invoiceRepository;

	public InvoiceItemDTO entityToDto(InvoiceItem entity) {
		InvoiceItemDTO dto = new InvoiceItemDTO();
		dto.setId(entity.getId());
		dto.setAmount(entity.getAmount());
		dto.setCatalogId(entity.getCatalog().getId());
		dto.setDiscount(entity.getDiscount());
		dto.setDiscountPercentage(entity.getDiscountPercentage());
		dto.setItemBase(entity.getItemBase());
		dto.setName(entity.getName());
		dto.setPrice(entity.getPrice());
		dto.setTax(entity.getTax());
		dto.setTaxRate(entity.getTaxRate());
		dto.setTotalAmount(entity.getTotalAmount());
		dto.setValue(entity.getValue());
		dto.setInvoiceId(entity.getInvoice().getId());

		return dto;
	}

	public InvoiceItem DtoToEntity(InvoiceItemDTO dto) {
		InvoiceItem entity = new InvoiceItem();
		entity.setId(dto.getId());
		entity.setAmount(dto.getAmount());
		entity.setCatalog(catalogRepository.findById(dto.getCatalogId()).get());
		entity.setDiscount(dto.getDiscount());
		entity.setDiscountPercentage(dto.getDiscountPercentage());
		entity.setInvoice(invoiceRepository.findById(dto.getInvoiceId()).get());
		entity.setItemBase(dto.getItemBase());
		entity.setName(dto.getName());
		entity.setPrice(dto.getPrice());
		entity.setTax(dto.getTax());
		entity.setTaxRate(dto.getTaxRate());
		entity.setTotalAmount(dto.getTotalAmount());
		entity.setValue(dto.getValue());

		return entity;
	}

}
