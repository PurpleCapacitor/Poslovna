package ftn.poslovna.inf.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.poslovna.inf.converters.PriceTableConverter;
import ftn.poslovna.inf.domain.PriceTable;
import ftn.poslovna.inf.dto.PriceTableDTO;
import ftn.poslovna.inf.repository.PriceTableRepository;

@Service
public class PriceTableService {
	
	@Autowired
	PriceTableRepository priceTableRepository;
	
	@Autowired
	PriceTableConverter priceTableConverter;
	
	public List<PriceTable> findAll() {
		return priceTableRepository.findAll();
	}
	
	public PriceTable findOne(Long id) {
		Optional<PriceTable> o = priceTableRepository.findById(id);
		return o.get();
	}
	
	public PriceTable save(PriceTableDTO dto) {
		PriceTable ord = priceTableConverter.DtoToEntity(dto);
		return priceTableRepository.save(ord);
	}

	public PriceTable delete(Long id) {
		PriceTable i = this.findOne(id);
		if(i == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant");
		}
		priceTableRepository.delete(i);
		return i;
	}

}
