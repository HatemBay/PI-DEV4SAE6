package tn.esprit.spring.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	UserRepository repository;
	
	@Autowired
	OfferHService repository2;
	
	@Autowired
	OfferService repository3;

	@Override
	public List<Offer> findByName(String name) {
		OfferHistory offer2 = new OfferHistory(name);
		List<Offer>  offers =repository.findByName(name);
		if(offers.isEmpty())
		 {
			repository2.addOffer(offer2);
		 }

		 return offers;
	
	}

	
	
	@Override
	public List<Offer> findByPriceGreaterThan(float price) {
		return repository.findByPriceGreaterThan(price);
	}

	public List<Offer> searchOffer(String search) {
		return repository.searchOffer(search);
	}
	
	public List<Offer> searchOfferWithParam(String description ,String name ,float price,int levelNB ,int space, int chamNb) {
		
		OfferHistory offer2 = new OfferHistory(name,description,price,space,levelNB,chamNb);
		List<Offer>  offers =repository.searchOfferWithParam(description,name,price,levelNB,space,chamNb);
		if(offers.isEmpty())
		 {
			repository2.addOffer(offer2);
		 }

		 return offers;
	


		

	}
	
	public List<Offer> 	searchOfferWithParamAff(String description ,String name ,float price,int levelNB ,int space, int chamNb) {
		
		 return repository.searchOfferWithParamHistoryX(description,name,price,levelNB,space,chamNb);

	}
	

	
	public List<Offer> searchOfferPool(String spool) {
		return repository.searchOfferPool(Integer.parseInt(spool));
	}
	
	public List<Offer> findByPriceBetween(float from, float to) {
		return repository.findByPriceBetween(from, to);
		

	


	}



}
