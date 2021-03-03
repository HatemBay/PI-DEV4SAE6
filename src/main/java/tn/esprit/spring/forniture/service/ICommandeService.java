package tn.esprit.spring.forniture.service;

import java.util.List;

import tn.esprit.spring.forniture.entity.Commande;

public interface ICommandeService {
	
	
	List<Commande> retrieveAllCommandes();
	
	void deleteCommande(Long id);
	
	Commande addCommande(Commande c);
	
	Commande updateCommande(Commande c);
}
