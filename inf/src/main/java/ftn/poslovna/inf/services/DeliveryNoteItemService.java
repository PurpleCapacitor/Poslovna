package ftn.poslovna.inf.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.poslovna.inf.converters.DeliveryNoteItemConverter;
import ftn.poslovna.inf.domain.DeliveryNoteItem;
import ftn.poslovna.inf.dto.DeliveryNoteItemDTO;
import ftn.poslovna.inf.repository.DeliveryNoteItemRepository;

@Service
public class DeliveryNoteItemService {

	@Autowired
	DeliveryNoteItemRepository deliveryNoteItemRepository;
	
	@Autowired
	DeliveryNoteItemConverter deliveryNoteItemConverter;
	
	public List<DeliveryNoteItem> findAll() {
		return deliveryNoteItemRepository.findAll();
	}
	
	public DeliveryNoteItem findOne(Long id) {
		Optional<DeliveryNoteItem> inv = deliveryNoteItemRepository.findById(id);
		return inv.get();
	}
	
	public DeliveryNoteItem saveDeliveryNoteItem(DeliveryNoteItemDTO dto) {
		DeliveryNoteItem inv = deliveryNoteItemConverter.DtoToEntity(dto);
		return deliveryNoteItemRepository.save(inv);
	}

	public DeliveryNoteItem deleteDeliveryNoteItem(Long id) {
		DeliveryNoteItem i = this.findOne(id);
		if(i == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant");
		}
		deliveryNoteItemRepository.delete(i);
		return i;
	}
}
