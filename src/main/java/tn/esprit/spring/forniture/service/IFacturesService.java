package tn.esprit.spring.forniture.service;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import tn.esprit.spring.forniture.entity.Factures;

public interface IFacturesService {
	public long ajouterFacture(Factures facture);
	public void supprimerFacture(long idFacture);
	public  Factures updateFacture(Factures f);
	
	public List<Factures> getAllfactures();
	
	public void affecterCommandeAFacture(long idFacture,long idCommande);

	public Optional<Factures> getfacturesById(long idFacture);
	public List<Factures> getAllfacturesByCommande(long cmd);
	public List<Factures> getAllfacturesByPayementType(String payementType);
	public List<Factures> getAllfacturesByPayementstate(String payementState);
	public List<Factures> getfacturesByDatedepart(Date dateDep);
	public void modifier_type_facture(String type,long idFacture);
	public String  get_payment_type_by_factureID(long idFacture);	
	public void facturepdf (long idFacture,long idClient) ;
	
	
	
	
	
}
