package tn.esprit.spring.Reclamation;
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
public class ReclamationController {
	
	private static final Logger LOG = LoggerFactory.getLogger("LOG");
	
	@Autowired
	ReclamationServiceImpl ss;
	
	@PostMapping("/Reclamation/add")
	public int newRec(@RequestBody Reclamation rec){
		return ss.addReclamation(rec);
	}
	
	@GetMapping("/Reclamation/get/{IdRec}")
	public Reclamation getReclamation(@PathVariable int IdRec){
		return ss.findRec(IdRec);
	}
	
	@GetMapping("/Reclamation/get-all")
	public List<Reclamation> getAllReclamation(){
		return ss.getAllReclamation();
	}
	
	@PostMapping("/Reclamation/update-Descrition/{IdRec}/{Description}")
	public void updateReclamationDescription(@PathVariable int IdRec, @PathVariable String Description){
		LOG.info("Reclamation Description updated");
		ss.updateReclamationDescription(IdRec, Description);
	}
	
	@PostMapping("/Reclamation/update-Type/{IdRed}/{Type}")
	public void updateReclamationType(@PathVariable int IdRec, @PathVariable String Type){
		LOG.info("Type updated");
		ss.updateReclamationType(IdRec,Type);
	}
	
	@DeleteMapping("/Recalamtion/delete/{IdRec}")
	public void deleteReclamation(@PathVariable int IdRec){
		ss.deleteReclamation(IdRec);
	}
	
}

