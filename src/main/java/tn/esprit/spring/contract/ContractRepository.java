package tn.esprit.spring.contract;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer>{

	@Query(value= "Select sum(total_price - price) FROM contract", 
			nativeQuery=  true)
	public double getContractBenefitSum();
	
	@Query(value= "select * from contract c order by c.id desc limit 1", 
			nativeQuery=  true)
	public Contract getContractsDesc();
	
	@Query(value= "select * from contract c where c.user_id like ?1", 
			nativeQuery=  true)
	public List<Contract> getContractsByUser(int id);
}
