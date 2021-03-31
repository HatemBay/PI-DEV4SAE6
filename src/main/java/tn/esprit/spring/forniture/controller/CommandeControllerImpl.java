package tn.esprit.spring.forniture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.forniture.entity.Commande;
import tn.esprit.spring.forniture.repository.CommandeRepository;
import tn.esprit.spring.forniture.service.CommandeServiceImpl;
import tn.esprit.spring.forniture.service.ICommandeService;

@RestController
public class CommandeControllerImpl {
	
	@Autowired
	ICommandeService commservice;
	
	@Autowired
	CommandeServiceImpl commandeService;
	
	@Autowired
	CommandeRepository commandeRepository;
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-all-Commandes
		@GetMapping("/retrieve-all-Commandes")
		public List<Commande> getUsers() {

		List<Commande> list = commservice.retrieveAllCommandes();
		return list;

		}

		
		
		// Ajouter User : http://localhost:8081/SpringMVC/servlet/add-Commande
		
		@PostMapping("/add-Commande")
		public Commande addCommande(@RequestBody Commande c) {
			Commande commande = commservice.addCommande(c);
		return commande;
		}
		
		
		// http://localhost:8081/SpringMVC/servlet/modify-Commande
		
		@PutMapping("/modify-Commande")
		public Commande modifyCommande(@RequestBody Commande commande) {
		return commservice.updateCommande(commande);
		}
		
		
		// http://localhost:8081/SpringMVC/servlet/remove-commande/{commande-id}
		
		@DeleteMapping("/remove-commande/{commande-id}")
		public void removeUser(@PathVariable("commande-id") long commandeId) {
			commservice.deleteCommande(commandeId);
		}
		
		
		@PostMapping("/ajouter/{idUser}/{idCart}/{typePayement}")
		@ResponseBody
		public ResponseEntity<List<Commande>> ajouetrCommande(@PathVariable("idUser") Long idUser,
															  @PathVariable("idCart")long idCart,
															  @PathVariable("typePayement")String typePayement){
			List<Commande> list =commandeRepository.findAll();
//			//Commande cmd = new Commande();
//			LigneCommande l = new LigneCommande();
//			if(list.isEmpty()){
			//cmd.getLigneCommande().equals(l.getId());
			commservice.saveCommande(idUser, idCart,typePayement);
			return ResponseEntity.ok(list);
			
		//}
		//return ResponseEntity.ok(list);		
			
		
		}
		
		@PutMapping(value = "/addCommandeFurniture/{idCommande}/{idProduct}") 
		public String addCommandeFurniture(@PathVariable("idCommande") long idCommande, @PathVariable("idProduct") int idProduct){
		   return   commservice.addCommandeFurniture(idCommande, idProduct);
			
		}
		
		@PutMapping(value = "/add-commande-contract/{idCommande}/{idContract}") 
		public String addCommandeContract(@PathVariable("idCommande") long idCommande, @PathVariable("idContract") int idContract){
		   return   commandeService.addCommandeContract(idCommande, idContract);
			
		}
		
		
		@GetMapping(value = "/getCommandeProductNameByIdUser/{idUser}")
		@ResponseBody
		public List<String> getCommandeProductNameByIdUser(@PathVariable("idUser") Long idUser){
			return commservice.getCommandeProductNameByIdUser(idUser);
		}
		
		@GetMapping(value = "/getPrixTotal/{idCart}")
		@ResponseBody
		public Double PrixTotalCommande(@PathVariable("idCart") Long idCart){
			return commservice.prixTotaleLigneCommande(idCart);
		}
		
		
		
		// URL : http://localhost:8000/affecterUser_A_Commande/{idc}/{idu}
		   @PutMapping(value = "affecterUser_A_Commande/{idc}/{idu}")
			public void affecterCommande_A_Facture(@PathVariable("idc")int idCommande, @PathVariable("idu")int idUser){
			   commservice.affecterUserACommande(idCommande, idUser);
		   }
}
