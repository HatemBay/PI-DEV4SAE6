package tn.esprit.spring.seller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import tn.esprit.spring.subscription.SubscriptionRepository;
import tn.esprit.spring.offer.*;

@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	SellerRepository ur;


	@Autowired
	OfferRepository or;
	
	@Autowired
	OfferHRepository oh;
	


	@Override
	public Long addseller(Seller seller) {
		return ur.save(seller).getSellerId();
	}

	@Override
	public Seller findseller(int sellerId) {
		return ur.findById(sellerId).orElse(null);
	}
	
	@Override
	public Seller findsellerByContractId(int contractId){
		return ur.findsellerByContractId(contractId).orElse(null);
	}

	@Override
	public List<Seller> getAllsellers() {
		return ur.findAll();
	}

	@Override
	public void updatesellerName(int sellerId, String name) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void updateEmail(int sellerId, String email) {
		// TODO Auto-generated method stub

	}

	@Override
	public void affectOfferToBuyer(int offerId, int buyerId) {
		Seller seller = ur.findById(buyerId).get();
		Offer offer = or.findById(offerId).get();
		if (!ObjectUtils.isEmpty(seller) && !ObjectUtils.isEmpty(offer)) {
			
				offer.setSeller(seller);
				or.save(offer);}
		

		
		

	}
	
	@Override
	public void affectOfferHToBuyer(int offerId, int buyerId) {
		Seller seller = ur.findById(buyerId).get();
		OfferHistory offer = oh.findById(offerId).get();
		if (!ObjectUtils.isEmpty(seller) && !ObjectUtils.isEmpty(offer)) {
			
				offer.setSeller(seller);
				oh.save(offer);}
		

		
		

	}

	@Override
	public void affectContractToSeller(int contractId, int sellerId) {
	/*	seller seller = ur.findById(sellerId).get();
		Contract contract = cr.findById(contractId).get();
		if (ObjectUtils.isEmpty(seller.getSub()))
			throw new NotSubscribedException("You are not subscribed, please subscribe to initiate contracts!");
		else if (!ObjectUtils.isEmpty(seller) && !ObjectUtils.isEmpty(contract)) {
			contract.setseller(seller);
			cr.save(contract);
		}*/
	}

	@Override
	public void affectInsuranceToBuyer(int insId, int buyerId) {
		/*seller seller = ur.findById(buyerId).get();
		Insurance insurance = ir.findById(insId).get();
		if (ObjectUtils.isEmpty(seller.getSub()))
			throw new NotSubscribedException("You are not subscribed, please subscribe to initiate insurance!");
		if (!ObjectUtils.isEmpty(seller) && !ObjectUtils.isEmpty(insurance)) {
			insurance.setseller(seller);
			ir.save(insurance);
		}*/
	}

	// *****************JPQL*****************
	@Override
	public long getsellerNumberWithOffer() {
		// TODO Auto-generated method stub
		return ur.getsellerNumberWithOffer();
	}


	
	@Override
	public float getAvgPrices() {
		// TODO Auto-generated method stub
		return ur.getAvgPrices();
	}
	
	@Override
	public float getAvgPricePerseller(int id) {
		// TODO Auto-generated method stub
		return ur.getAvgPricePerseller(id);
	}
	
	@Override
	public float getMinPricePerseller(int id) {
		// TODO Auto-generated method stub
		return ur.getMinPricePerseller(id);
	}

	@Override
	public float getMaxPricePerseller(int id) {
		// TODO Auto-generated method stub
		return ur.getMaxPricePerseller(id);
	}
	
	@Override
	public long getPoolNumber(String pool) {
		// TODO Auto-generated method stub
		return ur.getPoolNumber(pool);
	}
	
	@Override
	public float getMinPrices() {
		// TODO Auto-generated method stub
		return ur.getMinPrices();
	}

	@Override
	public float getMaxPrices() {
		// TODO Auto-generated method stub
		return ur.getMaxPrices();
	}

	@Override
	public float getAvgSpace() {
		// TODO Auto-generated method stub
		return ur.getAvgSpace();
	}

	@Override
	public float getMinSpace() {
		// TODO Auto-generated method stub
		return ur.getMinSpace();
	}

	@Override
	public float getMaxSpace() {
		// TODO Auto-generated method stub
		return ur.getMaxSpace();
	}

	@Override
	public float getAvgSpacePerseller(int id) {
		// TODO Auto-generated method stub
		return ur.getAvgSpacePerseller(id);
	}

	@Override
	public float getMinSpacePerseller(int id) {
		// TODO Auto-generated method stub
		return ur.getMinSpacePerseller(id);
	}

	@Override
	public float getMaxSpacePerseller(int id) {
		// TODO Auto-generated method stub
		return ur.getMaxSpacePerseller(id);
	}
	



	// **************************************

	@Override
	public long getsellerNumber() {
		// TODO Auto-generated method stub
		return ur.count();
	}

	// *****************Percentages*****************
	@Override
	public double getsellerPercentWithOffers() {
		double result = (double) getsellerNumberWithOffer()/(double) getsellerNumber() ;
		return result;
	}


	// *********************************************

	@Override
	public void deleteseller(int sellerId) {
		ur.deleteById(sellerId);
	}











}
