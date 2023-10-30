package ims.dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ims.dev.entity.Transctions;
import ims.dev.repo.TransctionsRepo;
import ims.dev.service.TransctionsService;

@RestController
@RequestMapping("/all-transctions")
public class TransctionsController {

	@Autowired
	private TransctionsService transService;
	
	@Autowired
	private TransctionsRepo transRepo;
	
	@PostMapping("/transction")
	public ResponseEntity<HttpStatus> makeTransction(@RequestBody Transctions transction) {
		transService.saveTransction(transction);
		 return ResponseEntity.ok(HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/get-transctions")
	public List<Transctions> getALLTransctions(){
		return transService.getTransctions();
	}
	
	@PutMapping("/update-transction/{transction_id}")
	public ResponseEntity<Transctions> updateTransction(@PathVariable int transction_id, @RequestBody Transctions transction) {
		Transctions trans = transRepo.findById(transction_id).get();
		trans.setTrancstion_type(transction.getTrancstion_type());
//		trans.setTransction_date(null);
		transRepo.save(trans);
		return ResponseEntity.accepted().body(trans);
	}
	
	
	//transction cant be deleted
	
}
