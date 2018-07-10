package ftn.poslovna.inf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.poslovna.inf.domain.OrderItem;

@Repository
public interface OrderItemRepository extends  JpaRepository<OrderItem, Long>{

}
