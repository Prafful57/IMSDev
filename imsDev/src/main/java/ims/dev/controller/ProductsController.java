package ims.dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import ims.dev.entity.Products;
import ims.dev.repo.ProductsRepo;
import ims.dev.service.ProductsService;

@RestController
@RequestMapping("/all-products")
public class ProductsController {

   
	@Autowired //(it is used to automatic dependency injection it creates object of ProductService and use when it is needed)
	private ProductsService proService;
	
	@Autowired
	private ProductsRepo proRepo;
	
	@PostMapping
	public Products saveProduct(@RequestBody Products product) {
		Products product1 = proService.saveProduct(product);
		return product; 
	}
	
	@GetMapping("/getproducts")
	public List<Products> getProducts() {
		return proService.findAllProducts();
	}
	
	@DeleteMapping("/{product_id}")
	public void deleteProduct(@PathVariable int product_id) {
		proService.deleteProductById(product_id);
	}
	
	@PutMapping("/update-product/{product_id}")
	public Products updateProduct(@PathVariable int product_id ,@RequestBody Products product) {
		Products product1 = proRepo.findById(product_id).get();
		product1.setProduct_name(product.getProduct_name());
		product1.setPrice(product.getPrice());
		proRepo.save(product1);
		return product1;
		
	}

}
