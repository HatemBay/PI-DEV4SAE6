package tn.esprit.spring.forniture.service;

import java.util.List;



import tn.esprit.spring.forniture.entity.Furniture;


public interface IFurnitureService {
	public int ajouterMeuble(Furniture furniture);
	public List<Furniture> getAllFurniture();
	public void deleteFurnitureById(int furnitureId);

	public Furniture updateForniture(Furniture furniture) ;
}
