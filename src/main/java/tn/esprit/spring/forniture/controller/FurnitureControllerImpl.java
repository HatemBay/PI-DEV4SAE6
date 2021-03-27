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

	
	/* {
	        "id": 1,
	        "name": "sallon",
	        "description": "sallon en bonne état",
	        "price": 1500.0,
	        "quantity": 1,
	        "publishedDate": "2021-03-11T00:00:00.000+00:00",
	        "image": "sallon.png",
	        "state": "New",
	        "barcode": 123456789
	    } */
	
	
	
	
	// http://localhost:8081/SpringMVC/servlet/AllFurnitures
			@GetMapping("/AllFurnitures")
			public List<Furniture> retrieveAllFurnitures(){
				List<Furniture> list = fornitureservice.getAllFurniture();
				return list;
				
			}
			
	
			
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
			
			
			
			
			
			
			// http://localhost:8081/SpringMVC/servlet/getAllFurnituresNamesJPQL
			@GetMapping(value = "/getAllFurnituresNamesJPQL")
			@ResponseBody
			public List<String> getAllFurnitureNamesJPQL() {

				return fornitureservice.getAllFurnitureNamesJPQL();
			}
			
			
			
			
			// http://localhost:8081/SpringMVC/servlet/addMeubleDansPanier12/{idmeuble}/{quantity}/{panierId}
			
			@PutMapping(value = "/addMeubleDansPanier12/{idmeuble}/{quantity}/{panierId}")
			public String addMeubleDansPanier(@PathVariable("idmeuble") int idmeuble, @PathVariable("quantity") int quantity,
					@PathVariable("panierId") long panierId) {
				return fornitureservice.addMeubleDansPanier12(idmeuble, quantity, panierId);

			}

			
			// http://localhost:8081/SpringMVC/servlet/incrementMeubleDansPanier12/{idmeuble}/{quantity}/{panierId}
			
			@PutMapping(value = "/incrementMeubleDansPanier12/{idmeuble}/{quantity}/{panierId}")
			public String incrementMeubleDansPanier12(@PathVariable("idmeuble") int idmeuble,
					@PathVariable("quantity") int quantity, @PathVariable("panierId") long panierId) {
				return fornitureservice.incrementMeubleDansPanier12(idmeuble, quantity, panierId);

			}

			
			// http://localhost:8081/SpringMVC/servlet/deleteMeubleFromPanier12/{idmeuble}/{panierId}
	
			@DeleteMapping(value = "/deleteMeubleFromPanier12/{idmeuble}/{panierId}")
			public String deleteMeubleFromPanier12(@PathVariable("idmeuble") int idmeuble,
					@PathVariable("panierId") long panierId) {
				return fornitureservice.deleteMeubleFromPanier12(idmeuble, panierId);

			}

			// http://localhost:8081/SpringMVC/servlet/getFurnitureByCard/{panierId}

			@GetMapping(value = "/getFurnitureByCard/{panierId}")
			public List<String> getFurnitureByCard(@PathVariable("panierId") long panierId) {
				return fornitureservice.getFurnitureByCard(panierId);

			}
			
			
			// http://localhost:8081/SpringMVC/servlet/getNombreFurnitureJPQL

			@GetMapping(value = "/getNombreFurnitureJPQL")
			@ResponseBody
			public int getNombreFurnitureJPQL() {
				return fornitureservice.getNombreFurnitureJPQL();
			}

			
			// http://localhost:8081/SpringMVC/servlet/updateQuantityFurnitureAfterCommande/{idProd}/{idCmd}

			@PostMapping("/updateQuantityFurnitureAfterCommande/{idProd}/{idCmd}")
			@ResponseBody
			public int updateQuantityFurnitureAfterCommande(@PathVariable("idProd") int idProd,
					@PathVariable("idCmd") long idCmd) {

				return fornitureservice.updateQuantityFurnitureAfterCommande(idProd, idCmd);
			}
			
			
			
			
			
			
			
			
			
			
}
