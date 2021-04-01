package tn.esprit.spring.forniture.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.contract.Contract;
import tn.esprit.spring.contract.ContractRepository;
import tn.esprit.spring.contract.ContractService;
//import tn.esprit.spring.forniture.entity.ChargeRequest;
import tn.esprit.spring.forniture.entity.Commande;
import tn.esprit.spring.forniture.entity.Delivery;
import tn.esprit.spring.forniture.entity.Factures;
import tn.esprit.spring.forniture.entity.LigneCommande;
import tn.esprit.spring.forniture.entity.User;
import tn.esprit.spring.forniture.repository.CommandeRepository;
import tn.esprit.spring.forniture.repository.DeliveryRepository;
import tn.esprit.spring.forniture.repository.FurnitureRepository;
import tn.esprit.spring.forniture.repository.LigneCommandeRepository;
import tn.esprit.spring.forniture.repository.LivreurRepository;
//import tn.esprit.spring.forniture.repository.UserRepository;
import tn.esprit.spring.forniture.repository.UserRepository;
import tn.esprit.spring.insurance.InsuranceService;
import tn.esprit.spring.subscription.SubscriptionService;

@Service
public class CommandeServiceImpl implements ICommandeService {

	// @Autowired
	// UserRepository userRepository;

	@Autowired
	LigneCommandeRepository ligneCommandeRepository;
	@Autowired
	CommandeRepository commandeRepository;
	@Autowired
	FurnitureRepository furnitureRepository;
	@Autowired
	ICommandeService icommandeService;
	@Autowired
	IDeliveyService ideliveryService;
	@Autowired
	DeliveryRepository deliveryRepository;
	@Autowired
	LivreurRepository livreurRepository;

	@Autowired
	ContractService contractService;

	@Autowired
	ContractRepository contractRepository;

	@Autowired
	SubscriptionService subService;

	@Autowired
	InsuranceService insuranceService;

	@Autowired
	UserRepository userRepository;

	@Autowired
	StripeService stripeService;
	@Autowired
	UserRepository userRep;

	@Override
	public List<Commande> retrieveAllCommandes() {
		return (List<Commande>) commandeRepository.findAll();
	}

	@Override
	public void deleteCommande(Long id) {
		commandeRepository.deleteById(id);

	}

	@Override
	public Commande addCommande(Commande c) {
		return commandeRepository.save(c);
	}

	@Override
	public Commande updateCommande(Commande c) {

		return commandeRepository.save(c);
	}

	@Override
	public Commande saveCommande(Long idUser, long idCart, String typePayement) {
		Commande c = new Commande();
		User userManage = userRepository.findById(idUser).get();
		LigneCommande cardManag = ligneCommandeRepository.findById(idCart).get();
		System.out.println("tttttt" + c);

		Delivery d = deliveryRepository.findById(c.getDeliveries().getDeliveryId()).get();

		Delivery deliveryManage = deliveryRepository.findById(c.getDeliveries().getDeliveryId()).get();
		double nombre = commandeRepository.NombredeProduitByLigneCommande(idCart);
		c.setIdUser(userManage);
		c.setLigneCommande(cardManag);
		c.setStatus("IN_PROGRESS");
		System.out.println("aaa" + userManage);
		System.out.println("bbb" + cardManag);
		System.out.println("ccc" + nombre);
		ZoneId zid = ZoneId.of("Africa/Tunis");
		c.setDate(LocalDate.now(zid));

		commandeRepository.save(c);

		if (nombre > 60) {
			double t = icommandeService.prixTotaleLigneCommande(idCart);
			double p = icommandeService.PourcentageRemiseCommande(idCart, c.getId());
			System.out.println("tttt" + t);
			System.out.println("pppp" + p);
			c.setRemise("true");
			c.setTotal(t);
			c.setPourcentageDeRemise(p);
			double m = c.getTotal() - c.getPourcentageDeRemise();
			System.out.println("mmm" + m);
			c.setMontant(m);
			// c.setTypedePayment("EN_LIGNES");
			commandeRepository.save(c);
			if (typePayement.equals("EN_LIGNE")) {
				// if(stripeService.confirm(id))
				// appel service stripe
				// condition if payement validé
				c.setStatus("CONFIRMED");
				c.setTypedePayment(typePayement);
				c.setDeliveries(d);
				// condition if payement non validé
				// c.setStatus("IN_PROGRESS");
				commandeRepository.save(c);
			}
			if (typePayement.equals("PORTE_A_PORTE")) {
				// deliveryService.passerLivraison(d);
				if (d.getStateDelivery().equals(d.getStateDelivery().Approved)) {

					c.setStatus("CONFIRMED");
					c.setTypedePayment(typePayement);
				} else if (d.getStateDelivery().equals(d.getStateDelivery().IN_PROGRESS)) {
					c.setStatus("IN_PROGRESS");
					c.setTypedePayment(typePayement);

				}
				// appel service de livraison
				// condition if livraison apprové

				// condition if livraison non-apprové

				commandeRepository.save(c);

			}
			commandeRepository.save(c);
			// return c;
			//
		} else {

			c.setRemise("false");

			c.setTotal(icommandeService.prixTotaleLigneCommande(idCart));
			c.setMontant(c.getTotal());

			commandeRepository.save(c);

		}

		if (typePayement.equals("EN_LIGNE")) {
			// appel service stripe
			// condition if payement validééé
			c.setStatus("CONFIRMED");
			c.setTypedePayment(typePayement);
			// condition if payement non validé
			// c.setStatus("IN_PROGRESS");
			commandeRepository.save(c);
		} else if (typePayement.equals("PORTE_A_PORTE")) {

			if (d.getStateDelivery().equals(d.getStateDelivery().Approved)) {

				c.setStatus("CONFIRMED");
				c.setTypedePayment(typePayement);
			} else if (d.getStateDelivery().equals(d.getStateDelivery().IN_PROGRESS)) {
				c.setStatus("IN_PROGRESS");
				c.setTypedePayment(typePayement);

			}
			// appel service de livraison
			// condition if livraison apprové
			// c.setStatus("CONFIRMED");
			// c.setTypedePayment(typePayement);
			// condition if livraison non-apprové
			// c.setStatus("IN_PROGRESS");
			commandeRepository.save(c);

		}
		commandeRepository.save(c);

		// return commandeRepository.save(c);

		return c;
	}

	@Transactional
	@Override
	public String addCommandeFurniture(Long idCommande, int idProduct) {
		commandeRepository.setCommandeFurniture(idCommande, idProduct);
		return "product added";
	}

	@Transactional
	public String addCommandeContract(Long idCommande, int idContract) {
		commandeRepository.setCommandeContract(idCommande, idContract);
		return "contract added";
	}

	@Override
	public List<String> getCommandeProductNameByIdUser(Long idUser) {
		return commandeRepository.getCommandeProductNameByIdUser(idUser);
	}

	@Override
	public double prixTotaleLigneCommande(Long idCart) {
		return commandeRepository.getPrixTotalLigneCommande(idCart);
	}

	@Override
	public double PourcentageRemiseCommande(Long idCart, Long idCmd) {
		Commande c = commandeRepository.findById(idCmd).get();
		// double
		// nombre=commandeRepository.NombredeProduitByLigneCommande(idCart);
		double somme = prixTotaleLigneCommande(idCart);

		if (somme >= 200 && somme <= 499) {
			double pourcentage = (somme - somme * 0.1);
			return pourcentage;
		} else if (somme >= 500 && somme <= 999) {

			double pourcentage = (somme - somme * 0.15);
			return pourcentage;
		} else if (somme >= 1000) {
			double pourcentage = (somme - somme * 0.20);
			return pourcentage;
		} else {
			double pourcentage = (somme);
			return pourcentage;
		}
	}
	
	@Override                   
	public void affecterUserACommande( long idCommande, long idUser) {
		
		
		User u= userRep.findById(idUser).get();
		
		
		Commande c = commandeRepository.getOne(idCommande);
		
		
		c.setIdUser(u);
		
		commandeRepository.save(c);
	}
	
	@Override 
public void affecterLC_A_Commande( long idCommande, long idLc) {
		
		
	
	LigneCommande lc  = ligneCommandeRepository.findById(idLc).get();
		
		Commande c = commandeRepository.getOne(idCommande);
		
		
	
		c.setLigneCommande(lc);
		commandeRepository.save(c);
	}

	
	@Override
	public void affecterLivraison_A_Commande( long idCommande, long idliv) {
		
		
		Delivery del= deliveryRepository.findById(idliv).get();
	
			
			Commande c = commandeRepository.getOne(idCommande);
			
			
		
			c.setDeliveries(del);
			commandeRepository.save(c);
		}
}
