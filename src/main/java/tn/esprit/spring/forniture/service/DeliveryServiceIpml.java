package tn.esprit.spring.forniture.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.forniture.entity.Delivery;
import tn.esprit.spring.forniture.entity.Livreur;
import tn.esprit.spring.forniture.entity.Livreur.StateLivreur;
import tn.esprit.spring.forniture.repository.DeliveryRepository;
import tn.esprit.spring.forniture.repository.LivreurRepository;



@Service
public class DeliveryServiceIpml implements IDeliveyService {

	@Autowired
	DeliveryRepository deliveryRepository;

	@Autowired
	LivreurRepository livreurRepository;
	 
	
	@Override
	public String passerLivraison(Delivery delivery) {

	
			deliveryRepository.save(delivery);
	
		return "delivery went successfully";
	}

	

	@Override
	public List<Delivery> finddel() {
		
		return (List<Delivery>) deliveryRepository.findAll();
	}

	@Override
	public void delete(long id) {
		deliveryRepository.deleteById(id);
		
	}

	@Override
	public Delivery updateDelivery(Delivery delivery) {
		return deliveryRepository.save(delivery);
	}



	@Override
	public void affecterLivraisonALivreur(Long idLivreur, long idDelivery) {
		Livreur livreurManage = livreurRepository.findById(idLivreur).get();
		Delivery DeliveryManage = deliveryRepository.findById(idDelivery).get();	
		
		
		
	if(livreurManage.getStateLivreur().equals(livreurManage.getStateLivreur().InActive)){
	
		 System.out.println("Ce livreur est non disponible pour le momment");
		
	}
	else 
		livreurManage.setNbMission(livreurManage.getNbMission()+1);
	livreurManage.getStateLivreur();
	livreurManage.setStateLivreur( StateLivreur.InActive);
	DeliveryManage.setLivreur(livreurManage);
    deliveryRepository.save(DeliveryManage);
	livreurRepository.save(livreurManage);
		
	}

	
	
	
}
