package tn.esprit.spring.seller;

import java.util.List;


import org.springframework.data.repository.query.Param;

import tn.esprit.spring.offer.Offer;

public interface SellerService {

	public Long addseller(Seller seller);

	public Seller findseller(int sellerId);
	
	public Seller findsellerByContractId(int contractId);

	public List<Seller> getAllsellers();

	public void updatesellerName(int sellerId, String name);

	public void updateEmail(int sellerId, String email);

	public void affectOfferToBuyer(int subId, int sellerId);
	
	public void affectOfferHToBuyer(int subId, int sellerId);

	public void affectContractToSeller(int contractId, int sellerId);

	public void affectInsuranceToBuyer(int insId, int buyerId);

	// *****************JPQL*****************
	public long getsellerNumberWithOffer();
	
	public float getAvgPrices();
	
	public float getMinPrices();
	
	public float getMaxPrices();
	
	public float getAvgPricePerseller(int id);
	
	public float getMinPricePerseller(int id);
	
	public float getMaxPricePerseller(int id);
	
	public long getPoolNumber(String pool);
	
	public float getAvgSpace();
	
	public float getMinSpace();
	
	public float getMaxSpace();
	
	public float getAvgSpacePerseller(int id);
	
	public float getMinSpacePerseller(int id);
	
	public float getMaxSpacePerseller(int id);
	
	
	
	

	// **************************************

	public long getsellerNumber();

	// *****************Percentages*****************
	public double getsellerPercentWithOffers();


	// *********************************************

	public void deleteseller(int sellerId);

}
