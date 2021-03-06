package ftn.poslovna.inf.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ftn.poslovna.inf.domain.Invoice;
import ftn.poslovna.inf.domain.InvoiceType;
import ftn.poslovna.inf.dto.InvoiceDTO;
import ftn.poslovna.inf.repository.BusinessPartnerRepository;
import ftn.poslovna.inf.repository.BusinessYearRepository;
import ftn.poslovna.inf.repository.DeliveryNoteRepository;

@Component
public class InvoiceConverter {
	
	@Autowired
	private BusinessPartnerRepository businessPartnerRepository;
	
	@Autowired
	private BusinessYearRepository businessYearRepository;
	
	@Autowired
	private DeliveryNoteRepository deliveryNoteRepository;
	
	
	public InvoiceDTO entityToDto(Invoice entity) {
		InvoiceDTO dto = new InvoiceDTO();
		dto.setId(entity.getId());
		dto.setAccountingDate(entity.getAccountingDate());
		dto.setAccountNum(entity.getAccountNum());
		dto.setAccountNumExtra(entity.getAccountNumExtra());
		dto.setBuyerId(entity.getBuyer().getId());
		dto.setSellerId(entity.getSeller().getId());
		dto.setBusinessYearId(entity.getBusinessYear().getId());
		dto.setCurrencyDate(entity.getCurrencyDate());
		if(entity.getDeliveryNote()!=null){
			dto.setDeliveryNoteId(entity.getDeliveryNote().getId());
		}
		dto.setDiscount(entity.getDiscount());
		dto.setGoodsTotal(entity.getGoodsTotal());
		dto.setInvoiceDate(entity.getInvoiceDate());
		dto.setInvoiceNum(entity.getInvoiceNum());
		dto.setInvoiceType(entity.getInvoiceType().toString());
		dto.setTax(entity.getTax());
		dto.setTotalAmount(entity.getTotalAmount());
		dto.setYearNumber(entity.getBusinessYear().getYearNumber());
		dto.setSellerName(entity.getSeller().getName());
		dto.setBuyerName(entity.getBuyer().getName());
		return dto;
	}

	public Invoice DtoToEntity(InvoiceDTO dto) {
		Invoice entity = new Invoice();
		entity.setId(dto.getId());
		entity.setAccountingDate(dto.getAccountingDate());
		entity.setAccountNum(dto.getAccountNum());
		entity.setAccountNumExtra(dto.getAccountNumExtra());
		entity.setBuyer(businessPartnerRepository.findById(dto.getBuyerId()).get());
		entity.setSeller(businessPartnerRepository.findById(dto.getSellerId()).get());
		entity.setBusinessYear(businessYearRepository.findById(dto.getBusinessYearId()).get());
		entity.setCurrencyDate(dto.getCurrencyDate());
		if(dto.getDeliveryNoteId()!=0){
			entity.setDeliveryNote(deliveryNoteRepository.findById(dto.getDeliveryNoteId()).get());
		}
		entity.setDiscount(dto.getDiscount());
		entity.setGoodsTotal(dto.getGoodsTotal());
		entity.setInvoiceDate(dto.getInvoiceDate());
		entity.setInvoiceNum(dto.getInvoiceNum());
		entity.setInvoiceType(InvoiceType.valueOf(dto.getInvoiceType()));
		entity.setTax(dto.getTax());
		entity.setTotalAmount(dto.getTotalAmount());
		return entity;
	}

}
