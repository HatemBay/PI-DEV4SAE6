package tn.esprit.spring.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface sellerRepository extends JpaRepository<seller, Integer> {

}
