package ftn.poslovna.inf.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.poslovna.inf.converters.TaxRateConverter;
import ftn.poslovna.inf.domain.TaxRate;
import ftn.poslovna.inf.dto.TaxRateDTO;
import ftn.poslovna.inf.repository.TaxRateRepository;

@Service
public class TaxRateService {
	
	@Autowired
	TaxRateRepository taxRateRepository;
	
	@Autowired
	TaxRateConverter taxRateConverter;
	
	public List<TaxRate> findAll() {
		return taxRateRepository.findAll();
	}
	
	public TaxRate findOne(Long id) {
		Optional<TaxRate> o = taxRateRepository.findById(id);
		return o.get();
	}
	
	public TaxRate save(TaxRateDTO dto) {
		TaxRate ord = taxRateConverter.DtoToEntity(dto);
		return taxRateRepository.save(ord);
	}

	public TaxRate delete(Long id) {
		TaxRate i = this.findOne(id);
		if(i == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant");
		}
		
		if(i.getTax().getGroups().isEmpty()) {
			taxRateRepository.delete(i);
			return i;
		}else {
			return null;
		}
		
		
	}

}
