package tn.esprit.spring.forniture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import tn.esprit.spring.contract.Contract;
import tn.esprit.spring.contract.ContractRepository;
import tn.esprit.spring.exception.NotSubscribedException;
import tn.esprit.spring.forniture.entity.User;
import tn.esprit.spring.forniture.repository.UserRepository;
import tn.esprit.spring.insurance.Insurance;
import tn.esprit.spring.insurance.InsuranceRepository;
import tn.esprit.spring.subscription.Subscription;
import tn.esprit.spring.subscription.SubscriptionRepository;

@Service
public class UserServiceImpl {

	@Autowired
	UserRepository ur;

	@Autowired
	SubscriptionRepository sr;

	@Autowired
	ContractRepository cr;

	@Autowired
	InsuranceRepository ir;

	public long addUser(User user) {
		return ur.save(user).getId();
//		return ur.save(user).getUserId();
	}

	public User findUser(long userId) {
		return ur.findById(userId).orElse(null);
	}
	
	public User findUserByContractId(int contractId){
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

	public void affectSubToSeller(int subId, long sellerId) {
		User user = ur.findById(sellerId).get();
		Subscription sub = sr.findById(subId).get();
		if (!ObjectUtils.isEmpty(user) && !ObjectUtils.isEmpty(sub)) {
			if (ObjectUtils.isEmpty(user.getSub())) {
				sub.setUser(user);
				sr.save(sub);
			}
		}

	}

	public void affectContractToSeller(int contractId, long sellerId) {
		User user = ur.findById(sellerId).get();
		Contract contract = cr.findById(contractId).get();
		if (ObjectUtils.isEmpty(user.getSub()))
			throw new NotSubscribedException("You are not subscribed, please subscribe to initiate contracts!");
		else if (!ObjectUtils.isEmpty(user) && !ObjectUtils.isEmpty(contract)) {
			contract.setUser(user);
			cr.save(contract);
		}
	}

	public void affectInsuranceToBuyer(int insId, long buyerId) {
		User user = ur.findById(buyerId).get();
		Insurance insurance = ir.findById(insId).get();
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

	public long getUserNumber() {
		// TODO Auto-generated method stub
		return ur.count();
	}

	// *****************Percentages*****************
	public double getUserPercentWithInsurances() {
		double result = (double) getUserNumberWithInsurances() / (double) getUserNumber();
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
}
