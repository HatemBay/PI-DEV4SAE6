package tn.esprit.spring.forniture.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.primefaces.model.file.UploadedFiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.forniture.entity.Commande;
import tn.esprit.spring.forniture.entity.Furniture;
import tn.esprit.spring.forniture.entity.FurnitureState;
import tn.esprit.spring.forniture.entity.LigneCommande;
import tn.esprit.spring.forniture.repository.CommandeRepository;
import tn.esprit.spring.forniture.repository.FurnitureRepository;
import tn.esprit.spring.forniture.repository.LigneCommandeRepository;

@Service
public class FurnitureServiceImpl implements IFurnitureService{

	@Autowired
	FurnitureRepository furnitureRepository;
	
	@Autowired
	 LigneCommandeRepository ligneCommandeRepository ;
	@Autowired
	CommandeRepository commandeRepository;

	
	
	@Override
	public int ajouterMeuble(Furniture furniture) {
		
		furnitureRepository.save(furniture);
		
		
		
		return furniture.getId();
	}



	@Override
	public List<Furniture> getAllFurniture() {
	
		return (List<Furniture>) furnitureRepository.findAll();
	}
	@Override
	public Optional<Furniture> getById(int id) {
		
		return (Optional<Furniture>) furnitureRepository.findById(id);
	}



	@Override
	public void deleteFurnitureById(int furnitureId) {
		furnitureRepository.delete(furnitureRepository.findById(furnitureId).get());
		
	}

	




	@Override
	public Furniture updateForniture( Furniture furiture, int id) {
		Furniture fur=	furnitureRepository.findById(id).get();
		
		furiture.setId(fur.getId());
		furnitureRepository.save(furiture);
		return furiture;
	}



	@Override
	public List<String> getAllFurnitureNamesJPQL() {
		return  furnitureRepository.furnitureNames();
	}



	@Override
	public int getNombreFurnitureJPQL() {
		return furnitureRepository.countFurn();
	}


    @Transactional
	@Override
	public String addMeubleDansPanier12(int furnitureId, int quantity, long panierId) {
		// bech na3mlou insertion fi table de jointure ;
		
				ligneCommandeRepository.setPannier(furnitureId,quantity, panierId);
				
//				LigneCommande card = ligneCommandeRepository.findById(panierId).get();
//				Furniture furniture = furnitureRepository.findById(furnitureId).get();
				
				return "product added";
	}



	@Override
	public String incrementMeubleDansPanier12(int furnitureId, int quantity, long panierId) {
		LigneCommande card = ligneCommandeRepository.findById(panierId).get();
		Furniture furniture = furnitureRepository.findById(furnitureId).get();
		Map<Furniture,Long> map =card.getFurnitures();

		map.put(furniture, (long) quantity);
	//	 map.remove(furniture);
		card.setFurnitures(map);
		System.out.println("mmlmlml"+card.getFurnitures());
		System.out.println(card.getFurnitures().values());
		ligneCommandeRepository.save(card);
		
		return "product updated";
	}



	@Override
	public String deleteMeubleFromPanier12(int furnitureId, long panierId) {
		
		LigneCommande card = ligneCommandeRepository.findById(panierId).get();
		Furniture furniture = furnitureRepository.findById(furnitureId).get();
		Map<Furniture,Long> map =card.getFurnitures();
		 map.remove(furniture);
		card.setFurnitures(map);
		
		ligneCommandeRepository.save(card);
		
		return "product deleted";
	}



	@Override
	public List<String> getFurnitureByCard(Long idCard) {
		return ligneCommandeRepository.getFurnitureByCard(idCard);
	}



	@Override
	public int getQuantityFurnitureByCart(int idProd, long idCart) {
		return furnitureRepository.nombreProduitByCart(idProd, idCart);
	}



	@Override
	public int updateQuantityFurnitureAfterCommande(int idProd, long idCmd) {
		Commande c =commandeRepository.findById(idCmd).get();
		Furniture furniture = furnitureRepository.findById(idProd).get();
		int nombreByCart= getQuantityFurnitureByCart(idProd, c.getLigneCommande().getId());
		int nmobreFurniture= furniture.getQuantity();
	
		if(c.getStatus().equals("CONFIRMED")){
			
			nmobreFurniture=nmobreFurniture-nombreByCart;
			System.out.println("nbr===="+nmobreFurniture);
			System.out.println("test====="+nombreByCart);
			furniture.setQuantity(nmobreFurniture);
			furnitureRepository.save(furniture);
			if( nmobreFurniture==0){
				
				furniture.setState(FurnitureState.Inactive);
				System.out.println("ttttttttttttt"+furniture.getState());
				furnitureRepository.save(furniture);
			}

			
		}

		furnitureRepository.save(furniture);
		return (nmobreFurniture);

	}



	@Override
	public void addProduitWithImage(Furniture p, UploadedFiles files) {
		// TODO Auto-generated method stub
		
	}



}
