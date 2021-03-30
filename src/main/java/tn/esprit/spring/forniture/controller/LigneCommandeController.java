package tn.esprit.spring.forniture.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.forniture.repository.LigneCommandeRepository;
import tn.esprit.spring.forniture.service.ILigneCommandeService;



@RestController
@RequestMapping("/Panier")
public class LigneCommandeController {
	
	
	@Autowired
	ILigneCommandeService ligneCommandeService;
	
	@Autowired
	LigneCommandeRepository ligneCommandeRepository;
	
	
	@PostMapping("/ajouter/{idUser}")
	@ResponseBody
	public String ajouterLigneCommande(@PathVariable ("idUser")long idUser ){
		
		
		   ligneCommandeService.saveLigneCommande(idUser);
		
		
		return "added";	    
	}
	
	
	
	
	
}
