package ims.dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ims.dev.entity.Supplier;
import ims.dev.repo.SupplierRepo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SupplierService {

	@Autowired
	private SupplierRepo supRepo;
	
 	public Supplier saveSupplier(Supplier supplier) {
 	  log.debug("Saving supplier from repo : ", supplier);
	  return supRepo.save(supplier);
	}

	public List<Supplier> getAllSuppliers() {
		log.info("Get all data of suppliers from repo");
		return supRepo.findAll();
	}

	public void deleteSupplier(int supplier_id) {
		log.debug("Deleting supplier with supplierID : ", supplier_id);
		supRepo.deleteById(supplier_id);
	}

}
