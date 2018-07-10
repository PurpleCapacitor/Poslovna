package ftn.poslovna.inf.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.poslovna.inf.converters.InvoiceConverter;
import ftn.poslovna.inf.domain.Invoice;
import ftn.poslovna.inf.dto.InvoiceDTO;
import ftn.poslovna.inf.repository.InvoiceRepository;

@Service
public class InvoiceService {
	
	@Autowired
	InvoiceRepository invoiceRepository;
	
	@Autowired
	InvoiceConverter invoiceConverter;
	
	public List<Invoice> findAll() {
		return invoiceRepository.findAll();
	}
	
	public Invoice findOne(Long id) {
		Optional<Invoice> inv = invoiceRepository.findById(id);
		return inv.get();
	}
	
	public Invoice saveInvoice(InvoiceDTO dto) {
		Invoice inv = invoiceConverter.DtoToEntity(dto);
		return invoiceRepository.save(inv);
	}

	public Invoice deleteInvoice(Long id) {
		Invoice i = this.findOne(id);
		if(i == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant");
		}
		invoiceRepository.delete(i);
		return i;
	}

}
