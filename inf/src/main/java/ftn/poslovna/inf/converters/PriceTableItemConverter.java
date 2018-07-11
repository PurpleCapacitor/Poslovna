package ftn.poslovna.inf.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ftn.poslovna.inf.domain.PriceTableItem;
import ftn.poslovna.inf.dto.PriceTableItemDTO;
import ftn.poslovna.inf.repository.CatalogRepository;
import ftn.poslovna.inf.repository.PriceTableRepository;

@Component
public class PriceTableItemConverter {

	@Autowired
	PriceTableRepository priceTableRepository;
	
	@Autowired
	CatalogRepository catalogRepository;
	
	
	public PriceTableItemDTO entityToDto(PriceTableItem entity) {		
		PriceTableItemDTO dto = new PriceTableItemDTO();
		dto.setId(entity.getId());
		if(entity.getCatalog()!=null){
			dto.setCatalogId(entity.getCatalog().getId());
		}
		dto.setItemName(entity.getItemName());
		dto.setItemPrice(entity.getItemPrice());
		dto.setPriceTableId(entity.getPriceTable().getId());

		return dto;
	}

	public PriceTableItem DtoToEntity(PriceTableItemDTO dto) {
		PriceTableItem entity = new PriceTableItem();
		entity.setId(dto.getId());
		entity.setCatalog(catalogRepository.findById(dto.getCatalogId()).get());
		entity.setItemName(dto.getItemName());
		entity.setItemPrice(dto.getItemPrice());
		entity.setPriceTable(priceTableRepository.findById(dto.getPriceTableId()).get());
		
		return entity;
	}

}
