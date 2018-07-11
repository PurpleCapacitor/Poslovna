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

import ftn.poslovna.inf.converters.OrderConverter;
import ftn.poslovna.inf.converters.OrderItemConverter;
import ftn.poslovna.inf.domain.Company;
import ftn.poslovna.inf.domain.Order;
import ftn.poslovna.inf.domain.OrderItem;
import ftn.poslovna.inf.domain.PriceTable;
import ftn.poslovna.inf.domain.PriceTableItem;
import ftn.poslovna.inf.dto.ItemDTO;
import ftn.poslovna.inf.dto.OrderDTO;
import ftn.poslovna.inf.dto.OrderItemDTO;
import ftn.poslovna.inf.services.OrderService;

@Controller
@RequestMapping(value="/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderConverter orderConverter;
	
	@Autowired
	private OrderItemConverter orderItemConverter;
	
	@RequestMapping(value="getOrders", method=RequestMethod.GET)
	public ResponseEntity<List<OrderDTO>> getOrders(){
		List<Order> orders = orderService.findAll();
		List<OrderDTO> ordersDTO = new ArrayList<OrderDTO>();
		for(Order order : orders){
			ordersDTO.add(orderConverter.entityToDto(order));
		}
		return new ResponseEntity<>(ordersDTO, HttpStatus.OK);		
	}	
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<OrderDTO> addOrder(@RequestBody OrderDTO orderDTO){
			
		Order newOrder = orderService.save(orderDTO);
		return new ResponseEntity<>(orderConverter.entityToDto(newOrder), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<OrderDTO> getOrder(@PathVariable Long id) {
		Order order = orderService.findOne(id);
		if (order == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(orderConverter.entityToDto(order), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<OrderDTO> delete(@PathVariable Long id) {
		Order deleted = orderService.delete(id);
		return new ResponseEntity<>(orderConverter.entityToDto(deleted), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<OrderDTO> edit(@RequestBody OrderDTO orderDTO) {
		Order edited = orderService.save(orderDTO);
		return new ResponseEntity<>(orderConverter.entityToDto(edited), HttpStatus.OK);
	}
	
	@RequestMapping(value="getOrderItems/{id}", method=RequestMethod.GET)
	public ResponseEntity<List<OrderItemDTO>> getOrderItems(@PathVariable Long id){
		Order order = orderService.findOne(id);
		List<OrderItemDTO> items = new ArrayList<OrderItemDTO>();
		for(OrderItem item : order.getOrdetItems()){
			OrderItemDTO itemDTO = orderItemConverter.entityToDto(item);
			items.add(itemDTO);
		}
		return new ResponseEntity<>(items, HttpStatus.OK);		
	}
	
	@RequestMapping(value="getPriceItems/{id}", method=RequestMethod.GET)
	public ResponseEntity<List<ItemDTO>> getPriceItems(@PathVariable Long id){
		Order order = orderService.findOne(id);
		List<ItemDTO> items = new ArrayList<ItemDTO>();
		Company company = order.getSeller().getCompany();
		for(PriceTable pt : company.getPriceTables()){
			for(PriceTableItem pti: pt.getPriceTableItems()){
				ItemDTO item = new ItemDTO();
				item.setCatalogId(pti.getCatalog().getId());
				item.setItemName(pti.getItemName());
				items.add(item);
			}
		}
		return new ResponseEntity<>(items, HttpStatus.OK);		
	}
	

}
