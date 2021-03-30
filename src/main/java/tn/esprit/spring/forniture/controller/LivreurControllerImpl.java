package tn.esprit.spring.forniture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.forniture.entity.Livreur;
import tn.esprit.spring.forniture.service.ILivreurService;

@RestController
public class LivreurControllerImpl {

	
	@Autowired
	ILivreurService livreurService;
	

	
	
	// Ajouter furniture : http://localhost:8081/SpringMVC/servlet/add-Livreur
	
		@PostMapping("/add-Livreur")
		public Livreur ajouterLivreur(@RequestBody Livreur livreur) {
			Livreur livreuxr = livreurService.save(livreur);
		return livreuxr;
		}

		
		// http://localhost:8081/SpringMVC/servlet/AllLivreures
				@GetMapping("/AllLivreures")
				public List<Livreur> retrieveAllUsers(){
					List<Livreur> list = livreurService.findall();
					return list;
					
				}
				
				
			
				
				// http://localhost:8081/SpringMVC/servlet/remove-Livreur/{Livreur-id}
				@DeleteMapping("/remove-Livreur/{Livreur-id}")
				public void removeLivreur(@PathVariable("Livreur-id") int livreurId) {
					livreurService.delete(livreurId);
				}
		
				
				// http://localhost:8081/SpringMVC/servlet/modify-Livreur
				@PutMapping("/modify-Livreur")
				public Livreur modifyLivreur(@RequestBody Livreur livreur) {
				return livreurService.updateLiv(livreur);
				}
	
	
}
