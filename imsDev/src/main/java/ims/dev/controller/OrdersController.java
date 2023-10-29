package ims.dev.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ims.dev.entity.Orders;
import ims.dev.repo.OrdersRepo;
import ims.dev.service.OrdersService;

@RestController
@RequestMapping("/all-orders")
public class OrdersController {

	@Autowired
	private OrdersService ordersService;
	
	@Autowired
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
	
	@PutMapping("/update-order/{order_id}")
	public ResponseEntity<Orders> updateOrder(@PathVariable int order_id, @RequestBody Orders order) {
		
		//not getting how to post date it is seeing in response body but not getting store in db
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now(); 
		
		Orders order1 = orderRepo.findById(order_id).get();
		order1.setOrder_quantity(order.getOrder_quantity());
		order1.setOrder_status(order.getOrder_status());
        order1.setOrder_date(dtf.format(now));
		return ResponseEntity.accepted().body(order1);
	}
}
