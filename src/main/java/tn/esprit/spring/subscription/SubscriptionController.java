package tn.esprit.spring.subscription;

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
public class SubscriptionController {
	
	private static final Logger LOG = LoggerFactory.getLogger("LOG");
	
	@Autowired
	SubscriptionServiceImpl ss;
	
	@PostMapping("/subs/add")
	public int newSub(@RequestBody Subscription sub){
		return ss.addSub(sub);
	}
	
	@GetMapping("/subs/get/{subId}")
	public Subscription getSub(@PathVariable int subId){
		return ss.findSub(subId);
	}
	
	@GetMapping("/subs/get-all")
	public List<Subscription> getAllSubs(){
		return ss.getAllSubs();
	}
	
	@PutMapping("/subs/update-price/{subId}/{price}")
	public void updateSubPrice(@PathVariable int subId, @PathVariable double price){
		LOG.info("Price updated");
		ss.updateSubPrice(subId, price);
	}
	
	@PutMapping("/subs/update-start-date/{subId}/{date}")
	public void updateSubStartDate(@PathVariable int subId, @PathVariable String date){
		LOG.info("Start-date updated");
		ss.updateSubStartDate(subId, date);
	}
	
	@PutMapping("/subs/update/{subId}")
	public void updateSub(@PathVariable int subId,@RequestBody Subscription oldSub){
		ss.updateSub(subId, oldSub);
		LOG.info("Sub updated");
	}
	
	@DeleteMapping("/subs/delete/{subId}")
	public void deleteSub(@PathVariable int subId){
		ss.deleteSub(subId);
	}
	
	@GetMapping("/subs/getlast")
	public int getLastSub(){
		return ss.getLastSub().getSubId();
	}
	
}
