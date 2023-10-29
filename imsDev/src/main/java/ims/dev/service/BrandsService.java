package ims.dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ims.dev.entity.Brands;
import ims.dev.repo.BrandsRepo;

@Service
public class BrandsService {

	
	@Autowired
	private BrandsRepo brandRepo;

	public Brands saveBrand(Brands brand) {
		return brandRepo.save(brand) ;
	}

	public List<Brands> getAllBrands() {
		return brandRepo.findAll();
	}

	public void deleteBrand(int brand_id) {
		brandRepo.deleteById(brand_id);
		
	}
	

}
