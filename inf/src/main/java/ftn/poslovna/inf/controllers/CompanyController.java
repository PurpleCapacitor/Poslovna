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

import ftn.poslovna.inf.converters.CompanyConverter;
import ftn.poslovna.inf.domain.Company;
import ftn.poslovna.inf.dto.CompanyDTO;
import ftn.poslovna.inf.services.CompanyService;

@Controller
@RequestMapping(value="/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private CompanyConverter companyConverter;
	
	@RequestMapping(value="getCompanies", method=RequestMethod.GET)
	public ResponseEntity<List<CompanyDTO>> getCompanys(){
		List<Company> companies = companyService.findAll();
		List<CompanyDTO> companiesDTO = new ArrayList<CompanyDTO>();
		for(Company company : companies){
			companiesDTO.add(companyConverter.entityToDto(company));
		}
		return new ResponseEntity<>(companiesDTO, HttpStatus.OK);		
	}	
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<CompanyDTO> addCompany(@RequestBody CompanyDTO companyDTO){
			
		Company newCompany = companyService.saveCompany(companyDTO);
		return new ResponseEntity<>(companyConverter.entityToDto(newCompany), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<CompanyDTO> getCompany(@PathVariable Long id) {
		Company company = companyService.findOne(id);
		if (company == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(companyConverter.entityToDto(company), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<CompanyDTO> delete(@PathVariable Long id) {
		Company deleted = companyService.deleteCompany(id);
		return new ResponseEntity<>(companyConverter.entityToDto(deleted), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<CompanyDTO> edit(@RequestBody CompanyDTO companyDTO) {
		Company edited = companyService.saveCompany(companyDTO);
		return new ResponseEntity<>(companyConverter.entityToDto(edited), HttpStatus.OK);
	}
	
}
