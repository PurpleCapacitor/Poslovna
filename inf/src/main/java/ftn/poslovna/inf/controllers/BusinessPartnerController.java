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

import ftn.poslovna.inf.converters.BusinessPartnerConverter;
import ftn.poslovna.inf.domain.BusinessPartner;
import ftn.poslovna.inf.domain.DeliveryNote;
import ftn.poslovna.inf.domain.Invoice;
import ftn.poslovna.inf.domain.Order;
import ftn.poslovna.inf.dto.BusinessPartnerDTO;
import ftn.poslovna.inf.services.BusinessPartnerService;
import ftn.poslovna.inf.services.DeliveryNoteService;
import ftn.poslovna.inf.services.InvoiceService;
import ftn.poslovna.inf.services.OrderService;

@Controller
@RequestMapping(value="/businessPartner")
public class BusinessPartnerController {
	
	@Autowired
	private BusinessPartnerService businessPartnerService;
	
	@Autowired
	private BusinessPartnerConverter businessPartnerConverter;
	
	@Autowired
	private DeliveryNoteService deliveryNoteService;
	
	@Autowired
	private InvoiceService invoiceService;
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value="getBusinessPartners", method=RequestMethod.GET)
	public ResponseEntity<List<BusinessPartnerDTO>> getBusinessPartners(){
		List<BusinessPartner> businessPartners = businessPartnerService.findAll();
		List<BusinessPartnerDTO> businessPartnersDTO = new ArrayList<BusinessPartnerDTO>();
		for(BusinessPartner businessPartner : businessPartners){
			businessPartnersDTO.add(businessPartnerConverter.entityToDto(businessPartner));
		}
		return new ResponseEntity<>(businessPartnersDTO, HttpStatus.OK);		
	}	
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<BusinessPartnerDTO> addBusinessPartner(@RequestBody BusinessPartnerDTO businessPartnerDTO){
			
		BusinessPartner newBusinessPartner = businessPartnerService.saveBusinessPartner(businessPartnerDTO);
		return new ResponseEntity<>(businessPartnerConverter.entityToDto(newBusinessPartner), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<BusinessPartnerDTO> getBusinessPartner(@PathVariable Long id) {
		BusinessPartner businessPartner = businessPartnerService.findOne(id);
		if (businessPartner == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(businessPartnerConverter.entityToDto(businessPartner), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<BusinessPartnerDTO> delete(@PathVariable Long id) {
		BusinessPartner businessPartner = businessPartnerService.findOne(id);
		boolean aproved = true;
		boolean aproved2 = true;
		boolean aproved3 = true;
		for(DeliveryNote dn:deliveryNoteService.findAll()) {
			if(dn.getBuyer().getId()==businessPartner.getId() || dn.getSeller().getId()==businessPartner.getId()) {
				aproved=false;
				break;
			}
		}
		
		for(Invoice in:invoiceService.findAll()) {
			if(in.getBuyer().getId()==businessPartner.getId() || in.getSeller().getId()==businessPartner.getId()) {
				aproved2=false;
				break;
			}
		}
		
		for(Order o:orderService.findAll()) {
			if(o.getBuyer().getId()==businessPartner.getId() || o.getSeller().getId()==businessPartner.getId()) {
				aproved3=false;
				break;
			}
		}
		
		if(aproved==true && aproved2==true && aproved3==true) {
			BusinessPartner deleted = businessPartnerService.deleteBusinessPartner(id);
			return new ResponseEntity<>(businessPartnerConverter.entityToDto(deleted), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<BusinessPartnerDTO> edit(@RequestBody BusinessPartnerDTO businessPartnerDTO) {
		BusinessPartner edited = businessPartnerService.saveBusinessPartner(businessPartnerDTO);
		return new ResponseEntity<>(businessPartnerConverter.entityToDto(edited), HttpStatus.OK);
	}
	
	
}
