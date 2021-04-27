package tn.esprit.spring.forniture.service;

import java.util.List;
import java.util.Optional;

import org.primefaces.model.file.UploadedFiles;
import tn.esprit.spring.forniture.entity.Furniture;


public interface IFurnitureService {

	public int ajouterMeuble(Furniture furniture);
	public List<Furniture> getAllFurniture();
	public void deleteFurnitureById(int furnitureId);
	public Furniture updateForniture( Furniture furiture,int id) ;
	public Optional<Furniture> getById(int id);
	
	 public List<String> getAllFurnitureNamesJPQL();
		public int getNombreFurnitureJPQL();
		//public List<Furniture> getAllFurnitureByCard(ShoppingCard card);
		public String addMeubleDansPanier12(int furnitureId,int quantity, long panierId);
		public String incrementMeubleDansPanier12(int furnitureId,int quantity, long panierId);
		public String deleteMeubleFromPanier12(int furnitureId, long panierId);
		public List<String> getFurnitureByCard(Long idCard);
		public int getQuantityFurnitureByCart(int idProd,long idCart);
		public int updateQuantityFurnitureAfterCommande(int idProd, long idCmd);
		public void addProduitWithImage(Furniture p, UploadedFiles files);
	}

	
	
	

