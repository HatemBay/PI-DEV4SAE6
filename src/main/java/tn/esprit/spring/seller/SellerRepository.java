package tn.esprit.spring.seller;

import java.util.List;
import java.util.Optional;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.offer.Offer;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Integer>{	
	
	@Query(value= "Select count(*) FROM seller u JOIN offer i WHERE i.seller_id like u.id", 
			nativeQuery=  true)
	public long getsellerNumberWithOffer();
	
	
	@Query(value= "Select 1 FROM seller u JOIN contract c WHERE c"
			+ ""
			+ ".duration like ?1 AND c.seller_id like u.id", 
			nativeQuery=  true)
	public Optional<Seller> findsellerByContractId(int contractId);

	@Query(value= "Select avg(price) FROM offer", 
			nativeQuery=  true)
	public float getAvgPrices();
	
	@Query(value= "Select max(price) FROM offer", 
			nativeQuery=  true)
			public float getMaxPrices();
	
	@Query(value= "Select min(price) FROM offer", 
			nativeQuery=  true)
			public float getMinPrices();
	
	@Query(value= "Select avg(price) FROM offer where seller_id = :id", 
			nativeQuery=  true)
	public float getAvgPricePerseller(@Param("id") int id);
	
	@Query(value= "Select max(price) FROM offer where seller_id = :id", 
			nativeQuery=  true)
	public float getMaxPricePerseller(@Param("id") int id);
	
	@Query(value= "Select min(price) FROM offer where seller_id = :id", 
			nativeQuery=  true)
	public float getMinPricePerseller(@Param("id") int id);
	
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
			
	@Query(value= "Select avg(space) FROM offer where seller_id = :id", 
			nativeQuery=  true)
	public float getAvgSpacePerseller(@Param("id") int id);
	
	@Query(value= "Select max(space) FROM offer where seller_id = :id", 
			nativeQuery=  true)
	public float getMaxSpacePerseller(@Param("id") int id);
	
	@Query(value= "Select min(space) FROM offer where seller_id = :id", 
			nativeQuery=  true)
	public float getMinSpacePerseller(@Param("id") int id);
	

	

			
}






