package tn.esprit.spring.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.models.Ad;
import tn.esprit.spring.models.Type;
import tn.esprit.spring.repositories.AdRepository;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class AdController {
	
	
	
	@Autowired
	private AdRepository repo ;
	
	
			// Create ad
			@PostMapping("/addAd")
			public Ad createAd(@RequestBody  Ad e) {
				return this.repo.save(e);

			}

			// get all ads
			@GetMapping("/allAd")
			public List<Ad> getAds(){
				return repo.findAll();
				}
			
			
			// update ad 
			@PutMapping("/updateAd/{id}")
			public ResponseEntity<Ad> updateAd (@PathVariable(value="id") long uid,
					@RequestBody Ad x )
			{
				Ad e = repo.getOne(uid);
				e.setSuperficie(x.getSuperficie());
				e.setDescription(x.getDescription());
				e.setType(x.getType());
				e.setPrice(x.getPrice());
				e.setJardin(x.isJardin());
				e.setGarage(x.isGarage());
				
				repo.save(e);
				return ResponseEntity.ok().build();	
			}

			
			//delete ad
			@DeleteMapping("/deleteAd/{id}")  
			private void deleteAd(@PathVariable("id") long id)   
			{
				Ad e = repo.getOne(id);

			this.repo.delete(e);
			} 
			
			
			// find by type
			
			@GetMapping("getByType/{t}")
			public List<Ad> getAdsByType(@PathVariable("t") Type t){
				return repo.findAdByType(t);
				}
			
			
			// search
			
			@GetMapping("search/{entry}")
			public List<Ad> searchFor(@PathVariable("entry") String entry){
				return this.repo.findByDescriptionContaining(entry);
			}
			
			// search price
			@GetMapping("searchByPrice")
			public List<Ad> searchByPrice(@RequestParam float p1,@RequestParam float p2){
				return this.repo.findByPriceBetween(p1, p2);
			}
			
			
			
			}
