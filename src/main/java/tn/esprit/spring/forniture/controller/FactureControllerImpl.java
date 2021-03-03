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

import tn.esprit.spring.forniture.entity.Factures;
import tn.esprit.spring.forniture.service.IFacturesService;

@RestController
public class FactureControllerImpl {
	
	@Autowired
	IFacturesService facturesService;
	
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-all-Factures
			@GetMapping("/retrieve-all-Factures")
			public List<Factures> getFactures() {

			List<Factures> list = facturesService.getAllfactures();
			return list;

			}

			
			
			// Ajouter Factures : http://localhost:8081/SpringMVC/servlet/add-Facture
			
			@PostMapping("/add-Facture")
			public long addFacture(@RequestBody Factures f) {
				long facture = facturesService.ajouterFacture(f);
			return facture;
			}
			
			
			// http://localhost:8081/SpringMVC/servlet/modify-Facture
			
			@PutMapping("/modify-Facture")
			public Factures modifyFacture(@RequestBody Factures facture) {
			return facturesService.updateFacture(facture);
			}
			
			
			// http://localhost:8081/SpringMVC/servlet/remove-Facture/{Facture-id}
			
			@DeleteMapping("/remove-Facture/{Facture-id}")
			public void removeFacture(@PathVariable("Facture-id") long factureid) {
				facturesService.supprimerFacture(factureid);
			}
			
	
	
	
	
}
