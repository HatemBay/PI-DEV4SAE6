package tn.esprit.spring.forniture.service;

import java.util.List;

import tn.esprit.spring.forniture.entity.Delivery;


public interface IDeliveyService {
	public String passerLivraison(Delivery delivery);
	public List <Delivery> finddel();
	public void delete (long id );
	public  Delivery updateDelivery(Delivery delivery);
	
	
	public void affecterLivraisonALivreur(Long idLivreur,long idDelivery);
	
	

}
