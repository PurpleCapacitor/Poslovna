package ftn.poslovna.inf.converters;

import org.springframework.beans.factory.annotation.Autowired;

import ftn.poslovna.inf.domain.DeliveryNoteItem;
import ftn.poslovna.inf.dto.DeliveryNoteItemDTO;
import ftn.poslovna.inf.repository.CatalogRepository;
import ftn.poslovna.inf.repository.DeliveryNoteRepository;

public class DeliveryNoteItemConverter {

	@Autowired
	private CatalogRepository catalogRepository;
	
	@Autowired
	private DeliveryNoteRepository deliveryNoteRepository;
	
	
	public DeliveryNoteItemDTO entityToDto(DeliveryNoteItem entity) {
		DeliveryNoteItemDTO dto = new DeliveryNoteItemDTO();
		dto.setId(entity.getId());	
		dto.setAmount(entity.getAmount());
		dto.setCatalogId(entity.getCatalog().getId());
		dto.setDeliveryNoteId(entity.getDeliveryNote().getId());
		dto.setName(entity.getName());
		dto.setPrice(entity.getPrice());
		return dto;
	}

	public DeliveryNoteItem DtoToEntity(DeliveryNoteItemDTO dto) {
		DeliveryNoteItem entity = new DeliveryNoteItem();
		entity.setId(dto.getId());
		entity.setAmount(dto.getAmount());
		entity.setCatalog(catalogRepository.findById(dto.getCatalogId()).get());
		entity.setDeliveryNote(deliveryNoteRepository.findById(dto.getDeliveryNoteId()).get());
		entity.setName(dto.getName());
		entity.setPrice(dto.getPrice());
		return entity;
	}
	
}
