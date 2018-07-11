package ftn.poslovna.inf.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ftn.poslovna.inf.domain.OrderItem;
import ftn.poslovna.inf.dto.OrderItemDTO;
import ftn.poslovna.inf.repository.CatalogRepository;
import ftn.poslovna.inf.repository.OrderRepository;

@Component
public class OrderItemConverter {
	
	@Autowired
	CatalogRepository catalogRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	
	public OrderItemDTO entityToDto(OrderItem entity) {
		OrderItemDTO dto = new OrderItemDTO();
		dto.setId(entity.getId());
		dto.setAmount(entity.getAmount());
		dto.setCatalogId(entity.getCatalog().getId());
		dto.setName(entity.getName());
		dto.setOrderId(entity.getOrder().getId());

		return dto;
	}

	public OrderItem DtoToEntity(OrderItemDTO dto) {
		OrderItem entity = new OrderItem();
		entity.setId(dto.getId());
		entity.setAmount(dto.getAmount());
		entity.setCatalog(catalogRepository.findById(dto.getCatalogId()).get());
		entity.setName(dto.getName());
		entity.setOrder(orderRepository.findById(dto.getOrderId()).get());
		
		return entity;
	}

}


