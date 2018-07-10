package ftn.poslovna.inf.converters;

import org.springframework.stereotype.Component;

import ftn.poslovna.inf.domain.Tax;
import ftn.poslovna.inf.dto.TaxDTO;

@Component
public class TaxConverter {

	public TaxDTO entityToDto(Tax entity) {
		TaxDTO dto = new TaxDTO();
		dto.setTaxId(entity.getTaxId());
		dto.setTaxName(entity.getTaxName());
		dto.setValid(entity.isValid());

		return dto;
	}

	public Tax DtoToEntity(TaxDTO dto) {
		Tax entity = new Tax();
		entity.setTaxId(dto.getTaxId());
		entity.setTaxName(dto.getTaxName());
		entity.setValid(dto.isValid());

		return entity;
	}
}
