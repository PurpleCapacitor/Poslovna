package ftn.poslovna.inf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.poslovna.inf.domain.InvoiceItem;

@Repository
public interface InvoiceItemRepository extends  JpaRepository<InvoiceItem, Long>{

}
