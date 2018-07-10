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

import ftn.poslovna.inf.converters.DeliveryNoteItemConverter;
import ftn.poslovna.inf.domain.DeliveryNoteItem;
import ftn.poslovna.inf.dto.DeliveryNoteItemDTO;
import ftn.poslovna.inf.services.DeliveryNoteItemService;

@Controller
@RequestMapping(value="/deliveryNoteItem")
public class DeliveryNoteItemController {

	@Autowired
	private DeliveryNoteItemService deliveryNoteItemService;
	
	@Autowired
	private DeliveryNoteItemConverter deliveryNoteItemConverter;
	
	@RequestMapping(value="getDeliveryNoteItems", method=RequestMethod.GET)
	public ResponseEntity<List<DeliveryNoteItemDTO>> getDeliveryNoteItems(){
		List<DeliveryNoteItem> deliveryNoteItems = deliveryNoteItemService.findAll();
		List<DeliveryNoteItemDTO> deliveryNoteItemsDTO = new ArrayList<DeliveryNoteItemDTO>();
		for(DeliveryNoteItem deliveryNoteItem : deliveryNoteItems){
			deliveryNoteItemsDTO.add(deliveryNoteItemConverter.entityToDto(deliveryNoteItem));
		}
		return new ResponseEntity<>(deliveryNoteItemsDTO, HttpStatus.OK);		
	}	
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<DeliveryNoteItemDTO> addDeliveryNoteItem(@RequestBody DeliveryNoteItemDTO deliveryNoteItemDTO){
			
		DeliveryNoteItem newDeliveryNoteItem = deliveryNoteItemService.saveDeliveryNoteItem(deliveryNoteItemDTO);
		return new ResponseEntity<>(deliveryNoteItemConverter.entityToDto(newDeliveryNoteItem), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<DeliveryNoteItemDTO> getDeliveryNoteItem(@PathVariable Long id) {
		DeliveryNoteItem deliveryNoteItem = deliveryNoteItemService.findOne(id);
		if (deliveryNoteItem == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(deliveryNoteItemConverter.entityToDto(deliveryNoteItem), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<DeliveryNoteItemDTO> delete(@PathVariable Long id) {
		DeliveryNoteItem deleted = deliveryNoteItemService.deleteDeliveryNoteItem(id);
		return new ResponseEntity<>(deliveryNoteItemConverter.entityToDto(deleted), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<DeliveryNoteItemDTO> edit(@RequestBody DeliveryNoteItemDTO deliveryNoteItemDTO) {
		DeliveryNoteItem edited = deliveryNoteItemService.saveDeliveryNoteItem(deliveryNoteItemDTO);
		return new ResponseEntity<>(deliveryNoteItemConverter.entityToDto(edited), HttpStatus.OK);
	}
	
}