package ims.dev.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ims.dev.entity.Products;
import ims.dev.repo.ProductsRepo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductsService {

	@Autowired
	ProductsRepo proRepo;

	public Products saveProduct(Products product) {
		log.info("Saving product from repo : ",product);
		return proRepo.save(product);
	}

	public List<Products> findAllProducts() {
		log.info("Getting all user from repo");
		return proRepo.findAll();
	}

	public void deleteProductById(int product_id) {
		log.debug("Deleting the product with productId : ", product_id);
		proRepo.deleteById(product_id);

	}

}
