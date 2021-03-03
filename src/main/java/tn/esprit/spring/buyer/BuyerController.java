package tn.esprit.spring.buyer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuyerController {
	
	private static final Logger LOG = LoggerFactory.getLogger("LOG");
	
	@Autowired
	BuyerServiceImpl ss;
	
	@PostMapping("/buyer/add")
	public int newBuyer(@RequestBody Buyer buyer){
		return ss.addBuyer(buyer);
	}
	
	@GetMapping("/buyer/get/{buyerId}")
	public Buyer getBuyer(@PathVariable int buyerId){
		return ss.findBuyer(buyerId);
	}
	
	@GetMapping("/buyer/get-all")
	public List<Buyer> getAllBuyers(){
		return ss.getAllBuyers();
	}
	
	@PostMapping("/buyer/update-username/{buyerId}/{username}")
	public void updateBuyerUserName(@PathVariable int buyerId, @PathVariable String username){
		LOG.info("UserName updated");
		ss.updateBuyerUserName(buyerId, username);
	}
	
	@PostMapping("/buyer/update-phone/{buyerId}/{phoneNumber}")
	public void updateBuyerPhone(@PathVariable int buyerId, @PathVariable String phoneNumber){
		LOG.info("Phone number updated");
		ss.updatePhoneNumber(buyerId, phoneNumber);
	}
	
	@DeleteMapping("/buyer/delete/{buyerId}")
	public void deleteBuyer(@PathVariable int buyerId){
		ss.deleteBuyer(buyerId);
	}
	
	

}
