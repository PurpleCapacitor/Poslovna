package ftn.poslovna.inf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.poslovna.inf.domain.Order;

@Repository
public interface OrderRepository  extends  JpaRepository<Order, Long>{

}
