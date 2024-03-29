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

import ims.dev.entity.Brands;
import ims.dev.repo.BrandsRepo;
import ims.dev.service.BrandsService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/all-order")
public class BrandsController {

	@Autowired
	private BrandsService brandService;

	@Autowired
	private BrandsRepo brandRepo;

	@PostMapping("/post-orders")
	public Brands postOrders(@RequestBody Brands brand) {
		log.debug("Saving Brand:", brand);
		Brands brand1 = brandService.saveBrand(brand);
		return brand1;
	}
	

	@GetMapping("/view-orders")
	public List<Brands> viewBrands() {
		log.info("Getting all List of Users");
		List<Brands> brand1 = brandService.getAllBrands();
		return brand1;
	}
	

	@DeleteMapping("/delete-brand/{id}")
	public ResponseEntity<?> deleteOrder(@PathVariable int id) {
		log.debug("Deleting Brand Info with Id : ", id);
		boolean brandId = brandRepo.existsById(id);
		if(brandId==false) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		brandService.deleteBrand(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
		
	}
	

	@PutMapping("/update-brand/{id}")
	public ResponseEntity<?> updateBrand(@PathVariable int id, @RequestBody Brands brand) {
		log.debug("updated brand info with brandId : ",id);
		boolean brandId = brandRepo.existsById(id);
		if(brandId==false) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Brands brand1 = brandRepo.findById(id).get();
		brand1.setBrandName(brand.getBrandName());
		brandRepo.save(brand1);
		return ResponseEntity.accepted().body(brand1);
	}

}
