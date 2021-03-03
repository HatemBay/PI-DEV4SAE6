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

import tn.esprit.spring.forniture.entity.Commande;
import tn.esprit.spring.forniture.service.ICommandeService;

@RestController
public class CommandeControllerImpl {
	
	@Autowired
	ICommandeService commservice;
	
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-all-Commandes
		@GetMapping("/retrieve-all-Commandes")
		public List<Commande> getUsers() {

		List<Commande> list = commservice.retrieveAllCommandes();
		return list;

		}

		
		
		// Ajouter User : http://localhost:8081/SpringMVC/servlet/add-Commande
		
		@PostMapping("/add-Commande")
		public Commande addCommande(@RequestBody Commande c) {
			Commande commande = commservice.addCommande(c);
		return commande;
		}
		
		
		// http://localhost:8081/SpringMVC/servlet/modify-Commande
		
		@PutMapping("/modify-Commande")
		public Commande modifyCommande(@RequestBody Commande commande) {
		return commservice.updateCommande(commande);
		}
		
		
		// http://localhost:8081/SpringMVC/servlet/remove-commande/{commande-id}
		
		@DeleteMapping("/remove-commande/{commande-id}")
		public void removeUser(@PathVariable("commande-id") long commandeId) {
			commservice.deleteCommande(commandeId);
		}
		
		
}
