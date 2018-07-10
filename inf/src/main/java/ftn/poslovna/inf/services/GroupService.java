package ftn.poslovna.inf.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.poslovna.inf.converters.GroupConverter;
import ftn.poslovna.inf.domain.Group;
import ftn.poslovna.inf.dto.GroupDTO;
import ftn.poslovna.inf.repository.GroupRepository;

@Service
public class GroupService {
	
	@Autowired
	GroupRepository groupRepository;
	
	@Autowired
	GroupConverter groupConverter;
	
	public List<Group> findAll() {
		return groupRepository.findAll();
	}
	
	public Group findOne(Long id) {
		Optional<Group> inv = groupRepository.findById(id);
		return inv.get();
	}
	
	public Group saveGroup(GroupDTO dto) {
		Group inv = groupConverter.DtoToEntity(dto);
		return groupRepository.save(inv);
	}

	public Group deleteGroup(Long id) {
		Group i = this.findOne(id);
		if(i == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant");
		}
		groupRepository.delete(i);
		return i;
	}
	
}
