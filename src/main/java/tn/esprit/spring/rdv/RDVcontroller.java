package tn.esprit.spring.rdv;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
public class RDVcontroller {
	@Autowired
	RDVServices rs;
	
	@GetMapping("/getall")
	public List<RDV> get(){
		return rs.retrieveAllRDVs();
	}
	
	@PostMapping("/addrdv")
	public RDV postrdv(@RequestBody RDV rdv) {
		return rs.addRDV(rdv);
		
	}
	@PutMapping("/updaterdv")
	public RDV updateRDV(@RequestBody RDV rdv) {
		return rs.updateRDV(rdv);
	}
	@DeleteMapping("/deleterdv/{id}")
	public void deleteRDV(@PathVariable("id") int id) {
		rs.deleteRDV(id);
	}
	
	
}
