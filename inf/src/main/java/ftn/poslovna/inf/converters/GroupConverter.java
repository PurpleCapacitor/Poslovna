package ftn.poslovna.inf.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ftn.poslovna.inf.domain.Group;
import ftn.poslovna.inf.dto.GroupDTO;
import ftn.poslovna.inf.repository.CatalogRepository;
import ftn.poslovna.inf.repository.CompanyRepository;
import ftn.poslovna.inf.repository.TaxRepository;

@Component
public class GroupConverter {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	
	@Autowired
	private TaxRepository taxRepository;
	
	public GroupDTO entityToDto(Group entity) {
		GroupDTO dto = new GroupDTO();
		dto.setId(entity.getId());
		dto.setGroupName(entity.getGroupName());
		dto.setTaxId(entity.getTax().getId());
		dto.setCompanyId(entity.getCompany().getId());
		return dto;
	}

	public Group DtoToEntity(GroupDTO dto) {
		Group entity = new Group();
		entity.setId(dto.getId());
		entity.setGroupName(dto.getGroupName());
		entity.setCompany(companyRepository.findById(dto.getCompanyId()).get());
		entity.setTax(taxRepository.findById(dto.getTaxId()).get());		
		return entity;
	}

}
