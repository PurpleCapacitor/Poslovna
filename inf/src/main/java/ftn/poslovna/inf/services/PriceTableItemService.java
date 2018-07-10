package ftn.poslovna.inf.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.poslovna.inf.converters.PriceTableItemConverter;
import ftn.poslovna.inf.domain.PriceTableItem;
import ftn.poslovna.inf.dto.PriceTableItemDTO;
import ftn.poslovna.inf.repository.PriceTableItemRepository;

@Service
public class PriceTableItemService {
	
	@Autowired
	PriceTableItemRepository priceTableItemRepository;
	
	@Autowired
	PriceTableItemConverter priceTableItemConverter;
	
	public List<PriceTableItem> findAll() {
		return priceTableItemRepository.findAll();
	}
	
	public PriceTableItem findOne(Long id) {
		Optional<PriceTableItem> o = priceTableItemRepository.findById(id);
		return o.get();
	}
	
	public PriceTableItem save(PriceTableItemDTO dto) {
		PriceTableItem ord = priceTableItemConverter.DtoToEntity(dto);
		return priceTableItemRepository.save(ord);
	}

	public PriceTableItem delete(Long id) {
		PriceTableItem i = this.findOne(id);
		if(i == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant");
		}
		priceTableItemRepository.delete(i);
		return i;
	}

}
