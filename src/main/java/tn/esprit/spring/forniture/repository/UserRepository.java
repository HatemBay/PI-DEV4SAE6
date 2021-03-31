package tn.esprit.spring.forniture.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.forniture.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

	@Query(value= "Select count(*) FROM user u JOIN insurance i WHERE i.user_id like u.id", 
			nativeQuery=  true)
	public long getUserNumberWithInsurances();
	
	@Query(value= "Select count(*) FROM user u JOIN subscription s WHERE s.user_id like u.id", 
			nativeQuery=  true)
	public long getSubbedUserNumber();
	
	@Query(value= "Select count(*) FROM user u JOIN contract c WHERE c.user_id like u.id", 
			nativeQuery=  true)
	public long getUserNumberWithContracts();
	
	@Query(value= "Select * FROM user u JOIN contract c ON c.user_id = u.id WHERE c.id like ?1 ", 
			nativeQuery=  true)
	public Optional<User> findUserByContractId(int contractId);


}

