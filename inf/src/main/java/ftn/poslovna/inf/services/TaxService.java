package ftn.poslovna.inf.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.poslovna.inf.converters.TaxConverter;
import ftn.poslovna.inf.domain.Tax;
import ftn.poslovna.inf.dto.TaxDTO;
import ftn.poslovna.inf.repository.TaxRepository;

@Service
public class TaxService {
	
	@Autowired
	TaxRepository taxRepository;
	
	@Autowired
	TaxConverter taxConverter;
	
	public List<Tax> findAll() {
		return taxRepository.findAll();
	}
	
	public Tax findOne(Long id) {
		Optional<Tax> o = taxRepository.findById(id);
		return o.get();
	}
	
	public Tax save(TaxDTO dto) {
		Tax ord = taxConverter.DtoToEntity(dto);
		return taxRepository.save(ord);
	}

	public Tax delete(Long id) {
		Tax i = this.findOne(id);
		if(i == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant");
		}
		taxRepository.delete(i);
		return i;
	}

}
