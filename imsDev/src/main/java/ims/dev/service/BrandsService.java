package ims.dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ims.dev.entity.Brands;
import ims.dev.repo.BrandsRepo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BrandsService {

	
	@Autowired
	private BrandsRepo brandRepo;

	public Brands saveBrand(Brands brand) {
		log.debug("Saved Brand Service : ",brand);
		return brandRepo.save(brand) ;
	}

	public List<Brands> getAllBrands() {
		log.info("Getting all Brands from repo");
		return brandRepo.findAll();
	}

	public void deleteBrand(int id) {
		log.debug("Deleting brand from repo with brandID : ",id);
		brandRepo.deleteById(id);
		
	}
	

}
