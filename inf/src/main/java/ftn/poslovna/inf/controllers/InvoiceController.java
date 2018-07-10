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

import ftn.poslovna.inf.converters.InvoiceConverter;
import ftn.poslovna.inf.domain.Invoice;
import ftn.poslovna.inf.domain.Order;
import ftn.poslovna.inf.dto.InvoiceDTO;
import ftn.poslovna.inf.services.InvoiceService;
import ftn.poslovna.inf.services.OrderService;

@Controller
@RequestMapping(value="/invoice")
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private InvoiceConverter invoiceConverter;
	
	@RequestMapping(value="getInvoices", method=RequestMethod.GET)
	public ResponseEntity<List<InvoiceDTO>> getInvoices(){
		List<Invoice> invoices = invoiceService.findAll();
		List<InvoiceDTO> invoicesDTO = new ArrayList<InvoiceDTO>();
		for(Invoice invoice : invoices){
			invoicesDTO.add(invoiceConverter.entityToDto(invoice));
		}
		return new ResponseEntity<>(invoicesDTO, HttpStatus.OK);		
	}	
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<InvoiceDTO> addInvoice(@RequestBody InvoiceDTO invoiceDTO){
			
		Invoice newInvoice = invoiceService.saveInvoice(invoiceDTO);
		return new ResponseEntity<>(invoiceConverter.entityToDto(newInvoice), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<InvoiceDTO> getInvoice(@PathVariable Long id) {
		Invoice invoice = invoiceService.findOne(id);
		if (invoice == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(invoiceConverter.entityToDto(invoice), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<InvoiceDTO> delete(@PathVariable Long id) {
		Invoice deleted = invoiceService.deleteInvoice(id);
		return new ResponseEntity<>(invoiceConverter.entityToDto(deleted), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<InvoiceDTO> edit(@RequestBody InvoiceDTO invoiceDTO) {
		Invoice edited = invoiceService.saveInvoice(invoiceDTO);
		return new ResponseEntity<>(invoiceConverter.entityToDto(edited), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/generate/{id}" , method = RequestMethod.POST)
	public ResponseEntity<InvoiceDTO> generate(@PathVariable Long id) {
		Order order = orderService.findOne(id);
		Invoice generated = invoiceService.generate(order);
		return new ResponseEntity<>(invoiceConverter.entityToDto(generated), HttpStatus.OK);		
	}
	
}
