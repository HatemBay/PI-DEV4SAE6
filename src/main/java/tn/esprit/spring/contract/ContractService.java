package tn.esprit.spring.contract;

import java.util.List;

import tn.esprit.spring.surveillance.SurveillanceImages;

public interface ContractService {

	public int addContract(Contract contract);

	public Contract findContract(int contractId);

	public List<Contract> getAllContracts();

	public void updateContractPrice(int contractId, float price);
	
	public void setContractPayed(int contractId, int payed);

	public void updateContractStartDate(int contractId, String date);
	
	public void updateContractSurveillance(int contractId, int surveillance);

	public void updateContractDuration(int contractId, int duration);
	
	public void updateContract(int contractId, Contract oldContract);

	public void affectImageToContract(SurveillanceImages image, int contractId);
	
	public Contract getLastContract();
	
	public List<Contract> getContractsByUser(int id);

	public long getContractsNumberJPQL();
	
	public double getContractBenefitSum();

	public void deleteContract(int contractId);

}
