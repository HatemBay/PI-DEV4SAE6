package tn.esprit.spring.user;
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
public class sellerController {
	
	private static final Logger LOG = LoggerFactory.getLogger("LOG");
	
	@Autowired
	sellerServicelmpl ss;
	
	@PostMapping("/seller/add")
	public int newSub(@RequestBody seller sel){
		return ss.addSeller(sel);
	}
	
	@GetMapping("/seller/get/{IdSeller}")
	public seller getseller(@PathVariable int IdSeller){
		return ss.findSel(IdSeller);
	}
	
	@GetMapping("/seller/get-all")
	public List<seller> getAllSeller(){
		return ss.getAllSeller();
	}
	
	@PostMapping("/seller/update-username/{IdSeller}/{username}")
	public void updateSellerusername(@PathVariable int IdSeller, @PathVariable String username){
		LOG.info("Seller username updated");
		ss.updateSellerusename(IdSeller, username);
	}
	
	@PostMapping("/seller/update-password/{IdSeller}/{password}")
	public void updateSellerpassword(@PathVariable int IdSeller, @PathVariable String password){
		LOG.info("password updated");
		ss.updateSellerpassword(IdSeller, password);
	}
	
	@DeleteMapping("/seller/delete/{IdSeller}")
	public void deleteSeller(@PathVariable int IdSeller){
		ss.deleteSeller(IdSeller);
	}
	
}

