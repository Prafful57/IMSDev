package ims.dev.controller;


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
import ims.dev.entity.Products;
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

	@DeleteMapping("/delete-order/{orderId}")
	public ResponseEntity<?> deleteOrder(@PathVariable int orderId) {
		log.debug("Deleting order with orderId : ", orderId);
		boolean order = orderRepo.existsById(orderId);
		if (order == false) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		ordersService.deleteOrder(orderId);
		return new ResponseEntity<>(HttpStatus.ACCEPTED); // here i am sending custom status
	}

	@PutMapping("/update-order/{id}")
	public ResponseEntity<?> updateOrder(@PathVariable int orderId, @RequestBody Orders order) {
		log.debug("Updating order with orderId : ", orderId);
		
		boolean orderId1 = orderRepo.existsById(orderId);
		if (orderId1 == false) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		Orders order1 = orderRepo.findById(orderId).get();
		order1.setOrderQuantity(order.getOrderQuantity());
		order1.setOrderStatus(order.getOrderStatus());
		order1.setUpdatedBy(order.getUpdatedBy());
		orderRepo.save(order1);
		return ResponseEntity.accepted().body(order1);
	}
	
	//one order can have many products 
	@PostMapping("/{orderId}/products")
	public ResponseEntity<?> addProductsToOrder(@PathVariable int orderId,@RequestBody Products product){
		Orders updatedOrder= ordersService.addProductToOrder(orderId,product);
		return new ResponseEntity<>(updatedOrder,HttpStatus.OK);
	
	}
//	@GetMapping("/ordered-products/{orderId}")
//	public List<Products> getAllOrderedProducts(@PathVariable int orderId){
//		 List<Products> products = ordersService.getAllOrderedProducts(orderId);
//		 return  products;
//	}
	
}
