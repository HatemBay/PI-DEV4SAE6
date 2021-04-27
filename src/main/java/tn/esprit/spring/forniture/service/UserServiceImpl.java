package tn.esprit.spring.forniture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import tn.esprit.spring.contract.Contract;
import tn.esprit.spring.contract.ContractRepository;
import tn.esprit.spring.contract.ContractService;
import tn.esprit.spring.exception.NotSubscribedException;
import tn.esprit.spring.forniture.entity.User;
import tn.esprit.spring.forniture.repository.UserRepository;
import tn.esprit.spring.insurance.Insurance;
import tn.esprit.spring.insurance.InsuranceRepository;
import tn.esprit.spring.insurance.InsuranceService;
import tn.esprit.spring.offer.Offer;
import tn.esprit.spring.offer.OfferHRepository;
import tn.esprit.spring.offer.OfferHistory;
import tn.esprit.spring.offer.OfferRepository;
import tn.esprit.spring.subscription.Subscription;
import tn.esprit.spring.subscription.SubscriptionRepository;
import tn.esprit.spring.subscription.SubscriptionService;

@Service
public class UserServiceImpl {

	@Autowired
	UserRepository ur;

	@Autowired
	SubscriptionRepository sr;

	@Autowired
	SubscriptionService ss;

	@Autowired
	ContractRepository cr;

	@Autowired
	ContractService cs;

	@Autowired
	InsuranceRepository ir;

	@Autowired
	InsuranceService is;

	@Autowired
	OfferRepository or;

	@Autowired
	OfferHRepository oh;

	public long addUser(User user) {
		return ur.save(user).getId();
		// return ur.save(user).getUserId();
	}

	public User findUser(long userId) {
		return ur.findById(userId).orElse(null);
	}

	public User findUserByContractId(int contractId) {
		return ur.findUserByContractId(contractId).orElse(null);
	}

	public List<User> getAllUsers() {
		return (List<User>) ur.findAll();
	}

	public void updateUserName(int userId, String name) {
		// TODO Auto-generated method stub

	}

	public void updateEmail(int userId, String email) {
		// TODO Auto-generated method stub

	}

	public void affectSubToSeller(Subscription sub, long sellerId) {
		User user = ur.findById(sellerId).get();
		if (!ObjectUtils.isEmpty(user) && !ObjectUtils.isEmpty(sub)) {
			ss.addSub(sub);
			sub.setUser(user);
			sr.save(sub);
		}
	}

	public void affectContractToSeller(Contract contract, long sellerId) {
		User user = ur.findById(sellerId).get();
		if (ObjectUtils.isEmpty(user.getSub()))
			throw new NotSubscribedException("You are not subscribed, please subscribe to initiate contracts!");
		else if (!ObjectUtils.isEmpty(user) && !ObjectUtils.isEmpty(contract)) {
			cs.addContract(contract);
			contract.setUser(user);
			cr.save(contract);
		}
	}

	public void affectInsuranceToBuyer(Insurance insurance, long buyerId) {
		User user = ur.findById(buyerId).get();
		is.addInsurance(insurance);
		if (ObjectUtils.isEmpty(user.getSub()))
			throw new NotSubscribedException("You are not subscribed, please subscribe to initiate insurance!");
		if (!ObjectUtils.isEmpty(user) && !ObjectUtils.isEmpty(insurance)) {
			insurance.setUser(user);
			ir.save(insurance);
		}
	}

	// *****************JPQL*****************
	public long getUserNumberWithInsurances() {
		// TODO Auto-generated method stub
		return ur.getUserNumberWithInsurances();
	}

	public long getSubbedUserNumber() {
		// TODO Auto-generated method stub
		return ur.getSubbedUserNumber();
	}

	public long getUserNumberWithContracts() {
		// TODO Auto-generated method stub
		return ur.getUserNumberWithContracts();
	}

	// **************************************

	// *****************Percentages*****************
	public double getUserPercentWithInsurances() {
		double result = (double) getUserNumberWithInsurances() / (double) getUserNumber();
		// System.out.println(getUserNumberWithInsurances());
		// System.out.println(getUserNumber());
		return result;
	}

	public double getUserPercentWithInsurancesFromContracts() {
		double result = (double) getUserNumberWithInsurances() / (double) getUserNumberWithContracts();
		return result;
	}

	public double getSubbedUserPercent() {
		double result = (double) getSubbedUserNumber() / (double) getUserNumber();
		return result;
	}

	public double getUserPercentWithContracts() {
		double result = (double) getUserNumberWithContracts() / (double) getUserNumber();
		return result;
	}
	// *********************************************

	public void deleteUser(long userId) {
		ur.deleteById(userId);
	}

	public void affectOfferToBuyer(int offerId, Long buyerId) {
		User user = ur.findById(buyerId).get();
		Offer offer = or.findById(offerId).get();
		if (!ObjectUtils.isEmpty(user) && !ObjectUtils.isEmpty(offer)) {

			offer.setUser(user);
			or.save(offer);
		}

	}

	public void affectOfferHToBuyer(int offerId, Long buyerId) {
		User user = ur.findById(buyerId).get();
		OfferHistory offer = oh.findById(offerId).get();
		if (!ObjectUtils.isEmpty(user) && !ObjectUtils.isEmpty(offer)) {

			offer.setUser(user);
			oh.save(offer);
		}

	}

	public void affectContractToSeller(int contractId, int sellerId) {
		/*
		 * User user = ur.findById(sellerId).get(); Contract contract =
		 * cr.findById(contractId).get(); if
		 * (ObjectUtils.isEmpty(user.getSub())) throw new
		 * NotSubscribedException("You are not subscribed, please subscribe to initiate contracts!"
		 * ); else if (!ObjectUtils.isEmpty(user) &&
		 * !ObjectUtils.isEmpty(contract)) { contract.setUser(user);
		 * cr.save(contract); }
		 */
	}

	public void affectInsuranceToBuyer(int insId, int buyerId) {
		/*
		 * User user = ur.findById(buyerId).get(); Insurance insurance =
		 * ir.findById(insId).get(); if (ObjectUtils.isEmpty(user.getSub()))
		 * throw new
		 * NotSubscribedException("You are not subscribed, please subscribe to initiate insurance!"
		 * ); if (!ObjectUtils.isEmpty(user) && !ObjectUtils.isEmpty(insurance))
		 * { insurance.setUser(user); ir.save(insurance); }
		 */
	}

	// *****************JPQL*****************

	public long getUserNumberWithOffer() {
		// TODO Auto-generated method stub
		return ur.getUserNumberWithOffer();
	}

	public float getAvgPrices() {
		// TODO Auto-generated method stub
		return ur.getAvgPrices();
	}

	public float getAvgPricePerUser(int id) {
		// TODO Auto-generated method stub
		return ur.getAvgPricePerUser(id);
	}

	public float getMinPricePerUser(int id) {
		// TODO Auto-generated method stub
		return ur.getMinPricePerUser(id);
	}

	public float getMaxPricePerUser(int id) {
		// TODO Auto-generated method stub
		return ur.getMaxPricePerUser(id);
	}

	public long getPoolNumber(String pool) {
		// TODO Auto-generated method stub
		return ur.getPoolNumber(pool);
	}

	public float getMinPrices() {
		// TODO Auto-generated method stub
		return ur.getMinPrices();
	}

	public float getMaxPrices() {
		// TODO Auto-generated method stub
		return ur.getMaxPrices();
	}

	public float getAvgSpace() {
		// TODO Auto-generated method stub
		return ur.getAvgSpace();
	}

	public float getMinSpace() {
		// TODO Auto-generated method stub
		return ur.getMinSpace();
	}

	public float getMaxSpace() {
		// TODO Auto-generated method stub
		return ur.getMaxSpace();
	}

	public float getAvgSpacePerUser(int id) {
		// TODO Auto-generated method stub
		return ur.getAvgSpacePerUser(id);
	}

	public float getMinSpacePerUser(int id) {
		// TODO Auto-generated method stub
		return ur.getMinSpacePerUser(id);
	}

	public float getMaxSpacePerUser(int id) {
		// TODO Auto-generated method stub
		return ur.getMaxSpacePerUser(id);
	}

	// **************************************

	public long getUserNumber() {
		// TODO Auto-generated method stub
		return ur.count();
	}

	// *****************Percentages*****************

	public double getUserPercentWithOffers() {
		double result = (double) getUserNumberWithOffer() / (double) getUserNumber();
		return result;
	}
}
