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

import ftn.poslovna.inf.converters.TaxRateConverter;
import ftn.poslovna.inf.domain.TaxRate;
import ftn.poslovna.inf.dto.TaxRateDTO;
import ftn.poslovna.inf.services.TaxRateService;

@Controller
@RequestMapping(value="/taxRate")
public class TaxRateController {
	
	@Autowired
	private TaxRateService taxRateService;
	
	@Autowired
	private TaxRateConverter taxRateConverter;
	
	@RequestMapping(value="getTaxRates", method=RequestMethod.GET)
	public ResponseEntity<List<TaxRateDTO>> getTaxRates(){
		List<TaxRate> taxRates = taxRateService.findAll();
		List<TaxRateDTO> taxRatesDTO = new ArrayList<TaxRateDTO>();
		for(TaxRate taxRate : taxRates){
			taxRatesDTO.add(taxRateConverter.entityToDto(taxRate));
		}
		return new ResponseEntity<>(taxRatesDTO, HttpStatus.OK);		
	}	
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<TaxRateDTO> addTaxRate(@RequestBody TaxRateDTO taxRateDTO){
			
		TaxRate newTaxRate = taxRateService.save(taxRateDTO);
		return new ResponseEntity<>(taxRateConverter.entityToDto(newTaxRate), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<TaxRateDTO> getTaxRate(@PathVariable Long id) {
		TaxRate taxRate = taxRateService.findOne(id);
		if (taxRate == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(taxRateConverter.entityToDto(taxRate), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<TaxRateDTO> delete(@PathVariable Long id) {
		TaxRate deleted = taxRateService.delete(id);
		return new ResponseEntity<>(taxRateConverter.entityToDto(deleted), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<TaxRateDTO> edit(@RequestBody TaxRateDTO taxRateDTO) {
		TaxRate edited = taxRateService.save(taxRateDTO);
		return new ResponseEntity<>(taxRateConverter.entityToDto(edited), HttpStatus.OK);
	}

}
