package ftn.poslovna.inf.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ftn.poslovna.inf.domain.TaxRate;
import ftn.poslovna.inf.dto.TaxRateDTO;
import ftn.poslovna.inf.repository.TaxRepository;

@Component
public class TaxRateConverter {
	
	@Autowired
	TaxRepository taxRepository;
	
	
	public TaxRateDTO entityToDto(TaxRate entity) {
		TaxRateDTO dto = new TaxRateDTO();
		dto.setId(entity.getId());
		dto.setImplicationDate(entity.getImplicationDate());
		dto.setTaxId(entity.getTax().getId());
		dto.setTaxRate(entity.getTaxRate());
		dto.setTaxName(entity.getTax().getTaxName());
		return dto;
	}

	public TaxRate DtoToEntity(TaxRateDTO dto) {
		TaxRate entity = new TaxRate();
		entity.setId(dto.getId());
		entity.setTax(taxRepository.findById(dto.getTaxId()).get());
		entity.setImplicationDate(dto.getImplicationDate());
		entity.setTaxRate(dto.getTaxRate());		
		return entity;
	}

}
