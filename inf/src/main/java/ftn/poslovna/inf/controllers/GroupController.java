package ftn.poslovna.inf.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ftn.poslovna.inf.converters.GroupConverter;
import ftn.poslovna.inf.domain.Group;
import ftn.poslovna.inf.dto.GroupDTO;
import ftn.poslovna.inf.services.GroupService;

@Controller
@RequestMapping(value="/group")
public class GroupController {

	@Autowired
	private GroupService groupService;
	
	@Autowired
	private GroupConverter groupConverter;
	
	@RequestMapping(value="getGroups", method=RequestMethod.GET)
	public ResponseEntity<List<GroupDTO>> getGroups(){
		List<Group> groups = groupService.findAll();
		List<GroupDTO> groupsDTO = new ArrayList<GroupDTO>();
		for(Group group : groups){
			groupsDTO.add(groupConverter.entityToDto(group));
		}
		return new ResponseEntity<>(groupsDTO, HttpStatus.OK);		
	}	
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<GroupDTO> addGroup(@RequestBody GroupDTO groupDTO){
			
		Group newGroup = groupService.saveGroup(groupDTO);
		return new ResponseEntity<>(groupConverter.entityToDto(newGroup), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<GroupDTO> getGroup(@PathVariable Long id) {
		Group group = groupService.findOne(id);
		if (group == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(groupConverter.entityToDto(group), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<GroupDTO> delete(@PathVariable Long id) {
		Group deleted = groupService.deleteGroup(id);
		if(deleted==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<>(groupConverter.entityToDto(deleted), HttpStatus.OK);
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<GroupDTO> edit(@RequestBody GroupDTO groupDTO) {
		Group edited = groupService.saveGroup(groupDTO);
		return new ResponseEntity<>(groupConverter.entityToDto(edited), HttpStatus.OK);
	}
	
}
