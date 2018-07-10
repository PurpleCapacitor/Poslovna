package ftn.poslovna.inf.converters;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ftn.poslovna.inf.domain.InvoiceItem;
import ftn.poslovna.inf.dto.InvoiceItemDTO;
import ftn.poslovna.inf.repository.CatalogRepository;
import ftn.poslovna.inf.repository.InvoiceRepository;

@Component
public class InvoiceItemConverter {
	
	@Autowired
	CatalogRepository catalogRepository;
	
	@Autowired
	InvoiceRepository invoiceRepository;
	
	private ModelMapper mapper = new ModelMapper();

	public InvoiceItemDTO entityToDto(InvoiceItem entity) {
		InvoiceItemDTO dto;

		try {
			
			dto = mapper.map(entity, InvoiceItemDTO.class);
			dto.setCatalogId(entity.getCatalog().getId());
			dto.setInvoiceId(entity.getInvoice().getId());
		} catch (Exception exc) {
			exc.printStackTrace();
			return null;
		}

		return dto;
	}

	public InvoiceItem DtoToEntity(InvoiceItemDTO dto) {
		InvoiceItem entity;

		try {
			entity = mapper.map(dto, InvoiceItem.class);
			entity.setCatalog(catalogRepository.findById(dto.getCatalogId()).get());
			entity.setInvoice(invoiceRepository.findById(dto.getInvoiceId()).get());
		} catch (Exception exc) {
			exc.printStackTrace();
			return null;
		}
		
		return entity;
	}

}
