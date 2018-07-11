package ftn.poslovna.inf.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ftn.poslovna.inf.domain.BusinessPartner;
import ftn.poslovna.inf.domain.PartnerType;
import ftn.poslovna.inf.dto.BusinessPartnerDTO;
import ftn.poslovna.inf.repository.CompanyRepository;

@Component
public class BusinessPartnerConverter {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	public BusinessPartnerDTO entityToDto(BusinessPartner entity) {
		BusinessPartnerDTO dto = new BusinessPartnerDTO();
		dto.setCompanyId(entity.getCompany().getId());
		dto.setId(entity.getId());
		dto.setName(entity.getName());	
		dto.setType(entity.getType().toString());
		dto.setCompanyName(entity.getCompany().getName());
		return dto;
	}

	public BusinessPartner DtoToEntity(BusinessPartnerDTO dto) {
		BusinessPartner entity = new BusinessPartner();
		entity.setCompany(companyRepository.findById(dto.getCompanyId()).get());
		entity.setId(dto.getId());
		entity.setName(dto.getName());	
		entity.setType(PartnerType.valueOf(dto.getType()));		
		return entity;
	}

}
