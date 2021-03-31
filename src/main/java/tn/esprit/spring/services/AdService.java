package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import tn.esprit.spring.models.Ad;
import tn.esprit.spring.repositories.AdRepository;

public class AdService {

	
	
	@Autowired
	private AdRepository repo ;
	
	
	List<Ad> searchDescription(String entry){
		return this.repo.findByDescriptionContaining(entry);	
	}

	List<Ad> searchPrice(float p1 , float p2){
		return this.repo.findByPriceBetween(p1, p2);	
	}

}
