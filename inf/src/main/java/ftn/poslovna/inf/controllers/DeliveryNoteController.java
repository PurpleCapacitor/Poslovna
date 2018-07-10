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

import ftn.poslovna.inf.converters.DeliveryNoteConverter;
import ftn.poslovna.inf.domain.DeliveryNote;
import ftn.poslovna.inf.domain.Invoice;
import ftn.poslovna.inf.domain.Order;
import ftn.poslovna.inf.dto.DeliveryNoteDTO;
import ftn.poslovna.inf.dto.InvoiceDTO;
import ftn.poslovna.inf.services.DeliveryNoteService;
import ftn.poslovna.inf.services.InvoiceService;

@Controller
@RequestMapping(value="/deliveryNote")
public class DeliveryNoteController {

	@Autowired
	private DeliveryNoteService deliveryNoteService;
	
	@Autowired
	private DeliveryNoteConverter deliveryNoteConverter;
	
	@Autowired
	private InvoiceService invoiceService;
	
	@RequestMapping(value="getDeliveryNotes", method=RequestMethod.GET)
	public ResponseEntity<List<DeliveryNoteDTO>> getDeliveryNotes(){
		List<DeliveryNote> deliveryNotes = deliveryNoteService.findAll();
		List<DeliveryNoteDTO> deliveryNotesDTO = new ArrayList<DeliveryNoteDTO>();
		for(DeliveryNote deliveryNote : deliveryNotes){
			deliveryNotesDTO.add(deliveryNoteConverter.entityToDto(deliveryNote));
		}
		return new ResponseEntity<>(deliveryNotesDTO, HttpStatus.OK);		
	}	
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<DeliveryNoteDTO> addDeliveryNote(@RequestBody DeliveryNoteDTO deliveryNoteDTO){
			
		DeliveryNote newDeliveryNote = deliveryNoteService.saveDeliveryNote(deliveryNoteDTO);
		return new ResponseEntity<>(deliveryNoteConverter.entityToDto(newDeliveryNote), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<DeliveryNoteDTO> getDeliveryNote(@PathVariable Long id) {
		DeliveryNote deliveryNote = deliveryNoteService.findOne(id);
		if (deliveryNote == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(deliveryNoteConverter.entityToDto(deliveryNote), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<DeliveryNoteDTO> delete(@PathVariable Long id) {
		DeliveryNote deleted = deliveryNoteService.deleteDeliveryNote(id);
		return new ResponseEntity<>(deliveryNoteConverter.entityToDto(deleted), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<DeliveryNoteDTO> edit(@RequestBody DeliveryNoteDTO deliveryNoteDTO) {
		DeliveryNote edited = deliveryNoteService.saveDeliveryNote(deliveryNoteDTO);
		return new ResponseEntity<>(deliveryNoteConverter.entityToDto(edited), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/generate/{id}" , method = RequestMethod.POST)
	public ResponseEntity<DeliveryNoteDTO> generate(@PathVariable Long id) {
		Invoice invoice = invoiceService.findOne(id);
		DeliveryNote generated = deliveryNoteService.generate(invoice);
		return new ResponseEntity<>(deliveryNoteConverter.entityToDto(generated), HttpStatus.OK);		
	}
	
}
