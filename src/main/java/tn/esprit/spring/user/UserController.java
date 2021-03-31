package tn.esprit.spring.user;

import java.util.List;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	UserServiceImpl us;

	private static final Logger LOG = LoggerFactory.getLogger("LOG");

	@PostMapping("/users/add")
	public int newUser(@RequestBody User user) {
		return us.addUser(user);
	}

	@GetMapping("/users/get/{userId}")
	public User getUser(@PathVariable int userId) {
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

	@PutMapping("/users/update-name/{userId}/{name}")
	public void updateUserName(@PathVariable int userId, @PathVariable String name) {
		LOG.info("Username updated");
		us.updateUserName(userId, name);
	}
	
	@PutMapping("/users/update-email/{userId}/{email}")
	public void updateEmail(@PathVariable int userId, @PathVariable String email) {
		LOG.info("Email updated");
		us.updateEmail(userId, email);
	}

	@PutMapping("/users/affect-off-buyer/{offerId}/{sellerId}")
	public void affectSubToBuyer(@PathVariable int offerId, @PathVariable int sellerId) {
		us.affectOfferToBuyer(offerId, sellerId);
		LOG.info("offer affected to buyer");
	}
	
	@PutMapping("/users/affect-offh-buyer/{offerId}/{sellerId}")
	public void affectOfferHToBuyer(@PathVariable int offerId, @PathVariable int sellerId) {
		us.affectOfferHToBuyer(offerId, sellerId);
		LOG.info("offerH affected to buyer");
	}

	@PutMapping("/users/affect-contract-seller/{contractId}/{sellerId}")
	public void affectContractToSeller(@PathVariable int contractId, @PathVariable int sellerId) {
		us.affectContractToSeller(contractId, sellerId);
		LOG.info("Contract affected to seller");
	}

	@PutMapping("/users/affect-insurance-seller/{insuranceId}/{buyerId}")
	public void affectInsuranceToSeller(@PathVariable int insuranceId, @PathVariable int buyerId) {
		us.affectInsuranceToBuyer(insuranceId, buyerId);
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

	@GetMapping("/users/nb")
	public long getUserNumber() {
		return us.getUserNumber();
	}

	// *****************Percentages*****************
	@GetMapping("/users/percent-with-offer")
	public double getUserPercentWithOffers() {
		return us.getUserPercentWithOffers();
	}

	// *********************************************

	@DeleteMapping("/users/delete/{userId}")
	public void deleteUser(@PathVariable int userId) {
		us.deleteUser(userId);
		LOG.info("User deleted successfully");
	}
}
