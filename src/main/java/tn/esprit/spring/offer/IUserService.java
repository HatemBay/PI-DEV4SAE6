package tn.esprit.spring.offer;

import java.util.List;

public interface IUserService {
	List<Offer> findByName(String name);
	List<Offer> findByPriceGreaterThan(float price);
	List<Offer> searchOffer(String search);
	List<Offer> searchOfferPool(String spool);
	List<Offer> findByPriceBetween(float from, float to);
	List<Offer> searchOfferWithParam(String description ,String name ,float price ,int levelNB ,int space ,int chamNb);
	List<Offer> searchOfferWithParamAff(String description ,String name ,float price ,int levelNB ,int space ,int chamNb);

}
