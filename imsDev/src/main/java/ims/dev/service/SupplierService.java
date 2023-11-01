package ims.dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ims.dev.entity.Supplier;
import ims.dev.repo.SupplierRepo;

@Service
public class SupplierService {

	@Autowired
	private SupplierRepo supRepo;
	
 	public Supplier saveSupplier(Supplier supplier) {
	  return supRepo.save(supplier);
	}

	public List<Supplier> getAllSuppliers() {
		return supRepo.findAll();
	}

	public void deleteSupplier(int supplier_id) {
		supRepo.deleteById(supplier_id);
	}

}
