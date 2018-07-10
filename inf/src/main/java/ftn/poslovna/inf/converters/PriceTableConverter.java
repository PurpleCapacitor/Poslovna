package ftn.poslovna.inf.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ftn.poslovna.inf.domain.PriceTable;
import ftn.poslovna.inf.dto.PriceTableDTO;
import ftn.poslovna.inf.repository.CompanyRepository;

@Component
public class PriceTableConverter {
	
	@Autowired
	CompanyRepository companyRepository;
	
	
	public PriceTableDTO entityToDto(PriceTable entity) {
		PriceTableDTO dto = new PriceTableDTO();
		dto.setCompanyId(entity.getCompany().getId());
		dto.setImplicationDate(entity.getImplicationDate());
		dto.setPriceTableNum(entity.getPriceTableNum());

		return dto;
	}

	public PriceTable DtoToEntity(PriceTableDTO dto) {
		PriceTable entity = new PriceTable();
		
		entity.setCompany(companyRepository.findById(dto.getCompanyId()).get());
		entity.setImplicationDate(dto.getImplicationDate());
		entity.setPriceTableNum(dto.getPriceTableNum());
		
		return entity;
	}

}
