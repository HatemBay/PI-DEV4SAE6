package tn.esprit.spring.user;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;


import tn.esprit.spring.offer.OfferRepository;
import tn.esprit.spring.subscription.SubscriptionRepository;
import tn.esprit.spring.offer.*;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository ur;


	@Autowired
	OfferRepository or;
	
	@Autowired
	OfferHRepository oh;
	


	@Override
	public int addUser(User user) {
		return ur.save(user).getUserId();
	}

	@Override
	public User findUser(int userId) {
		return ur.findById(userId).orElse(null);
	}
	
	@Override
	public User findUserByContractId(int contractId){
		return ur.findUserByContractId(contractId).orElse(null);
	}

	@Override
	public List<User> getAllUsers() {
		return ur.findAll();
	}

	@Override
	public void updateUserName(int userId, String name) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void updateEmail(int userId, String email) {
		// TODO Auto-generated method stub

	}

	@Override
	public void affectOfferToBuyer(int offerId, int buyerId) {
		User user = ur.findById(buyerId).get();
		Offer offer = or.findById(offerId).get();
		if (!ObjectUtils.isEmpty(user) && !ObjectUtils.isEmpty(offer)) {
			
				offer.setUser(user);
				or.save(offer);}
		

		
		

	}
	
	@Override
	public void affectOfferHToBuyer(int offerId, int buyerId) {
		User user = ur.findById(buyerId).get();
		OfferHistory offer = oh.findById(offerId).get();
		if (!ObjectUtils.isEmpty(user) && !ObjectUtils.isEmpty(offer)) {
			
				offer.setUser(user);
				oh.save(offer);}
		

		
		

	}

	@Override
	public void affectContractToSeller(int contractId, int sellerId) {
	/*	User user = ur.findById(sellerId).get();
		Contract contract = cr.findById(contractId).get();
		if (ObjectUtils.isEmpty(user.getSub()))
			throw new NotSubscribedException("You are not subscribed, please subscribe to initiate contracts!");
		else if (!ObjectUtils.isEmpty(user) && !ObjectUtils.isEmpty(contract)) {
			contract.setUser(user);
			cr.save(contract);
		}*/
	}

	@Override
	public void affectInsuranceToBuyer(int insId, int buyerId) {
		/*User user = ur.findById(buyerId).get();
		Insurance insurance = ir.findById(insId).get();
		if (ObjectUtils.isEmpty(user.getSub()))
			throw new NotSubscribedException("You are not subscribed, please subscribe to initiate insurance!");
		if (!ObjectUtils.isEmpty(user) && !ObjectUtils.isEmpty(insurance)) {
			insurance.setUser(user);
			ir.save(insurance);
		}*/
	}

	// *****************JPQL*****************
	@Override
	public long getUserNumberWithOffer() {
		// TODO Auto-generated method stub
		return ur.getUserNumberWithOffer();
	}


	
	@Override
	public float getAvgPrices() {
		// TODO Auto-generated method stub
		return ur.getAvgPrices();
	}
	
	@Override
	public float getAvgPricePerUser(int id) {
		// TODO Auto-generated method stub
		return ur.getAvgPricePerUser(id);
	}
	
	@Override
	public float getMinPricePerUser(int id) {
		// TODO Auto-generated method stub
		return ur.getMinPricePerUser(id);
	}

	@Override
	public float getMaxPricePerUser(int id) {
		// TODO Auto-generated method stub
		return ur.getMaxPricePerUser(id);
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
	public float getAvgSpacePerUser(int id) {
		// TODO Auto-generated method stub
		return ur.getAvgSpacePerUser(id);
	}

	@Override
	public float getMinSpacePerUser(int id) {
		// TODO Auto-generated method stub
		return ur.getMinSpacePerUser(id);
	}

	@Override
	public float getMaxSpacePerUser(int id) {
		// TODO Auto-generated method stub
		return ur.getMaxSpacePerUser(id);
	}


	// **************************************

	@Override
	public long getUserNumber() {
		// TODO Auto-generated method stub
		return ur.count();
	}

	// *****************Percentages*****************
	@Override
	public double getUserPercentWithOffers() {
		double result = (double) getUserNumberWithOffer()/(double) getUserNumber() ;
		return result;
	}


	// *********************************************

	@Override
	public void deleteUser(int userId) {
		ur.deleteById(userId);
	}










}
