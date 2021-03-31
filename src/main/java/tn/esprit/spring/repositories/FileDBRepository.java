package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.models.FileDB;



@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {

}
