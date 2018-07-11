package ftn.poslovna.inf.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ftn.poslovna.inf.domain.DeliveryNote;
import ftn.poslovna.inf.dto.DeliveryNoteDTO;
import ftn.poslovna.inf.repository.BusinessPartnerRepository;
import ftn.poslovna.inf.repository.BusinessYearRepository;
import ftn.poslovna.inf.repository.InvoiceRepository;
import ftn.poslovna.inf.repository.OrderRepository;

@Component
public class DeliveryNoteConverter {

	@Autowired
	private BusinessPartnerRepository businessPartnerRepository;
	
	@Autowired
	private BusinessYearRepository businessYearRepository;
	
	@Autowired
	private InvoiceRepository invoiceRepository;
	
	@Autowired
	private OrderRepository orderRepository;	
	
	public DeliveryNoteDTO entityToDto(DeliveryNote entity) {
		DeliveryNoteDTO dto = new DeliveryNoteDTO();
		dto.setId(entity.getId());	
		dto.setBuyerId(entity.getBuyer().getId());
		dto.setSellerId(entity.getSeller().getId());
		dto.setBusinessYearId(entity.getBusinessYear().getId());
		dto.setInvoiceId(entity.getInvoice().getId());	
		dto.setBuyerName(entity.getBuyer().getName());
		dto.setSellerName(entity.getSeller().getName());
		dto.setYearNumber(entity.getBusinessYear().getYearNumber());
		return dto;
	}

	public DeliveryNote DtoToEntity(DeliveryNoteDTO dto) {
		DeliveryNote entity = new DeliveryNote();
		entity.setId(dto.getId());
		entity.setBuyer(businessPartnerRepository.findById(dto.getBuyerId()).get());
		entity.setSeller(businessPartnerRepository.findById(dto.getSellerId()).get());
		entity.setBusinessYear(businessYearRepository.findById(dto.getBusinessYearId()).get());
		entity.setInvoice(invoiceRepository.findById(dto.getInvoiceId()).get());
		return entity;
	}
	
}
