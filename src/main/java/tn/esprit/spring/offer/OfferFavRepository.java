package tn.esprit.spring.offer;

import java.util.ArrayList;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface OfferFavRepository extends JpaRepository<OfferFav, Integer>{

	@Query(value= "Select * FROM offer_fav where user = :id", 
			nativeQuery=  true)
	public List<OfferFav> getOfferFavPerUser(@Param("id") int id);





}
