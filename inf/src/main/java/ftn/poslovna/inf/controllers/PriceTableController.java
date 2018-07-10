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

import ftn.poslovna.inf.converters.PriceTableConverter;
import ftn.poslovna.inf.domain.PriceTable;
import ftn.poslovna.inf.dto.PriceTableDTO;
import ftn.poslovna.inf.services.PriceTableService;

@Controller
@RequestMapping(value="/priceTable")
public class PriceTableController {
	
	@Autowired
	private PriceTableService priceTableService;
	
	@Autowired
	private PriceTableConverter priceTableConverter;
	
	@RequestMapping(value="getPriceTables", method=RequestMethod.GET)
	public ResponseEntity<List<PriceTableDTO>> getPriceTables(){
		List<PriceTable> priceTables = priceTableService.findAll();
		List<PriceTableDTO> priceTablesDTO = new ArrayList<PriceTableDTO>();
		for(PriceTable priceTable : priceTables){
			priceTablesDTO.add(priceTableConverter.entityToDto(priceTable));
		}
		return new ResponseEntity<>(priceTablesDTO, HttpStatus.OK);		
	}	
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<PriceTableDTO> addPriceTable(@RequestBody PriceTableDTO priceTableDTO){
			
		PriceTable newPriceTable = priceTableService.save(priceTableDTO);
		return new ResponseEntity<>(priceTableConverter.entityToDto(newPriceTable), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<PriceTableDTO> getPriceTable(@PathVariable Long id) {
		PriceTable priceTable = priceTableService.findOne(id);
		if (priceTable == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(priceTableConverter.entityToDto(priceTable), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<PriceTableDTO> delete(@PathVariable Long id) {
		PriceTable deleted = priceTableService.delete(id);
		return new ResponseEntity<>(priceTableConverter.entityToDto(deleted), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<PriceTableDTO> edit(@RequestBody PriceTableDTO priceTableDTO) {
		PriceTable edited = priceTableService.save(priceTableDTO);
		return new ResponseEntity<>(priceTableConverter.entityToDto(edited), HttpStatus.OK);
	}

}
