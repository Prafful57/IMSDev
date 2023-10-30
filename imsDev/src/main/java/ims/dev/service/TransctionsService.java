package ims.dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ims.dev.entity.Transctions;
import ims.dev.repo.TransctionsRepo;

@Service
public class TransctionsService {

	@Autowired
	private TransctionsRepo transRepo;

	public List<Transctions> getTransctions() {
		return transRepo.findAll();
	}

	public Transctions saveTransction(Transctions transction) {
		return transRepo.save(transction);
	}

	
	
	
}
