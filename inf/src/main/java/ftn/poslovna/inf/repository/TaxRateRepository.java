package ftn.poslovna.inf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.poslovna.inf.domain.TaxRate;


@Repository
public interface TaxRateRepository extends  JpaRepository<TaxRate, Long>{

}
