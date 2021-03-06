package ftn.poslovna.inf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.poslovna.inf.domain.BusinessPartner;

@Repository
public interface BusinessPartnerRepository extends JpaRepository<BusinessPartner, Long> {

}
