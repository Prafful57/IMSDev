package ims.dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ims.dev.entity.Transctions;
import ims.dev.repo.TransctionsRepo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TransctionsService {

	@Autowired
	private TransctionsRepo transRepo;

	public List<Transctions> getTransctions() {
		log.info("Getting all transctions from repo");
		return transRepo.findAll();
	}

	public Transctions saveTransction(Transctions transction) {
		log.debug("Saving transction from repo : ", transction);
		return transRepo.save(transction);
	}

	
	
	
}
