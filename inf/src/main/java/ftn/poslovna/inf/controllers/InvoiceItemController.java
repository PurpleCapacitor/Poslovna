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

import ftn.poslovna.inf.converters.InvoiceItemConverter;
import ftn.poslovna.inf.domain.InvoiceItem;
import ftn.poslovna.inf.dto.InvoiceItemDTO;
import ftn.poslovna.inf.services.InvoiceItemService;

@Controller
@RequestMapping(value="/invoiceItem")
public class InvoiceItemController {
	
	@Autowired
	private InvoiceItemService invoiceItemService;
	
	@Autowired
	private InvoiceItemConverter invoiceItemConverter;
	
	@RequestMapping(value="getInvoiceItems", method=RequestMethod.GET)
	public ResponseEntity<List<InvoiceItemDTO>> getInvoiceItems(){
		List<InvoiceItem> invoiceItems = invoiceItemService.findAll();
		List<InvoiceItemDTO> invoiceItemsDTO = new ArrayList<InvoiceItemDTO>();
		for(InvoiceItem invoiceItem : invoiceItems){
			invoiceItemsDTO.add(invoiceItemConverter.entityToDto(invoiceItem));
		}
		return new ResponseEntity<>(invoiceItemsDTO, HttpStatus.OK);		
	}	
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<InvoiceItemDTO> addInvoiceItem(@RequestBody InvoiceItemDTO invoiceItemDTO){
			
		InvoiceItem newInvoiceItem = invoiceItemService.saveInvoiceItem(invoiceItemDTO);
		return new ResponseEntity<>(invoiceItemConverter.entityToDto(newInvoiceItem), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<InvoiceItemDTO> getInvoiceItem(@PathVariable Long id) {
		InvoiceItem invoiceItem = invoiceItemService.findOne(id);
		if (invoiceItem == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(invoiceItemConverter.entityToDto(invoiceItem), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<InvoiceItemDTO> delete(@PathVariable Long id) {
		InvoiceItem deleted = invoiceItemService.deleteInvoiceItem(id);
		return new ResponseEntity<>(invoiceItemConverter.entityToDto(deleted), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<InvoiceItemDTO> edit(@RequestBody InvoiceItemDTO invoiceItemDTO) {
		InvoiceItem edited = invoiceItemService.saveInvoiceItem(invoiceItemDTO);
		return new ResponseEntity<>(invoiceItemConverter.entityToDto(edited), HttpStatus.OK);
	}

}
