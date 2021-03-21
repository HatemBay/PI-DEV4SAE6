package tn.esprit.spring.offer;

import java.text.ParseException;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface OfferService {
	
	public int addOffer(Offer offer);
	public Offer findOffer(int offerId);
	public List<Offer> getAllOffers();
	public List<OfferFav> getAllFav();
	public List<OfferHistory> getAllHis();
	public void updateOfferType(int offerId, String type);
	public void updateOfferPrice(int offerId, float price);
	public void updateOfferName(int offerId, String Name);
	public void updateOfferAdress(int offerId, String adress);
	public void updateOfferDescription(int offerId, String description);
	public void updateOfferDAirC(int offerId, String airC);
	public void updateOfferDPool(int offerId, String pool);
	public void updateOfferDChamb(int offerId, int ChamNb);
	public void updateOfferDLevel(int offerId, int LevelNb);
	public void updateOfferDSpace(int offerId, int Space);
	public void updateOfferDstart(int offerId, String start) throws ParseException;
	public void updateOfferDend(int offerId, String end) throws ParseException;
	Offer favAff(int offerId);
	public void sendMessageWithAttachment();
	
	public long getSubNumberJPQL();
	public void deleteOffer(int offerId);
	public void deleteOfferFav(int offerId);
	public void deleteOfferHis(int offerId);
	public void Scheduler();
	void Scheduler2(String email);
	
	
	
}
