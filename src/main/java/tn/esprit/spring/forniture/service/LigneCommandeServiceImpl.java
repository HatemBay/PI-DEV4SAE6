package tn.esprit.spring.forniture.service;







import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.forniture.entity.LigneCommande;
import tn.esprit.spring.forniture.entity.User;
import tn.esprit.spring.forniture.repository.CommandeRepository;
import tn.esprit.spring.forniture.repository.FurnitureRepository;
import tn.esprit.spring.forniture.repository.LigneCommandeRepository;
import tn.esprit.spring.forniture.repository.UserRepository;




@Service
public class LigneCommandeServiceImpl implements ILigneCommandeService{


	@Autowired
	FurnitureRepository furnitureRepository;

	@Autowired
	CommandeRepository commandeRepository;
	
	@Autowired
	LigneCommandeRepository ligneCommandeRepository;
	@Autowired
	UserRepository userRepository;


	@Override
	public List<LigneCommande> getAllProductByCart() {
		return  (List<LigneCommande>) ligneCommandeRepository.findAll();
	}
//	@Override
//	public LigneCommande findLigneCommande(int idFurniture,Long idClient,Long idCommande){
//		return ligneCommandeRepository.findLigneCommande(idFurniture, idClient,idCommande);
//	}
//
//	
	
	
	@Override
	public LigneCommande  saveLigneCommande(long idUser) {
		LigneCommande c = new LigneCommande();
		

		
		User userMAnage = userRepository.findById(idUser).get();
	
	
		

		c.setUser(userMAnage);
		
	
	return  ligneCommandeRepository.save(c);
		
	}


	@Override
	public int countFurnitureByCart(Long idCard) {
		
		return ligneCommandeRepository.countFurnitureByCart(idCard);
	}

	
	

	


	
	
}
