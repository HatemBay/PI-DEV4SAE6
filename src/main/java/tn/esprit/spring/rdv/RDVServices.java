package tn.esprit.spring.rdv;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RDVServices implements RDVserviceInterface {

	@Autowired
	RDVrepository rr;
	@Override
	public List<RDV> retrieveAllRDVs() {
		// TODO Auto-generated method stub
		 return (List<RDV>) rr.findAll();
	}

	@Override
	public RDV addRDV(RDV rdv) {
		// TODO Auto-generated method stub
		return rr.save(rdv);
	}

	@Override
	public RDV updateRDV(RDV rdv) {
		// TODO Auto-generated method stub
		return rr.save(rdv);
	}

	@Override
	public void deleteRDV(Integer id) {
		// TODO Auto-generated method stub
		rr.deleteById(id);
		
	}

	@Override
	public RDV findById(Integer id) {
		// TODO Auto-generated method stub
		return rr.findById(id).orElse(null);
	}

	@Override
	public Optional<RDV> retrieveRDV(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
