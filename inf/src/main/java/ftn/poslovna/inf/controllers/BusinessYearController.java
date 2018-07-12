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

import ftn.poslovna.inf.converters.BusinessYearConverter;
import ftn.poslovna.inf.domain.BusinessYear;
import ftn.poslovna.inf.dto.BusinessYearDTO;
import ftn.poslovna.inf.services.BusinessYearService;


@Controller
@RequestMapping(value="/businessYear")
public class BusinessYearController {

	@Autowired
	private BusinessYearService businessYearService;
	
	@Autowired
	private BusinessYearConverter businessYearConverter;
	
	@RequestMapping(value="getBusinessYears", method=RequestMethod.GET)
	public ResponseEntity<List<BusinessYearDTO>> getBusinessYears(){
		List<BusinessYear> businessYears = businessYearService.findAll();
		List<BusinessYearDTO> businessYearsDTO = new ArrayList<BusinessYearDTO>();
		for(BusinessYear businessYear : businessYears){
			businessYearsDTO.add(businessYearConverter.entityToDto(businessYear));
		}
		return new ResponseEntity<>(businessYearsDTO, HttpStatus.OK);		
	}	
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<BusinessYearDTO> addBusinessYear(@RequestBody BusinessYearDTO businessYearDTO){
			
		BusinessYear newBusinessYear = businessYearService.saveBusinessYear(businessYearDTO);
		return new ResponseEntity<>(businessYearConverter.entityToDto(newBusinessYear), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<BusinessYearDTO> getBusinessYear(@PathVariable Long id) {
		BusinessYear businessYear = businessYearService.findOne(id);
		if (businessYear == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(businessYearConverter.entityToDto(businessYear), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<BusinessYearDTO> delete(@PathVariable Long id) {
		BusinessYear deleted = businessYearService.deleteBusinessYear(id);
		if(deleted==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<>(businessYearConverter.entityToDto(deleted), HttpStatus.OK);
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<BusinessYearDTO> edit(@RequestBody BusinessYearDTO businessYearDTO) {
		BusinessYear edited = businessYearService.saveBusinessYear(businessYearDTO);
		return new ResponseEntity<>(businessYearConverter.entityToDto(edited), HttpStatus.OK);
	}
	
}
