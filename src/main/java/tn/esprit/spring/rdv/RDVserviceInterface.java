package tn.esprit.spring.rdv;
import java.util.*;



public interface RDVserviceInterface {
	List<RDV> retrieveAllRDVs();
	RDV addRDV(RDV rdv);
	RDV updateRDV(RDV rdv);
	void deleteRDV(Integer id);
	RDV findById(Integer id);
	Optional<RDV> retrieveRDV(Integer id);
	

}