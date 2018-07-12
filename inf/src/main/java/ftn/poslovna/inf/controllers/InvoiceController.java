package ftn.poslovna.inf.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ftn.poslovna.inf.converters.InvoiceConverter;
import ftn.poslovna.inf.converters.InvoiceItemConverter;
import ftn.poslovna.inf.domain.Company;
import ftn.poslovna.inf.domain.Invoice;
import ftn.poslovna.inf.domain.InvoiceItem;
import ftn.poslovna.inf.domain.Order;
import ftn.poslovna.inf.domain.OrderItem;
import ftn.poslovna.inf.domain.PriceTable;
import ftn.poslovna.inf.domain.PriceTableItem;
import ftn.poslovna.inf.dto.InvoiceDTO;
import ftn.poslovna.inf.dto.InvoiceItemDTO;
import ftn.poslovna.inf.dto.ItemDTO;
import ftn.poslovna.inf.dto.OrderItemDTO;
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
	
	@Autowired
	private InvoiceItemConverter invoiceItemConverter;
	
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
	
	@RequestMapping(value = "/facture/{id}" , method = RequestMethod.POST)
	public ResponseEntity<InvoiceDTO> facture(@PathVariable Long id) {
		Invoice Invoice = invoiceService.findOne(id);
		Invoice factured = invoiceService.facture(Invoice);
		return new ResponseEntity<>(invoiceConverter.entityToDto(factured), HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/generate/{id}" , method = RequestMethod.POST)
	public ResponseEntity<InvoiceDTO> generate(@PathVariable Long id) {
		Order order = orderService.findOne(id);
		Invoice generated = invoiceService.generate(order);
		return new ResponseEntity<>(invoiceConverter.entityToDto(generated), HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/export/{id}" , method = RequestMethod.POST)
	public ResponseEntity<InvoiceDTO> export(@PathVariable Long id) throws JAXBException {
		Invoice invoice = invoiceService.findOne(id);
		Invoice exported = invoiceService.export(invoice);
		return new ResponseEntity<>(invoiceConverter.entityToDto(exported), HttpStatus.OK);		
	}
	
	@RequestMapping(value="getInvoiceItems/{id}", method=RequestMethod.GET)
	public ResponseEntity<List<InvoiceItemDTO>> getInvoiceItems(@PathVariable Long id){
		Invoice invoice = invoiceService.findOne(id);
		List<InvoiceItemDTO> items = new ArrayList<InvoiceItemDTO>();
		for(InvoiceItem item : invoice.getInvoiceItems()){
			InvoiceItemDTO itemDTO = invoiceItemConverter.entityToDto(item);
			items.add(itemDTO);
		}
		return new ResponseEntity<>(items, HttpStatus.OK);		
	}
	
	@RequestMapping(value="getPriceItems/{id}", method=RequestMethod.GET)
	public ResponseEntity<List<ItemDTO>> getPriceItems(@PathVariable Long id){
		Invoice invoice = invoiceService.findOne(id);
		List<ItemDTO> items = new ArrayList<ItemDTO>();
		Company company = invoice.getSeller().getCompany();
		for(PriceTable pt : company.getPriceTables()){
			for(PriceTableItem pti: pt.getPriceTableItems()){
				ItemDTO item = new ItemDTO();
				item.setCatalogId(pti.getCatalog().getId());
				item.setItemName(pti.getItemName());
				items.add(item);
			}
		}
		return new ResponseEntity<>(items, HttpStatus.OK);		
	}
	
}
