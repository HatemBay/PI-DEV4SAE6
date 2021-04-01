package tn.esprit.spring.forniture.service;

import java.util.List;

import tn.esprit.spring.forniture.entity.LigneCommande;


public interface ILigneCommandeService {
//	public LigneCommande findOne(Long id);
//	public List<List<String>> panierParIdclient( long iduser);
	public List<LigneCommande> getAllProductByCart();
//	public LigneCommande findLigneCommande(int idFurniture,Long idClient,Long idCommande);
//	public List<List<String>> AjouterAuPanier(int idprod, long iduser,LigneCommande lc );
	public LigneCommande saveLigneCommande(long idUser);
	public int  countFurnitureByCart (Long idCard);
//	public Double PrixTotalCommande(long iduser);
	
	
}
