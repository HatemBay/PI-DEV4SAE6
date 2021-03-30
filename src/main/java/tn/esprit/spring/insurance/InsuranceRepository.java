package tn.esprit.spring.insurance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Integer>{

	@Query(value= "Select count(*) FROM insurance i WHERE s.partner like ?1", 
			nativeQuery=  true)
	public long getInsuranceNumberByPartner(String partner);
}
