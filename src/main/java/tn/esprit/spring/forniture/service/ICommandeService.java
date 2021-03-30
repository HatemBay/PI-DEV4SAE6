package tn.esprit.spring.forniture.service;

import java.util.List;

import tn.esprit.spring.forniture.entity.Commande;

public interface ICommandeService {
	
	
	List<Commande> retrieveAllCommandes();
	
	void deleteCommande(Long id);
	
	Commande addCommande(Commande c);
	
	Commande updateCommande(Commande c);
	
	public Commande saveCommande(Long idUser,long idCart,String typePayement);
	
	public String addCommandeFurniture(Long idCommande,int idProduct);

	public List<String> getCommandeProductNameByIdUser(Long idUser);

	
	public double prixTotaleLigneCommande(Long idCart);

	public void affecterUserACommande( long idCommande, long idUser);
	public double PourcentageRemiseCommande(Long idCart,Long idCmd);
}
