package tn.esprit.spring.seller;

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

import tn.esprit.spring.offer.Offer;

@RestController
public class SellerController {

	@Autowired
	SellerServiceImpl us;

	private static final Logger LOG = LoggerFactory.getLogger("LOG");

	@PostMapping("/sellers/add")
	public Long newseller(@RequestBody Seller seller) {
		return us.addseller(seller);
	}

	@GetMapping("/sellers/get/{sellerId}")
	public Seller getseller(@PathVariable int sellerId) {
		return us.findseller(sellerId);
	}

	@GetMapping("/sellers/get-by-contract/{contractId}")
	public Seller getsellerByContractId(@PathVariable int contractId) {
		return us.findsellerByContractId(contractId);
	}
	
	@GetMapping("/sellers/get-all")
	public List<Seller> getAllsellers() {
		return us.getAllsellers();
	}

	@PutMapping("/sellers/update-name/{sellerId}/{name}")
	public void updatesellerName(@PathVariable int sellerId, @PathVariable String name) {
		LOG.info("sellername updated");
		us.updatesellerName(sellerId, name);
	}
	
	@PutMapping("/sellers/update-email/{sellerId}/{email}")
	public void updateEmail(@PathVariable int sellerId, @PathVariable String email) {
		LOG.info("Email updated");
		us.updateEmail(sellerId, email);
	}

	@PutMapping("/sellers/affect-off-buyer/{offerId}/{sellerId}")
	public void affectSubToBuyer(@PathVariable int offerId, @PathVariable int sellerId) {
		us.affectOfferToBuyer(offerId, sellerId);
		LOG.info("offer affected to buyer");
	}
	
	@PutMapping("/sellers/affect-offh-buyer/{offerId}/{sellerId}")
	public void affectOfferHToBuyer(@PathVariable int offerId, @PathVariable int sellerId) {
		us.affectOfferHToBuyer(offerId, sellerId);
		LOG.info("offerH affected to buyer");
	}

	@PutMapping("/sellers/affect-contract-seller/{contractId}/{sellerId}")
	public void affectContractToSeller(@PathVariable int contractId, @PathVariable int sellerId) {
		us.affectContractToSeller(contractId, sellerId);
		LOG.info("Contract affected to seller");
	}

	@PutMapping("/sellers/affect-insurance-seller/{insuranceId}/{buyerId}")
	public void affectInsuranceToSeller(@PathVariable int insuranceId, @PathVariable int buyerId) {
		us.affectInsuranceToBuyer(insuranceId, buyerId);
		LOG.info("Insurance affected to buyer");
	}

	// *****************JPQL*****************
	@GetMapping("/sellers/nb-with-offer")
	public long getsellerNumberWithInsurances() {
		return us.getsellerNumberWithOffer();
	}

	
	@GetMapping("/sellers/get-avg-prices")
	public float getAvgPrices() {
		return us.getAvgPrices();
	}
	
	@GetMapping("/sellers/get-max-prices")
	public float getMaxPrices() {
		return us.getMaxPrices();
	}
	
	@GetMapping("/sellers/get-min-prices")
	public float getMinPrices() {
		return us.getMinPrices();
	}
	
	@GetMapping("/sellers/get-avg-space")
	public float getAvgSpace() {
		return us.getAvgSpace();
	}
	
	@GetMapping("/sellers/get-min-space")
	public float getMinSpace() {
		return us.getMinSpace();
	}
	
	@GetMapping("/sellers/get-max-space")
	public float getMaxSpace() {
		return us.getMaxSpace();
	}
	
	@GetMapping("/sellers/get-avg-price-seller/{id}")
	public float getAvgPricePerseller(@PathVariable int id) {
		return us.getAvgPricePerseller(id);
	}
	
	@GetMapping("/sellers/get-min-price-seller/{id}")
	public float getMinPricePerseller(@PathVariable int id) {
		return us.getMinPricePerseller(id);
	}
	
	@GetMapping("/sellers/get-max-price-seller/{id}")
	public float getMaxPricePerseller(@PathVariable int id) {
		return us.getMaxPricePerseller(id);
	}
	
	@GetMapping("/sellers/get-avg-space-seller/{id}")
	public float getAvgSpacePerseller(@PathVariable int id) {
		return us.getAvgSpacePerseller(id);
	}
	
	@GetMapping("/sellers/get-min-space-seller/{id}")
	public float getMinSpacePerseller(@PathVariable int id) {
		return us.getMinSpacePerseller(id);
	}
	
	@GetMapping("/sellers/get-max-space-seller/{id}")
	public float getMaxSpacePerseller(@PathVariable int id) {
		return us.getMaxSpacePerseller(id);
	}
	
	@GetMapping("/sellers/get-pool-number/{pool}")
	public float getPoolNumber(@PathVariable String pool) {
		return us.getPoolNumber(pool);
	}
	

	
	
	
	
	// **************************************

	@GetMapping("/sellers/nb")
	public long getsellerNumber() {
		return us.getsellerNumber();
	}

	// *****************Percentages*****************
	@GetMapping("/sellers/percent-with-offer")
	public double getsellerPercentWithOffers() {
		return us.getsellerPercentWithOffers();
	}

	// *********************************************

	@DeleteMapping("/sellers/delete/{sellerId}")
	public void deleteseller(@PathVariable int sellerId) {
		us.deleteseller(sellerId);
		LOG.info("seller deleted successfully");
	}
}
