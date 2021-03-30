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

			
			/* 
			 * {
        "id": 1,
        "montant": 800.0,
        "date_de_depart": "2021-03-12T00:00:00.000+00:00",
        "type": "achat"
    }
    
    */
			
			
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
			
	
	
			
			
			// URL : http://localhost:8081/SpringMVC/servlet/affecterCommande_A_Facture
			   @PutMapping(value = "affecterCommande_A_Facture/{idf}/{idc}")
				public void affecterCommande_A_Facture(@PathVariable("idf")int idFacture,@PathVariable("idc")int idCommande){
				   facturesService.affecterCommandeAFacture(idFacture, idCommande);;
			   }
			   
			   
			// URL : http://localhost:8081/SpringMVC/servlet/afficherPDF/{id}/{idClient}
			   
			   @GetMapping(value = "/afficherPDF/{id}/{idClient}")
			   public void facturepdf (@PathVariable("id") int id,@PathVariable("idClient") long idClient) {
				   
				   facturesService.facturepdf(id,idClient);
			   }
			
	
	
}
