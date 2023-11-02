package ims.dev.controller;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ims.dev.entity.Orders;
import ims.dev.repo.OrdersRepo;
import ims.dev.service.OrdersService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/all-orders")
public class OrdersController {

	@Autowired
	private OrdersService ordersService;

	@Autowired
	private OrdersRepo orderRepo;

	@PostMapping("/save-order")
	public ResponseEntity<?> saveOrder(@RequestBody Orders order) {
		log.debug("Saving the order :", order);
		ordersService.saveOrder(order);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@GetMapping("/get-order")
	public List<Orders> getAllOrders() {
		log.info("List of Orders");
		return ordersService.findAllOrders();
	}

	@DeleteMapping("/delete-order/{order_id}")
	public ResponseEntity<?> deleteOrder(@PathVariable int order_id) {
		log.debug("Deleting order with orderId : ", order_id);
		boolean order = orderRepo.existsById(order_id);
		if (order == false) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		ordersService.deleteOrder(order_id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED); // here i am sending custom status
	}

	@PutMapping("/update-order/{order_id}")
	public ResponseEntity<?> updateOrder(@PathVariable int order_id, @RequestBody Orders order) {
		log.debug("Updating order with orderId : ", order_id);
		boolean orderId = orderRepo.existsById(order_id);
		if (orderId == false) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		// not getting how to post date it is seeing in response body but not getting
		// store in db
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		Orders order1 = orderRepo.findById(order_id).get();
		order1.setOrder_quantity(order.getOrder_quantity());
		order1.setOrder_status(order.getOrder_status());
		order1.setOrder_date(dtf.format(now));
		return ResponseEntity.accepted().body(order1);// here sending updated order data
	}
}
