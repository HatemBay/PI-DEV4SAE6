package tn.esprit.spring.forniture.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import tn.esprit.spring.forniture.entity.ChargeRequest;
import tn.esprit.spring.forniture.entity.Commande;

import tn.esprit.spring.forniture.repository.CommandeRepository;
import tn.esprit.spring.forniture.repository.DeliveryRepository;
import tn.esprit.spring.forniture.repository.FurnitureRepository;
import tn.esprit.spring.forniture.repository.LigneCommandeRepository;
import tn.esprit.spring.forniture.repository.LivreurRepository;
//import tn.esprit.spring.forniture.repository.UserRepository;


@Service
public class CommandeServiceImpl implements ICommandeService {

	//@Autowired
	//UserRepository userRepository;

	@Autowired
	LigneCommandeRepository ligneCommandeRepository;
	@Autowired
	CommandeRepository commandeRepository;
	@Autowired
	FurnitureRepository furnitureRepository;
	@Autowired
	ICommandeService icommandeService;
	@Autowired
	IDeliveyService ideliveryService;
	@Autowired
	DeliveryRepository deliveryRepository;
	@Autowired
	LivreurRepository livreurRepository;
	

	
	


	@Override
	public List<Commande> retrieveAllCommandes() {
		return (List<Commande>) commandeRepository.findAll();
	}

	@Override
	public void deleteCommande(Long id) {
		commandeRepository.deleteById(id);
		
	}

	@Override
	public Commande addCommande(Commande c) {
		
		return commandeRepository.save(c);
	}

	@Override
	public Commande updateCommande(Commande c) {
		// TODO Auto-generated method stub
		return commandeRepository.save(c);
	}

}
