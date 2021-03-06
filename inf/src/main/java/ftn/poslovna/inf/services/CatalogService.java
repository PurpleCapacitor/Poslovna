package ftn.poslovna.inf.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.poslovna.inf.converters.CatalogConverter;
import ftn.poslovna.inf.domain.Catalog;
import ftn.poslovna.inf.dto.CatalogDTO;
import ftn.poslovna.inf.repository.CatalogRepository;

@Service
public class CatalogService {

	@Autowired
	CatalogRepository catalogRepository;
	
	@Autowired
	CatalogConverter catalogConverter;
	
	public List<Catalog> findAll() {
		return catalogRepository.findAll();
	}
	
	public Catalog findOne(Long id) {
		Optional<Catalog> inv = catalogRepository.findById(id);
		return inv.get();
	}
	
	public Catalog saveCatalog(CatalogDTO dto) {
		Catalog inv = catalogConverter.DtoToEntity(dto);
		return catalogRepository.save(inv);
	}

	public Catalog deleteCatalog(Long id) {
		Catalog i = this.findOne(id);
		if(i == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant");
		}
		
		if(i.getDeliveryNoteItems().isEmpty() && i.getInvoiceItems().isEmpty() && i.getOrderItems().isEmpty() && i.getPriceTableItems().isEmpty()) {
			catalogRepository.delete(i);
			return i;
		}else {
			return null;
		}
		
		
	}
	
}
