package ftn.poslovna.inf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.poslovna.inf.domain.BusinessYear;

@Repository
public interface BusinessYearRepository extends JpaRepository<BusinessYear, Long> {

}
