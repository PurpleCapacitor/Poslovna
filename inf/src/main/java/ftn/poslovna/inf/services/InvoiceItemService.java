package ftn.poslovna.inf.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.poslovna.inf.converters.InvoiceItemConverter;
import ftn.poslovna.inf.domain.InvoiceItem;
import ftn.poslovna.inf.dto.InvoiceItemDTO;
import ftn.poslovna.inf.repository.InvoiceItemRepository;


@Service
public class InvoiceItemService {
	
	@Autowired
	InvoiceItemRepository invoiceItemRepository;
	
	@Autowired
	InvoiceItemConverter invoiceItemConverter;
	
	public List<InvoiceItem> findAll() {
		return invoiceItemRepository.findAll();
	}
	
	public InvoiceItem findOne(Long id) {
		Optional<InvoiceItem> inv = invoiceItemRepository.findById(id);
		return inv.get();
	}
	
	public InvoiceItem saveInvoiceItem(InvoiceItemDTO dto) {
		InvoiceItem inv = invoiceItemConverter.DtoToEntity(dto);
		return invoiceItemRepository.save(inv);
	}

	public InvoiceItem deleteInvoiceItem(Long id) {
		InvoiceItem i = this.findOne(id);
		if(i == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant");
		}
		invoiceItemRepository.delete(i);
		return i;
	}
}
