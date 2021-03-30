package tn.esprit.spring.contract;

import java.util.List;

import tn.esprit.spring.surveillance.SurveillanceImages;

public interface ContractService {

	public int addContract(Contract contract);

	public Contract findContract(int contractId);

	public List<Contract> getAllContracts();

	public void updateContractPrice(int contractId, float price);

	public void updateContractStartDate(int contractId, String date);
	
	public void updateContractSurveillance(int contractId, int surveillance);

	public void updateContractDuration(int contractId, int duration);

	public void affectImageToContract(SurveillanceImages image, int contractId);

	public long getContractsNumberJPQL();

	public void deleteContract(int contractId);

}
