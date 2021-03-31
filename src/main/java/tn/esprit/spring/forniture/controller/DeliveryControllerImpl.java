package tn.esprit.spring.forniture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.forniture.entity.Delivery;
import tn.esprit.spring.forniture.service.IDeliveyService;

@RestController
public class DeliveryControllerImpl {

	@Autowired
IDeliveyService deliveryservice;
	
	

// Ajouter furniture : http://localhost:8081/SpringMVC/servlet/add-Delivery

	@PostMapping("/add-Delivery")
	public String ajouterDelivery(@RequestBody Delivery delivery) {
		String del = deliveryservice.passerLivraison(delivery);
	return del;
	}
	
	/*
	{
        "deliveryId": 3,
        "customerName": "faysel",
        "description": "delivery to ben arous",
        "stateDelivery": "Approved"}
	
	*/
	

	// http://localhost:8081/SpringMVC/servlet/AllDel
	
			@GetMapping("/AllDel")
			public List<Delivery> retrieveAlldel(){
				List<Delivery> list = deliveryservice.finddel();
				return list;
				
			}
			
			
			
			// http://localhost:8081/SpringMVC/servlet/remove-Delivery/{Delivery-id}
			
			@DeleteMapping("/remove-Delivery/{Delivery-id}")
			public void removeDelivery(@PathVariable("Delivery-id") int deliveryId) {
				deliveryservice.delete(deliveryId);
			}	
			
			
			
			

			// http://localhost:8081/SpringMVC/servlet/modify-Delivery
			@PutMapping("/modify-Delivery")
			public Delivery modifyDelivery(@RequestBody Delivery delivery) {
			return deliveryservice.updateDelivery(delivery);
			}


			@PutMapping("/affecterLivraisonALivreur/{idLivreur}/{idDelivery}")
			@ResponseBody
			public void affecterLivraisonALivreur(@PathVariable ("idLivreur")long idLivreur, @PathVariable ("idDelivery") long idDelivery){
				
				
				deliveryservice.affecterLivraisonALivreur(idLivreur, idDelivery);


			    
			}





}
