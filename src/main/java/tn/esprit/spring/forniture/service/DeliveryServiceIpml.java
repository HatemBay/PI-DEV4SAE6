package tn.esprit.spring.forniture.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.forniture.entity.Delivery;

import tn.esprit.spring.forniture.repository.DeliveryRepository;



@Service
public class DeliveryServiceIpml implements IDeliveyService {

	@Autowired
	DeliveryRepository deliveryRepository;



	
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

	
	
	
}
