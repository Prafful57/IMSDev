package ims.dev.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ims.dev.entity.Products;

public interface ProductsRepo extends JpaRepository<Products, Integer> {

}
