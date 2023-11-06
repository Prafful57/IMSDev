package ims.dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ims.dev.entity.Orders;
import ims.dev.entity.Products;
import ims.dev.repo.OrdersRepo;
import ims.dev.repo.ProductsRepo;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrdersService {

	@Autowired
	private OrdersRepo orderRepo;
	
	@Autowired
	private ProductsRepo proRepo;
	
	public Orders saveOrder(Orders order) {
		log.info("Saving Order :", order);
		return orderRepo.save(order);
	}

	public List<Orders> findAllOrders() {
		log.info("Getting all orders :Log from Order Service");
		return orderRepo.findAll();
	}

	public void deleteOrder(int orderId) {
		log.debug("Deleting the order with id:", orderId);;
		orderRepo.deleteById(orderId);
	}

	public Orders addProductToOrder(int orderId,Products product) {
		Orders order= orderRepo.findById(orderId).get();
		product.setOrder(order);
		proRepo.save(product);
		return order;
	}


//	public List<Products> getAllOrderedProducts(int orderId) {
//		return proRepo.findByOrderId(orderId);
//	}

}
