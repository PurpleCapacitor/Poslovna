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

import ftn.poslovna.inf.converters.PriceTableItemConverter;
import ftn.poslovna.inf.domain.PriceTableItem;
import ftn.poslovna.inf.dto.PriceTableItemDTO;
import ftn.poslovna.inf.services.PriceTableItemService;

@Controller
@RequestMapping(value="/priceTableItem")
public class PriceTableItemController {

	@Autowired
	private PriceTableItemService priceTableItemService;
	
	@Autowired
	private PriceTableItemConverter priceTableItemConverter;
	
	@RequestMapping(value="getPriceTableItems", method=RequestMethod.GET)
	public ResponseEntity<List<PriceTableItemDTO>> getPriceTableItems(){
		List<PriceTableItem> priceTableItems = priceTableItemService.findAll();
		List<PriceTableItemDTO> priceTableItemsDTO = new ArrayList<PriceTableItemDTO>();
		for(PriceTableItem priceTableItem : priceTableItems){
			priceTableItemsDTO.add(priceTableItemConverter.entityToDto(priceTableItem));
		}
		return new ResponseEntity<>(priceTableItemsDTO, HttpStatus.OK);		
	}	
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<PriceTableItemDTO> addPriceTableItem(@RequestBody PriceTableItemDTO priceTableItemDTO){
			
		PriceTableItem newPriceTableItem = priceTableItemService.save(priceTableItemDTO);
		return new ResponseEntity<>(priceTableItemConverter.entityToDto(newPriceTableItem), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<PriceTableItemDTO> getPriceTableItem(@PathVariable Long id) {
		PriceTableItem priceTableItem = priceTableItemService.findOne(id);
		if (priceTableItem == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(priceTableItemConverter.entityToDto(priceTableItem), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<PriceTableItemDTO> delete(@PathVariable Long id) {
		PriceTableItem deleted = priceTableItemService.delete(id);
		return new ResponseEntity<>(priceTableItemConverter.entityToDto(deleted), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<PriceTableItemDTO> edit(@RequestBody PriceTableItemDTO priceTableItemDTO) {
		PriceTableItem edited = priceTableItemService.save(priceTableItemDTO);
		return new ResponseEntity<>(priceTableItemConverter.entityToDto(edited), HttpStatus.OK);
	}
}
