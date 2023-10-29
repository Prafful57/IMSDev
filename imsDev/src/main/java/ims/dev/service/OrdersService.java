package ims.dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ims.dev.entity.Orders;
import ims.dev.repo.OrdersRepo;

@Service
public class OrdersService {

	@Autowired
	private OrdersRepo orderRepo;
	
	public Orders saveOrder(Orders order) {
		return orderRepo.save(order);
	}

	public List<Orders> findAllOrders() {
		return orderRepo.findAll();
	}

	public void deleteOrder(int order_id) {
		orderRepo.deleteById(order_id);
	}

}
