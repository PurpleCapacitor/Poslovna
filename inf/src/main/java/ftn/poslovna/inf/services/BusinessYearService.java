package ftn.poslovna.inf.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import ftn.poslovna.inf.converters.BusinessYearConverter;
import ftn.poslovna.inf.domain.BusinessYear;
import ftn.poslovna.inf.dto.BusinessYearDTO;
import ftn.poslovna.inf.repository.BusinessYearRepository;

public class BusinessYearService {

	@Autowired
	BusinessYearRepository businessYearRepository;
	
	@Autowired
	BusinessYearConverter businessYearConverter;
	
	public List<BusinessYear> findAll() {
		return businessYearRepository.findAll();
	}
	
	public BusinessYear findOne(Long id) {
		Optional<BusinessYear> inv = businessYearRepository.findById(id);
		return inv.get();
	}
	
	public BusinessYear saveBusinessYear(BusinessYearDTO dto) {
		BusinessYear inv = businessYearConverter.DtoToEntity(dto);
		return businessYearRepository.save(inv);
	}

	public BusinessYear deleteBusinessYear(Long id) {
		BusinessYear i = this.findOne(id);
		if(i == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant");
		}
		businessYearRepository.delete(i);
		return i;
	}
	
}
