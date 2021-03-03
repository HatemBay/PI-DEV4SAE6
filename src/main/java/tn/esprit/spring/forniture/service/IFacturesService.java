package tn.esprit.spring.forniture.service;


import java.util.List;


import tn.esprit.spring.forniture.entity.Factures;

public interface IFacturesService {
	public long ajouterFacture(Factures facture);
	public void supprimerFacture(long idFacture);
	public  Factures updateFacture(Factures f);
	
	public List<Factures> getAllfactures();
	
	
}
