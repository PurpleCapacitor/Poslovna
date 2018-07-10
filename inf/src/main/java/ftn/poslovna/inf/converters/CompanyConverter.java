package ftn.poslovna.inf.converters;

import ftn.poslovna.inf.domain.Company;
import ftn.poslovna.inf.dto.CompanyDTO;

public class CompanyConverter {

	public CompanyDTO entityToDto(Company entity) {
		CompanyDTO dto = new CompanyDTO();
		dto.setId(entity.getId());	
		dto.setName(entity.getName());
		return dto;
	}

	public Company DtoToEntity(CompanyDTO dto) {
		Company entity = new Company();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		return entity;
	}
	
}
