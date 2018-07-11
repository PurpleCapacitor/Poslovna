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
import ftn.poslovna.inf.dto.BusinessPartnerDTO;
import ftn.poslovna.inf.services.BusinessPartnerService;

@Controller
@RequestMapping(value="/businessPartner")
public class BusinessPartnerController {
	
	@Autowired
	private BusinessPartnerService businessPartnerService;
	
	@Autowired
	private BusinessPartnerConverter businessPartnerConverter;
	
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
		BusinessPartner deleted = businessPartnerService.deleteBusinessPartner(id);
		return new ResponseEntity<>(businessPartnerConverter.entityToDto(deleted), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<BusinessPartnerDTO> edit(@RequestBody BusinessPartnerDTO businessPartnerDTO) {
		BusinessPartner edited = businessPartnerService.saveBusinessPartner(businessPartnerDTO);
		return new ResponseEntity<>(businessPartnerConverter.entityToDto(edited), HttpStatus.OK);
	}
	
	
}
