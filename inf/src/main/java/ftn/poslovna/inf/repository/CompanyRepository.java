package ftn.poslovna.inf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.poslovna.inf.domain.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
