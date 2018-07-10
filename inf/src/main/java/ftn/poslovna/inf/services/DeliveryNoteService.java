package ftn.poslovna.inf.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.poslovna.inf.converters.DeliveryNoteConverter;
import ftn.poslovna.inf.domain.DeliveryNote;
import ftn.poslovna.inf.dto.DeliveryNoteDTO;
import ftn.poslovna.inf.repository.DeliveryNoteRepository;

@Service
public class DeliveryNoteService {

	@Autowired
	DeliveryNoteRepository deliveryNoteRepository;
	
	@Autowired
	DeliveryNoteConverter deliveryNoteConverter;
	
	public List<DeliveryNote> findAll() {
		return deliveryNoteRepository.findAll();
	}
	
	public DeliveryNote findOne(Long id) {
		Optional<DeliveryNote> inv = deliveryNoteRepository.findById(id);
		return inv.get();
	}
	
	public DeliveryNote saveDeliveryNote(DeliveryNoteDTO dto) {
		DeliveryNote inv = deliveryNoteConverter.DtoToEntity(dto);
		return deliveryNoteRepository.save(inv);
	}

	public DeliveryNote deleteDeliveryNote(Long id) {
		DeliveryNote i = this.findOne(id);
		if(i == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant");
		}
		deliveryNoteRepository.delete(i);
		return i;
	}
	
}
