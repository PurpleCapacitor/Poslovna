package ftn.poslovna.inf.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.poslovna.inf.converters.OrderConverter;
import ftn.poslovna.inf.domain.Order;
import ftn.poslovna.inf.dto.OrderDTO;
import ftn.poslovna.inf.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderConverter orderConverter;
	
	public List<Order> findAll() {
		return orderRepository.findAll();
	}
	
	public Order findOne(Long id) {
		Optional<Order> o = orderRepository.findById(id);
		return o.get();
	}
	
	public Order save(OrderDTO dto) {
		Order ord = orderConverter.DtoToEntity(dto);
		return orderRepository.save(ord);
	}

	public Order delete(Long id) {
		Order i = this.findOne(id);
		if(i == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant");
		}
		orderRepository.delete(i);
		return i;
	}

}
