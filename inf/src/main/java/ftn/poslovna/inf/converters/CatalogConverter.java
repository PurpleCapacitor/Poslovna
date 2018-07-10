package ftn.poslovna.inf.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ftn.poslovna.inf.domain.Catalog;
import ftn.poslovna.inf.dto.CatalogDTO;
import ftn.poslovna.inf.repository.GroupRepository;

@Component
public class CatalogConverter {
	
	@Autowired
	private GroupRepository groupRepository;
	
	public CatalogDTO entityToDto(Catalog entity) {
		CatalogDTO dto = new CatalogDTO();
		dto.setId(entity.getId());	
		dto.setGroupId(entity.getGroup().getId());
		return dto;
	}

	public Catalog DtoToEntity(CatalogDTO dto) {
		Catalog entity = new Catalog();
		entity.setId(dto.getId());
		entity.setGroup(groupRepository.findById(dto.getGroupId()).get());
		return entity;
	}
}
