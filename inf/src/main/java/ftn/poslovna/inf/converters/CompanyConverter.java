package ftn.poslovna.inf.converters;

import org.springframework.stereotype.Component;

import ftn.poslovna.inf.domain.Company;
import ftn.poslovna.inf.dto.CompanyDTO;

@Component
public class CompanyConverter {

	public CompanyDTO entityToDto(Company entity) {
		CompanyDTO dto = new CompanyDTO();
		dto.setId(entity.getId());	
		dto.setName(entity.getName());
		dto.setAccountNum(entity.getAccountNum());
		dto.setAccountNumExtra(entity.getAccountNumExtra());
		return dto;
	}

	public Company DtoToEntity(CompanyDTO dto) {
		Company entity = new Company();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setAccountNum(dto.getAccountNum());
		entity.setAccountNumExtra(dto.getAccountNumExtra());
		return entity;
	}
	
}
