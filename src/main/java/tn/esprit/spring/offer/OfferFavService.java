package tn.esprit.spring.offer;

import java.text.ParseException;
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public interface OfferFavService {
	
	//public <OfferHistory extends Offer> List<OfferHistory> addOffers(Iterable<OfferHistory> entities);
	public int addOffer(OfferFav offer);
	public List<OfferFav> getOfferFavPerUser(int id);


	
	
	
}
