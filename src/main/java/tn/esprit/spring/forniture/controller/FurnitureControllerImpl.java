package tn.esprit.spring.forniture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.forniture.entity.Furniture;
import tn.esprit.spring.forniture.service.IFurnitureService;

@RestController
public class FurnitureControllerImpl {



	@Autowired
    IFurnitureService fornitureservice;


	
	// Ajouter furniture : http://localhost:8081/SpringMVC/servlet/add-Furniture
	
	@PostMapping("/add-Furniture")
	public int ajouterMeublee(@RequestBody Furniture furniture) {
	int forniture = fornitureservice.ajouterMeuble(furniture);
	return forniture;
	}

	
	// http://localhost:8081/SpringMVC/servlet/AllFurnitures
			@GetMapping("/AllFurnitures")
			public List<Furniture> retrieveAllFurnitures(){
				List<Furniture> list = fornitureservice.getAllFurniture();
				return list;
				
			}
			
			
		//	public void deleteFurnitureById(int furnitureId);
			
			// http://localhost:8081/SpringMVC/servlet/remove-Furniture/{Furniture-id}
			@DeleteMapping("/remove-Furniture/{Furniture-id}")
			public void removeFurniture(@PathVariable("Furniture-id") int furnitureId) {
				fornitureservice.deleteFurnitureById(furnitureId);
			}
	
			
			// http://localhost:8081/SpringMVC/servlet/modify-Furniture
			@PutMapping("/modify-Furniture")
			public Furniture modifyFurniture(@RequestBody Furniture furniture) {
			return fornitureservice.updateForniture(furniture);
			}
}
