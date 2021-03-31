package tn.esprit.spring.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.models.Ad;
import tn.esprit.spring.models.Type;

public interface AdRepository extends JpaRepository<Ad, Long>{
	
List<Ad> findAdByType(Type x);
	


//@Query("SELECT * FROM ad u  WHERE u.description LIKE   CONCAT('%',:entry,'%  ")
//Ad search(   @Param("entry") String entry  );

 List<Ad> findByDescriptionContaining(String description);
 
 List<Ad> findByPriceBetween(float p1 , float p2);
 
 

 
 
 
}
