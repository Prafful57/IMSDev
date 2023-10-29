package ims.dev.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public ResponseEntity<HttpStatus> saveProduct(@RequestBody Products product) {
		Products product1 = proService.saveProduct(product);
		return ResponseEntity.ok(HttpStatus.ACCEPTED); 
	}
	
	@GetMapping("/getproducts")
	public List<Products> getProducts() {
		return proService.findAllProducts();
	}
	
	@DeleteMapping("/{product_id}")
	public ResponseEntity<Map<String, String>> deleteProduct(@PathVariable int product_id) {
		Map<String, String> response = new HashMap<>();
		//if case is not working 
		Products product = proRepo.findById(product_id).get();
		if(product.getProduct_id()!=product_id) {
			response.put("Status", "Product is not Present try another Product");
		return ResponseEntity.accepted().body(response);	
		}
		else {
			proService.deleteProductById(product_id);
			response.put("Status", "Deleted Successfull");
			return ResponseEntity.accepted().body(response);			}
		
	}
	
	@PutMapping("/update-product/{product_id}")
	public ResponseEntity<Products> updateProduct(@PathVariable int product_id ,@RequestBody Products product){
	         
			try{
				if(product.getProduct_id()!=product_id);
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
	
		Products product1 = proRepo.findById(product_id).get();
		product1.setProduct_name(product.getProduct_name());
		product1.setProduct_details(product.getProduct_details());
		product1.setPrice(product.getPrice());
		product1.setCatagory(product.getCatagory());
		product1.setSub_catagory(product.getSub_catagory());
		product1.setTotal_stock(product.getTotal_stock());
		
		proRepo.save(product1);
		return ResponseEntity.accepted().body(product1);
		
	}

}
