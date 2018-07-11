package ftn.poslovna.inf.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ftn.poslovna.inf.domain.Order;
import ftn.poslovna.inf.dto.OrderDTO;
import ftn.poslovna.inf.repository.BusinessPartnerRepository;
import ftn.poslovna.inf.repository.BusinessYearRepository;
import ftn.poslovna.inf.repository.OrderRepository;

@Component
public class OrderConverter {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	BusinessPartnerRepository businessPartnerRepository;

	@Autowired
	BusinessYearRepository businessYearRepository;
	
	public OrderDTO entityToDto(Order entity) {
		OrderDTO dto = new OrderDTO();
		dto.setId(entity.getId());
		dto.setBuyerId(entity.getBuyer().getId());
		dto.setSellerId(entity.getSeller().getId());
		dto.setBusinessYearId(entity.getBusinessYear().getId());
		dto.setYearNumber(entity.getBusinessYear().getYearNumber());

		return dto;
	}

	public Order DtoToEntity(OrderDTO dto) {
		Order entity = new Order();
		entity.setId(dto.getId());
		entity.setBuyer(businessPartnerRepository.findById(dto.getBuyerId()).get());
		entity.setSeller(businessPartnerRepository.findById(dto.getSellerId()).get());
		entity.setBusinessYear(businessYearRepository.findById(dto.getBusinessYearId()).get());
		
		return entity;
	}

}
