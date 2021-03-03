package tn.esprit.spring.forniture.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import tn.esprit.spring.forniture.entity.Furniture;

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
	public void deleteFurnitureById(int furnitureId) {
		furnitureRepository.delete(furnitureRepository.findById(furnitureId).get());
		
	}

	




	@Override
	public Furniture updateForniture(Furniture furniture) {
		return furnitureRepository.save(furniture);
	}



}
