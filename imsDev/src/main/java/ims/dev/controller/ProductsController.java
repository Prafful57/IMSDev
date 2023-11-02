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

import ims.dev.entity.Products;
import ims.dev.repo.ProductsRepo;
import ims.dev.service.ProductsService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/all-products")
public class ProductsController {

	@Autowired // (it is used to automatic dependency injection it creates object of
				// ProductService and use when it is needed)
	private ProductsService proService;

	@Autowired
	private ProductsRepo proRepo;

	@PostMapping
	public ResponseEntity<HttpStatus> saveProduct(@RequestBody Products product) {
		log.debug("Saving product :", product);
		proService.saveProduct(product);
		return ResponseEntity.ok(HttpStatus.ACCEPTED);
	}

	@GetMapping("/getproducts")
	public List<Products> getProducts() {
		log.info("Getting list of Products");
		return proService.findAllProducts();
	}

	@DeleteMapping("/delete-product/{product_id}")
	public ResponseEntity<?> deleteProduct(@PathVariable int product_id) {
		log.debug("Deleting product with productId : ", product_id);
		boolean productId = proRepo.existsById(product_id);
		if (productId == false) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		proService.deleteProductById(product_id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);

	}

	@PutMapping("/update-product/{product_id}")
	public ResponseEntity<?> updateProduct(@PathVariable int product_id, @RequestBody Products product) {
		log.debug("Updating product with productId : ", product_id);
		boolean productId = proRepo.existsById(product_id);
		if (productId == false) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
