package ftn.poslovna.inf.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.poslovna.inf.converters.BusinessPartnerConverter;
import ftn.poslovna.inf.domain.BusinessPartner;
import ftn.poslovna.inf.dto.BusinessPartnerDTO;
import ftn.poslovna.inf.repository.BusinessPartnerRepository;


@Service
public class BusinessPartnerService {

	@Autowired
	BusinessPartnerRepository BusinessPartnerRepository;
	
	@Autowired
	BusinessPartnerConverter BusinessPartnerConverter;
	
	public List<BusinessPartner> findAll() {
		return BusinessPartnerRepository.findAll();
	}
	
	public BusinessPartner findOne(Long id) {
		Optional<BusinessPartner> inv = BusinessPartnerRepository.findById(id);
		return inv.get();
	}
	
	public BusinessPartner saveBusinessPartner(BusinessPartnerDTO dto) {
		BusinessPartner inv = BusinessPartnerConverter.DtoToEntity(dto);
		return BusinessPartnerRepository.save(inv);
	}

	public BusinessPartner deleteBusinessPartner(Long id) {
		BusinessPartner i = this.findOne(id);
		if(i == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant");
		}
		BusinessPartnerRepository.delete(i);
		return i;
	}
	
}
