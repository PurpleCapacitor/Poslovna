package ftn.poslovna.inf.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.poslovna.inf.converters.OrderItemConverter;
import ftn.poslovna.inf.domain.OrderItem;
import ftn.poslovna.inf.dto.OrderItemDTO;
import ftn.poslovna.inf.repository.OrderItemRepository;

@Service
public class OrderItemService {
	
	@Autowired
	OrderItemRepository orderItemRepository;
	
	@Autowired
	OrderItemConverter orderItemConverter;
	
	public List<OrderItem> findAll() {
		return orderItemRepository.findAll();
	}
	
	public OrderItem findOne(Long id) {
		Optional<OrderItem> o = orderItemRepository.findById(id);
		return o.get();
	}
	
	public OrderItem save(OrderItemDTO dto) {
		OrderItem ord = orderItemConverter.DtoToEntity(dto);
		return orderItemRepository.save(ord);
	}

	public OrderItem delete(Long id) {
		OrderItem i = this.findOne(id);
		if(i == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant");
		}
		orderItemRepository.delete(i);
		return i;
	}

}
