package ftn.poslovna.inf.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ftn.poslovna.inf.domain.BusinessYear;
import ftn.poslovna.inf.dto.BusinessYearDTO;
import ftn.poslovna.inf.repository.CompanyRepository;

@Component
public class BusinessYearConverter {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	public BusinessYearDTO entityToDto(BusinessYear entity) {
		BusinessYearDTO dto = new BusinessYearDTO();
		dto.setCompanyId(entity.getCompany().getId());
		dto.setId(entity.getId());
		dto.setFinished(entity.isFinished());
		dto.setYearNumber(entity.getYearNumber());		
		return dto;
	}

	public BusinessYear DtoToEntity(BusinessYearDTO dto) {
		BusinessYear entity = new BusinessYear();
		entity.setCompany(companyRepository.findById(dto.getCompanyId()).get());
		entity.setId(dto.getId());
		entity.setFinished(dto.isFinished());
		entity.setYearNumber(dto.getYearNumber());
		return entity;
	}

}
