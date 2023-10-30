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

@RestController
@RequestMapping("/all-suppliers")
public class SupplierController {

	@Autowired
	private SupplierService  supService;
	
	@Autowired
	private SupplierRepo supRepo;
	
	@PostMapping("/supplier")
	public ResponseEntity<HttpStatus> saveSupplier(@RequestBody Supplier supplier){
		supService.saveSupplier(supplier);
		return ResponseEntity.accepted().body(HttpStatus.ACCEPTED);	
	}
	
	@GetMapping("/get-suppliers")
	public List<Supplier> getSuppliers() {
		return supService.getAllSuppliers();
	}
	
	@DeleteMapping("/delete-supplier/{supplier_id}")
	public ResponseEntity<HttpStatus> deleteSupplier(@PathVariable int supplier_id) {
		supService.deleteSupplier(supplier_id);
		return ResponseEntity.accepted().body(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/update-supplier/{supplier_id}")
	public ResponseEntity<Supplier> updateSupplier(@PathVariable int supplier_id,@RequestBody Supplier supplier) {
		Supplier supp = supRepo.findById(supplier_id).get();
		supp.setSupplier_name(supplier.getSupplier_name());
		supp.setContact(supplier.getContact());
		supRepo.save(supp);
		return ResponseEntity.accepted().body(supp);
	}
	
}
