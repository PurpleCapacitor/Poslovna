package ftn.poslovna.inf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.poslovna.inf.domain.PartnerType;

@Repository
public interface PartnerTypeRepository extends  JpaRepository<PartnerType, Long>{

}
