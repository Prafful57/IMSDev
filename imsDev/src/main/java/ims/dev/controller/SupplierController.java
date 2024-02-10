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

import ims.dev.entity.Supplier;
import ims.dev.repo.SupplierRepo;
import ims.dev.service.SupplierService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/all-suppliers")
public class SupplierController {

	@Autowired
	private SupplierService  supService;
	
	@Autowired
	private SupplierRepo supRepo;
	
	@PostMapping("/supplier")
	public ResponseEntity<?> saveSupplier(@RequestBody Supplier supplier){
		log.debug("Saving Supplier :", supplier);
		supService.saveSupplier(supplier);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);	
	}
	
	@GetMapping("/get-suppliers")
	public List<Supplier> getSuppliers() {
		log.info("Getting list of all Suppliers");
		return supService.getAllSuppliers();
	}
	
	@DeleteMapping("/delete-supplier/{id}")
	public ResponseEntity<?> deleteSupplier(@PathVariable int id) {
		log.debug("Deleting supplier with SupplierId : ",id);
		boolean supplierId = supRepo.existsById(id);
		if(supplierId==false) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		supService.deleteSupplier(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/update-supplier/{id}")
	public ResponseEntity<?> updateSupplier(@PathVariable int id,@RequestBody Supplier supplier) {
		log.debug("Updating Supplier by SupplierId : ", id);
		boolean supplierId = supRepo.existsById(id);
		if(supplierId==false) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Supplier supp = supRepo.findById(id).get();
		supp.setSupplierName(supplier.getSupplierName());
		supp.setContact(supplier.getContact());
		supRepo.save(supp);
		return ResponseEntity.accepted().body(supp);
	}
	
}
