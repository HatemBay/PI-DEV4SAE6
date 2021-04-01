package tn.esprit.spring.forniture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.forniture.entity.LigneCommande;
import tn.esprit.spring.forniture.service.ILigneCommandeService;

@RestController
public class LC_ControllerImpl {

	
	@Autowired
	ILigneCommandeService lignecomm;
	
	
	// Ajouter User : http://localhost:8000/add-LC_Commande/{idUser}
	
			@PostMapping("/add-LC_Commande/{idUser}")
			public LigneCommande addLC_Commande(@PathVariable("idUser")  long idUser) {
				LigneCommande lccommande = lignecomm.saveLigneCommande(idUser);
			return lccommande;
			}
			
	
	
	
}
