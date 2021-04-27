package tn.esprit.spring.rdv;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RDVrepository extends CrudRepository<RDV,Integer> {
	
}
