package tn.esprit.spring.insurance;

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
public class InsuranceController {

	
private static final Logger LOG = LoggerFactory.getLogger("LOG");
	
	@Autowired
	InsuranceServiceImpl is;
	
	@PostMapping("/insurances/add")
	public int newInsurance(@RequestBody Insurance ins){
		return is.addInsurance(ins);
	}
	
	@GetMapping("/insurances/get/{insId}")
	public Insurance getInsurance(@PathVariable int insId){
		return is.findInsurance(insId);
	}
	
	@GetMapping("/insurances/get-all")
	public List<Insurance> getAllInsurances(){
		return is.getAllInsurances();
	}
	
	@PostMapping("/insurances/update-price/{insId}/{price}")
	public void updateInsurancePrice(@PathVariable int insId, @PathVariable float price){
		LOG.info("Price updated");
		is.updateInsurancePrice(insId, price);
	}
	
	@PostMapping("/insurances/update-category/{insId}/{category}")
	public void updateInsuranceCategory(@PathVariable int insId, @PathVariable String category){
		LOG.info("Insurance updated");
		is.updateInsuranceCategory(insId, category);
	}
	
	@PostMapping("/insurances/update-partner/{insId}/{partner}")
	public void updateInsurancePartner(@PathVariable int insId, @PathVariable String partner){
		LOG.info("Insurance updated");
		is.updateInsurancePartner(insId, partner);
	}
	
	@DeleteMapping("/insurances/delete/{insId}")
	public void deleteInsurance(@PathVariable int insId){
		is.deleteInsurance(insId);
	}
}
