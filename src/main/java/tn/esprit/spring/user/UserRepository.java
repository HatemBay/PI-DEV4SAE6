package tn.esprit.spring.user;

import java.util.Optional;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{	
	
	@Query(value= "Select count(*) FROM user u JOIN offer i WHERE i.user_id like u.id", 
			nativeQuery=  true)
	public long getUserNumberWithOffer();
	
	
	@Query(value= "Select 1 FROM user u JOIN contract c WHERE c"
			+ ""
			+ ".duration like ?1 AND c.user_id like u.id", 
			nativeQuery=  true)
	public Optional<User> findUserByContractId(int contractId);

	@Query(value= "Select avg(price) FROM offer", 
			nativeQuery=  true)
	public float getAvgPrices();
	
	@Query(value= "Select max(price) FROM offer", 
			nativeQuery=  true)
			public float getMaxPrices();
	
	@Query(value= "Select min(price) FROM offer", 
			nativeQuery=  true)
			public float getMinPrices();
	
	@Query(value= "Select avg(price) FROM offer where user_id = :id", 
			nativeQuery=  true)
	public float getAvgPricePerUser(@Param("id") int id);
	
	@Query(value= "Select max(price) FROM offer where user_id = :id", 
			nativeQuery=  true)
	public float getMaxPricePerUser(@Param("id") int id);
	
	@Query(value= "Select min(price) FROM offer where user_id = :id", 
			nativeQuery=  true)
	public float getMinPricePerUser(@Param("id") int id);
	
	@Query(value= "Select count(*) FROM Offer s WHERE s.pool like %:pool%", 
			nativeQuery=  true)
	public long getPoolNumber(@Param("pool") String pool);
	
	
	@Query(value= "Select avg(space) FROM offer", 
			nativeQuery=  true)
	public float getAvgSpace();
	
	@Query(value= "Select max(space) FROM offer", 
			nativeQuery=  true)
			public float getMaxSpace();
	
	@Query(value= "Select min(space) FROM offer", 
			nativeQuery=  true)
			public float getMinSpace();
			
	@Query(value= "Select avg(space) FROM offer where user_id = :id", 
			nativeQuery=  true)
	public float getAvgSpacePerUser(@Param("id") int id);
	
	@Query(value= "Select max(space) FROM offer where user_id = :id", 
			nativeQuery=  true)
	public float getMaxSpacePerUser(@Param("id") int id);
	
	@Query(value= "Select min(space) FROM offer where user_id = :id", 
			nativeQuery=  true)
	public float getMinSpacePerUser(@Param("id") int id);
	

			
}






