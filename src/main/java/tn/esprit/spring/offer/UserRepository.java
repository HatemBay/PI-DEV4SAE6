package tn.esprit.spring.offer;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Offer,Integer> {

	List<Offer> findByName(String name);
	List<Offer> findByPriceGreaterThan(float price);
	List<Offer> findByPriceBetween(float from, float to);
	
	@Query("SELECT m FROM Offer m WHERE m.description LIKE %:search%  OR m.name LIKE %:search% OR m.price LIKE %:search% OR m.levelNb LIKE %:search% OR m.space LIKE %:search% ")
	List<Offer> searchOffer(@Param("search") String search);
	
	@Query("SELECT m FROM Offer m WHERE m.pool LIKE %:spool% ")
	List<Offer> searchOfferPool(@Param("spool") int spool);
	
	@Query("SELECT m FROM Offer m WHERE m.description LIKE %:search%  OR m.name LIKE %:search% OR m.price LIKE %:search% OR m.levelNb LIKE %:search% OR m.space LIKE %:search% ")
	Offer searchOffer2(@Param("search") String search);
	
	@Query("SELECT m FROM Offer m WHERE m.description LIKE %:description%  OR m.name LIKE %:name% OR m.price = :price OR m.levelNb = :levelNB OR m.space = :space OR m.chamNb = :chamNb")
	List<Offer> searchOfferWithParam(@Param("description") String description ,@Param("name") String name ,@Param("price") float price,@Param("levelNB") int levelNb ,@Param("space") int space,@Param("chamNb") int chamNb);

	@Query("SELECT m FROM OfferHistory m WHERE m.description LIKE %:description%  AND m.name LIKE %:name% AND m.price = :price AND m.levelNb = :levelNB AND m.space = :space AND m.chamNb = :chamNb")
	List<OfferHistory> searchOfferWithParamHistory(@Param("description")String description ,@Param("name") String name ,@Param("price") float price,@Param("levelNB") int levelNb ,@Param("space") int space,@Param("chamNb") int chamNb);

	@Query("SELECT m FROM Offer m WHERE m.description LIKE %:description%  AND m.name LIKE %:name% AND m.price = :price AND m.levelNb = :levelNB AND m.space = :space AND m.chamNb = :chamNb")
	List<Offer> searchOfferWithParamHistoryX(@Param("description")String description ,@Param("name") String name ,@Param("price") float price,@Param("levelNB") int levelNb ,@Param("space") int space,@Param("chamNb") int chamNb);
	







	
	
}
