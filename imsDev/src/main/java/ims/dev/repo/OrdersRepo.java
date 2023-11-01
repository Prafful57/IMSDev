package ims.dev.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ims.dev.entity.Orders;

public interface OrdersRepo extends JpaRepository<Orders, Integer> {

}
