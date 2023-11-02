package ims.dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ims.dev.entity.Orders;
import ims.dev.repo.OrdersRepo;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrdersService {

	@Autowired
	private OrdersRepo orderRepo;
	
	public Orders saveOrder(Orders order) {
		log.info("Saving Order :", order);
		return orderRepo.save(order);
	}

	public List<Orders> findAllOrders() {
		log.info("Getting all orders :Log from Order Service");
		return orderRepo.findAll();
	}

	public void deleteOrder(int order_id) {
		log.debug("Deleting the order with order_id:", order_id);;
		orderRepo.deleteById(order_id);
	}

}
