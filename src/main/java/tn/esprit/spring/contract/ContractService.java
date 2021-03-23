package tn.esprit.spring.contract;

import java.util.List;

public interface ContractService {

	public int addContract(Contract contract);

	public Contract findContract(int contractId);

	public List<Contract> getAllContracts();

	public void updateContractPrice(int contractId, float price);

	public void updateContractStartDate(int contractId, String date);

	public void updateContractDuration(int contractId, int duration);

	public void affectContractToBuyer(int contractId, int buyerId);

	public long getContractsNumberJPQL();

	public void deleteContract(int contractId);

}
