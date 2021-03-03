package tn.esprit.spring.forniture.service;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.forniture.entity.Commande;
import tn.esprit.spring.forniture.entity.Factures;
import tn.esprit.spring.forniture.repository.CommandeRepository;
import tn.esprit.spring.forniture.repository.FactureRepository;





@Service
public class FacturesService implements IFacturesService {

	@Autowired
	FactureRepository factureRepository;
	@Autowired
	CommandeRepository commandeRepository;

	@Override
	public long ajouterFacture(Factures facture) {
		factureRepository.save(facture);
		return facture.getId();
	}

	@Override
	public void supprimerFacture(long idFacture) {
		factureRepository.deleteById(idFacture);
	}


	@Override
	public List<Factures> getAllfactures() {
		return (List<Factures>) factureRepository.findAll();
	}


	@Override
	public Factures updateFacture(Factures f) {
		// TODO Auto-generated method stub
		return factureRepository.save(f);
	}

	

	
}
