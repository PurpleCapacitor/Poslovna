package ftn.poslovna.inf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.poslovna.inf.domain.PriceTableItem;


@Repository
public interface PriceTableItemRepository extends  JpaRepository<PriceTableItem, Long>{

}
