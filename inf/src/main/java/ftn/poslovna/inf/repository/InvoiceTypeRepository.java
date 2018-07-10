package ftn.poslovna.inf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.poslovna.inf.domain.InvoiceType;

@Repository
public interface InvoiceTypeRepository extends  JpaRepository<InvoiceType, Long>{

}
