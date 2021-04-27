package tn.esprit.spring.forniture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tn.esprit.spring.contract.Contract;
import tn.esprit.spring.forniture.entity.User;
import tn.esprit.spring.forniture.service.UserServiceImpl;
import tn.esprit.spring.insurance.Insurance;
import tn.esprit.spring.subscription.Subscription;

@RestController
public class UserController {

	@Autowired
	UserServiceImpl us;

	private static final Logger LOG = LoggerFactory.getLogger("LOG");

	@PostMapping("/users/add")
	public long newUser(@RequestBody User user) {
		return us.addUser(user);
	}

	@GetMapping("/users/get/{userId}")
	public User getUser(@PathVariable long userId) {
		return us.findUser(userId);
	}

	@GetMapping("/users/get-by-contract/{contractId}")
	public User getUserByContractId(@PathVariable int contractId) {
		return us.findUserByContractId(contractId);
	}
	
	@GetMapping("/users/get-all")
	public List<User> getAllUsers() {
		return us.getAllUsers();
	}
//
//	@PutMapping("/users/update-name/{userId}/{name}")
//	public void updateUserName(@PathVariable long userId, @PathVariable String name) {
//		LOG.info("Username updated");
//		us.updateUserName(userId, name);
//	}
//	
//	@PutMapping("/users/update-email/{userId}/{email}")
//	public void updateEmail(@PathVariable long userId, @PathVariable String email) {
//		LOG.info("Email updated");
//		us.updateEmail(userId, email);
//	}

	@PostMapping("/subs/affect-sub-seller/{sellerId}")
	public void affectSubToSeller(@RequestBody Subscription sub, @PathVariable Long sellerId) {
		us.affectSubToSeller(sub, sellerId);
		LOG.info("Subscription affected to seller");
	}

	@PostMapping("/contracts/affect-contract-seller/{sellerId}")
	public void affectContractToSeller(@RequestBody Contract contract, @PathVariable Long sellerId) {
		us.affectContractToSeller(contract, sellerId);
		LOG.info("Contract affected to seller");
	}


	// *****************JPQL*****************


	@GetMapping("/users/nb-with-sub")
	public long getSubbedUserNumber() {
		return us.getSubbedUserNumber();
	}

	@GetMapping("/users/nb-with-contract")
	public long getUserNumberWithContracts() {
		return us.getUserNumberWithContracts();
	}
	// **************************************

	@GetMapping("/users/nb")
	public long getUserNumber() {
		return us.getUserNumber();
	}

	// *****************Percentages*****************
	@GetMapping("/users/percent-with-insurance")
	public double getUserPercentWithInsurances() {
		return us.getUserPercentWithInsurances();
	}
	
	@GetMapping("/users/percent-with-insurance-from-contracts")
	public double getUserPercentWithInsurancesFromContracts() {
		return us.getUserPercentWithInsurancesFromContracts();
	}

	@GetMapping("/users/percent-with-sub")
	public double getSubbedUserPercent() {
		return us.getSubbedUserPercent();
	}

	@GetMapping("/users/percent-with-contract")
	public double getUserPercentWithContracts() {
		return us.getUserPercentWithContracts();
	}
	
	@PutMapping("/users/affect-off-buyer/{offerId}/{sellerId}")
	public void affectSubToBuyer(@PathVariable int offerId, @PathVariable Long sellerId) {
		us.affectOfferToBuyer(offerId, sellerId);
		LOG.info("offer affected to buyer");
	}
	
	@PutMapping("/users/affect-offh-buyer/{offerId}/{sellerId}")
	public void affectOfferHToBuyer(@PathVariable int offerId, @PathVariable Long sellerId) {
		us.affectOfferHToBuyer(offerId, sellerId);
		LOG.info("offerH affected to buyer");
	}

	@PostMapping("/insurances/affect-insurance-seller/{buyerId}")
	public void affectInsuranceToSeller(@RequestBody Insurance insurance, @PathVariable Long buyerId) {
		us.affectInsuranceToBuyer(insurance, buyerId);
		LOG.info("Insurance affected to buyer");
	}

	// *****************JPQL*****************
	@GetMapping("/users/nb-with-offer")
	public long getUserNumberWithInsurances() {
		return us.getUserNumberWithOffer();
	}

	
	@GetMapping("/users/get-avg-prices")
	public float getAvgPrices() {
		return us.getAvgPrices();
	}
	
	@GetMapping("/users/get-max-prices")
	public float getMaxPrices() {
		return us.getMaxPrices();
	}
	
	@GetMapping("/users/get-min-prices")
	public float getMinPrices() {
		return us.getMinPrices();
	}
	
	@GetMapping("/users/get-avg-space")
	public float getAvgSpace() {
		return us.getAvgSpace();
	}
	
	@GetMapping("/users/get-min-space")
	public float getMinSpace() {
		return us.getMinSpace();
	}
	
	@GetMapping("/users/get-max-space")
	public float getMaxSpace() {
		return us.getMaxSpace();
	}
	
	@GetMapping("/users/get-avg-price-user/{id}")
	public float getAvgPricePerUser(@PathVariable int id) {
		return us.getAvgPricePerUser(id);
	}
	
	@GetMapping("/users/get-min-price-user/{id}")
	public float getMinPricePerUser(@PathVariable int id) {
		return us.getMinPricePerUser(id);
	}
	
	@GetMapping("/users/get-max-price-user/{id}")
	public float getMaxPricePerUser(@PathVariable int id) {
		return us.getMaxPricePerUser(id);
	}
	
	@GetMapping("/users/get-avg-space-user/{id}")
	public float getAvgSpacePerUser(@PathVariable int id) {
		return us.getAvgSpacePerUser(id);
	}
	
	@GetMapping("/users/get-min-space-user/{id}")
	public float getMinSpacePerUser(@PathVariable int id) {
		return us.getMinSpacePerUser(id);
	}
	
	@GetMapping("/users/get-max-space-user/{id}")
	public float getMaxSpacePerUser(@PathVariable int id) {
		return us.getMaxSpacePerUser(id);
	}
	
	@GetMapping("/users/get-pool-number/{pool}")
	public float getPoolNumber(@PathVariable String pool) {
		return us.getPoolNumber(pool);
	}
	
	
	// **************************************



	// *****************Percentages*****************
	@GetMapping("/users/percent-with-offer")
	public double getUserPercentWithOffers() {
		return us.getUserPercentWithOffers();
	}
	// *********************************************

	@DeleteMapping("/users/delete/{userId}")
	public void deleteUser(@PathVariable long userId) {
		us.deleteUser(userId);
		LOG.info("User deleted successfully");
	}
}
