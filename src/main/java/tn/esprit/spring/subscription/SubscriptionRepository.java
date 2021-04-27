package tn.esprit.spring.subscription;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Integer>, CrudRepository<Subscription, Integer>{
	
//	@Query(value= "Select count(*) FROM users u inner JOIN subscription s on s.userId= u.userId WHERE s.type = ?1", 
//			nativeQuery=  true)
//	public long getSubNumberByType(String type);
	
	
	@Query(value= "Select count(*) FROM subscription s WHERE s.type like ?1", 
			nativeQuery=  true)
	public long getSubNumberByType(String type);
	
	@Query(value= "select * from subscription s order by s.id desc limit 1", 
			nativeQuery=  true)
	public Subscription getSubsDesc();
	
}
