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
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/all-transctions")
public class TransctionsController {

	@Autowired
	private TransctionsService transService;
	
	@Autowired
	private TransctionsRepo transRepo;
	
	@PostMapping("/transction")
	public ResponseEntity<?> makeTransction(@RequestBody Transctions transction) {
		log.debug("Saved Transction : ", transction );
		transService.saveTransction(transction);
		 return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/get-transctions")
	public List<Transctions> getALLTransctions(){
		log.info("Getting Users List");
		return transService.getTransctions();
	}
	
	@PutMapping("/update-transction/{transction_id}")
	public ResponseEntity<?> updateTransction(@PathVariable int transction_id, @RequestBody Transctions transction) {
		log.debug("Updating transction with transctionId : ",transction_id);
		boolean transctionId = transRepo.existsById(transction_id);
		if(transctionId==false) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Transctions trans = transRepo.findById(transction_id).get();
		trans.setTrancstion_type(transction.getTrancstion_type());
//		trans.setTransction_date(null);
		transRepo.save(trans);
		return ResponseEntity.accepted().body(trans);
	}
	
	
	//transction cant be deleted
	
}
