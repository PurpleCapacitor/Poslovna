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

import ftn.poslovna.inf.converters.CatalogConverter;
import ftn.poslovna.inf.domain.Catalog;
import ftn.poslovna.inf.dto.CatalogDTO;
import ftn.poslovna.inf.services.CatalogService;

@Controller
@RequestMapping(value="/catalog")
public class CatalogController {

	@Autowired
	private CatalogService catalogService;
	
	@Autowired
	private CatalogConverter catalogConverter;
	
	@RequestMapping(value="getCatalogs", method=RequestMethod.GET)
	public ResponseEntity<List<CatalogDTO>> getCatalogs(){
		List<Catalog> catalogs = catalogService.findAll();
		List<CatalogDTO> catalogsDTO = new ArrayList<CatalogDTO>();
		for(Catalog catalog : catalogs){
			catalogsDTO.add(catalogConverter.entityToDto(catalog));
		}
		return new ResponseEntity<>(catalogsDTO, HttpStatus.OK);		
	}	
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<CatalogDTO> addCatalog(@RequestBody CatalogDTO catalogDTO){
			
		Catalog newCatalog = catalogService.saveCatalog(catalogDTO);
		return new ResponseEntity<>(catalogConverter.entityToDto(newCatalog), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<CatalogDTO> getCatalog(@PathVariable Long id) {
		Catalog catalog = catalogService.findOne(id);
		if (catalog == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(catalogConverter.entityToDto(catalog), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<CatalogDTO> delete(@PathVariable Long id) {
		Catalog deleted = catalogService.deleteCatalog(id);
		return new ResponseEntity<>(catalogConverter.entityToDto(deleted), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<CatalogDTO> edit(@RequestBody CatalogDTO catalogDTO) {
		Catalog edited = catalogService.saveCatalog(catalogDTO);
		return new ResponseEntity<>(catalogConverter.entityToDto(edited), HttpStatus.OK);
	}
	
}
