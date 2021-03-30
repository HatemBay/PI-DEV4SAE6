package tn.esprit.spring.forniture.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.forniture.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

	 

}

