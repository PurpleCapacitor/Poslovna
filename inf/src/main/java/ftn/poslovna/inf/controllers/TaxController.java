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

import ftn.poslovna.inf.converters.TaxConverter;
import ftn.poslovna.inf.domain.Tax;
import ftn.poslovna.inf.dto.TaxDTO;
import ftn.poslovna.inf.services.TaxService;

@Controller
@RequestMapping(value="/tax")
public class TaxController {
	
	@Autowired
	private TaxService taxService;
	
	@Autowired
	private TaxConverter taxConverter;
	
	@RequestMapping(value="getTaxes", method=RequestMethod.GET)
	public ResponseEntity<List<TaxDTO>> getTaxes(){
		List<Tax> taxes = taxService.findAll();
		List<TaxDTO> taxesDTO = new ArrayList<TaxDTO>();
		for(Tax tax : taxes){
			taxesDTO.add(taxConverter.entityToDto(tax));
		}
		return new ResponseEntity<>(taxesDTO, HttpStatus.OK);		
	}	
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<TaxDTO> addTax(@RequestBody TaxDTO taxDTO){
			
		Tax newTax = taxService.save(taxDTO);
		return new ResponseEntity<>(taxConverter.entityToDto(newTax), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<TaxDTO> getTax(@PathVariable Long id) {
		Tax tax = taxService.findOne(id);
		if (tax == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(taxConverter.entityToDto(tax), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<TaxDTO> delete(@PathVariable Long id) {
		Tax deleted = taxService.delete(id);
		if(deleted==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<>(taxConverter.entityToDto(deleted), HttpStatus.OK);
		}
		
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<TaxDTO> edit(@RequestBody TaxDTO taxDTO) {
		Tax edited = taxService.save(taxDTO);
		return new ResponseEntity<>(taxConverter.entityToDto(edited), HttpStatus.OK);
	}

}
