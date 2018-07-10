package ftn.poslovna.inf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.poslovna.inf.domain.DeliveryNoteItem;

@Repository
public interface DeliveryNoteItemRepository extends JpaRepository<DeliveryNoteItem, Long> {

}
