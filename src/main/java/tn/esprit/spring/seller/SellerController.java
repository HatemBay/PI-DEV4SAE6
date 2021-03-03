package tn.esprit.spring.seller;

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
public class SellerController {
	
	private static final Logger LOG = LoggerFactory.getLogger("LOG");
	
	@Autowired
	SellerServiceImpl ss;
	
	@PostMapping("/seller/add")
	public int newSeller(@RequestBody Seller sub){
		return ss.addSeller(sub);
	}
	
	@GetMapping("/seller/get/{selId}")
	public Seller getSeller(@PathVariable int selId){
		return ss.findSeller(selId);
	}
	
	@GetMapping("/seller/get-all")
	public List<Seller> getAllSellers(){
		return ss.getAllSellers();
	}
	
	@PostMapping("/seller/update-username/{selId}/{username}")
	public void updateSellerUserName(@PathVariable int selId, @PathVariable String username){
		LOG.info("UserName updated");
		ss.updateSellerUserName(selId, username);
	}
	
	@PostMapping("/seller/update-phone/{selId}/{phoneNumber}")
	public void updateSellerPhone(@PathVariable int selId, @PathVariable String phoneNumber){
		LOG.info("Phone number updated");
		ss.updatePhoneNumber(selId, phoneNumber);
	}
	
	@DeleteMapping("/seller/delete/{selId}")
	public void deleteSeller(@PathVariable int selId){
		ss.deleteSeller(selId);
	}
	
	

}
