package ims.dev.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ims.dev.entity.Orders;
import ims.dev.repo.OrdersRepo;
import ims.dev.service.OrdersService;

@RestController
@RequestMapping("/all-orders")
public class OrderController {

	@Autowired
	private OrdersService ordersService;
	
	private OrdersRepo orderRepo;
	
	@PostMapping("/save-order")
	public Orders saveOrder(@RequestBody Orders order) {
		Orders order1 = ordersService.saveOrder(order);
		return order1;
	}
	
	@GetMapping("/get-order")
	public List<Orders> getAllOrders() {
		List<Orders> order1 = ordersService.findAllOrders();
		return order1;
	}
	
	@DeleteMapping("/delete-order/{order_id}")
	public ResponseEntity<Map<String,String>> deleteOrder(@PathVariable int order_id) {
		Map<String ,String> response = new HashMap<>();
		boolean order = orderRepo.existsById(order_id);
		
		//this also not working
		if(order==false) {
			response.put("Status", "Order not exists");
			return ResponseEntity.accepted().body(response);
		}
		ordersService.deleteOrder(order_id);
		response.put("Status", "Deleted Successfull");
		return ResponseEntity.accepted().body(response);
		
		
	}
}
