package ims.dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/all-order")
public class BrandsController {

	@Autowired
	private BrandsService brandService;
	
	
	@Autowired
	private BrandsRepo brandRepo;
	@PostMapping("/post-orders")
	public Brands postOrders(@RequestBody Brands order) {
		Brands brand1=brandService.saveBrand(order);
		return brand1;
	}
	
	@GetMapping("/view-orders")
	public List<Brands> viewBrands(){
		List<Brands>  brand1 = brandService.getAllBrands();
		return  brand1;	
	}
	
	@DeleteMapping("/delete-brand/{brand_id}")
	public void deleteOrder(@PathVariable int brand_id ) {
		brandService.deleteBrand(brand_id);
	}
	
	@PutMapping("/update-brand/{brand_id}")
	public Brands updateBrand(@PathVariable int brand_id, @RequestBody Brands brand) {
		Brands brand1 = brandRepo.findById(brand_id).get();
		brand1.setBrand_name(brand.getBrand_name());
		brandRepo.save(brand1);
		return brand1;
		
	}
	
	
}
