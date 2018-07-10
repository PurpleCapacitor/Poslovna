package ftn.poslovna.inf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.poslovna.inf.domain.Tax;


@Repository
public interface TaxRepository extends  JpaRepository<Tax, Long>{

}
