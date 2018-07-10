package ftn.poslovna.inf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.poslovna.inf.domain.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
