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

import tn.esprit.spring.forniture.entity.User;
import tn.esprit.spring.forniture.service.UserServiceImpl;

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

	@PutMapping("/users/affect-sub-seller/{subId}/{sellerId}")
	public void affectSubToSeller(@PathVariable int subId, @PathVariable long sellerId) {
		us.affectSubToSeller(subId, sellerId);
		LOG.info("Subscription affected to seller");
	}

	@PutMapping("/users/affect-contract-seller/{contractId}/{sellerId}")
	public void affectContractToSeller(@PathVariable int contractId, @PathVariable long sellerId) {
		us.affectContractToSeller(contractId, sellerId);
		LOG.info("Contract affected to seller");
	}

	@PutMapping("/users/affect-insurance-seller/{insuranceId}/{buyerId}")
	public void affectInsuranceToSeller(@PathVariable int insuranceId, @PathVariable long buyerId) {
		us.affectInsuranceToBuyer(insuranceId, buyerId);
		LOG.info("Insurance affected to buyer");
	}

	// *****************JPQL*****************
	@GetMapping("/users/nb-with-insurance")
	public long getUserNumberWithInsurances() {
		return us.getUserNumberWithInsurances();
	}

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

	@GetMapping("/users/percent-with-sub")
	public double getSubbedUserPercent() {
		return us.getSubbedUserPercent();
	}

	@GetMapping("/users/percent-with-contract")
	public double getUserPercentWithContracts() {
		return us.getUserPercentWithContracts();
	}
	// *********************************************

	@DeleteMapping("/users/delete/{userId}")
	public void deleteUser(@PathVariable long userId) {
		us.deleteUser(userId);
		LOG.info("User deleted successfully");
	}
}
