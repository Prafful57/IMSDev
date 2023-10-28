package ims.dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ims.dev.entity.Products;
import ims.dev.repo.ProductsRepo;

@Service
public class ProductsService {

	@Autowired
	ProductsRepo proRepo;
	public Products saveProduct(Products product) {
		return proRepo.save(product);
	}
	public List<Products> findAllProducts() {
		return proRepo.findAll();
	}
	public void deleteProductById(int product_id) {
		proRepo.deleteById(product_id);
		
	}

	
}
