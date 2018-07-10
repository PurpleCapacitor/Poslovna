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
		dto.setBusinessPartnerId(entity.getBusinessPartner().getId());
		dto.setBusinessYearId(entity.getBusinessYear().getId());

		return dto;
	}

	public Order DtoToEntity(OrderDTO dto) {
		Order entity = new Order();
		
		entity.setBusinessPartner(businessPartnerRepository.findById(dto.getBusinessPartnerId()).get());
		entity.setBusinessYear(businessYearRepository.findById(dto.getBusinessYearId()).get());
		
		return entity;
	}

}
