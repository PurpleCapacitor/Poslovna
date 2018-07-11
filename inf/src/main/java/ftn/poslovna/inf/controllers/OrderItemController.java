package ftn.poslovna.inf.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ftn.poslovna.inf.converters.OrderItemConverter;
import ftn.poslovna.inf.domain.OrderItem;
import ftn.poslovna.inf.dto.OrderItemDTO;
import ftn.poslovna.inf.services.OrderItemService;

@Controller
@RequestMapping(value="/orderItem")
public class OrderItemController {
	
	@Autowired
	private OrderItemService orderItemService;
	
	@Autowired
	private OrderItemConverter orderItemConverter;
	
	@RequestMapping(value="getOrderItems", method=RequestMethod.GET)
	public ResponseEntity<List<OrderItemDTO>> getOrderItems(){
		List<OrderItem> orderItems = orderItemService.findAll();
		List<OrderItemDTO> orderItemsDTO = new ArrayList<OrderItemDTO>();
		for(OrderItem orderItem : orderItems){
			orderItemsDTO.add(orderItemConverter.entityToDto(orderItem));
		}
		return new ResponseEntity<>(orderItemsDTO, HttpStatus.OK);		
	}	
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<OrderItemDTO> addOrderItem(@RequestBody OrderItemDTO orderItemDTO){
			
		OrderItem newOrderItem = orderItemService.save(orderItemDTO);
		return new ResponseEntity<>(orderItemConverter.entityToDto(newOrderItem), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<OrderItemDTO> getOrderItem(@PathVariable Long id) {
		OrderItem orderItem = orderItemService.findOne(id);
		if (orderItem == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(orderItemConverter.entityToDto(orderItem), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<OrderItemDTO> delete(@PathVariable Long id) {
		OrderItem deleted = orderItemService.delete(id);
		return new ResponseEntity<>(orderItemConverter.entityToDto(deleted), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<OrderItemDTO> edit(@RequestBody OrderItemDTO orderItemDTO) {
		OrderItem edited = orderItemService.save(orderItemDTO);
		return new ResponseEntity<>(orderItemConverter.entityToDto(edited), HttpStatus.OK);
	}

}
