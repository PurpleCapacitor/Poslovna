package ftn.poslovna.inf.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.poslovna.inf.converters.CompanyConverter;
import ftn.poslovna.inf.domain.Company;
import ftn.poslovna.inf.dto.CompanyDTO;
import ftn.poslovna.inf.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	CompanyRepository companyRepository;
	
	@Autowired
	CompanyConverter companyConverter;
	
	public List<Company> findAll() {
		return companyRepository.findAll();
	}
	
	public Company findOne(Long id) {
		Optional<Company> inv = companyRepository.findById(id);
		return inv.get();
	}
	
	public Company saveCompany(CompanyDTO dto) {
		Company inv = companyConverter.DtoToEntity(dto);
		return companyRepository.save(inv);
	}

	public Company deleteCompany(Long id) {
		Company i = this.findOne(id);
		if(i == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant");
		}
		
		if(i.getBusinessPartners().isEmpty() && i.getGroups().isEmpty() && i.getBusinessYear().isEmpty() && i.getPriceTables().isEmpty()) {
			companyRepository.delete(i);
			return i;
		}else {
			return null;
		}
		
		
	}
	
}
