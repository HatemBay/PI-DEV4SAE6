package tn.esprit.spring.contract;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.user.UserRepository;


@Service
public class ContractServiceImpl implements ContractService{
	
	@Autowired
	ContractRepository cr;
	
	@Autowired
	UserRepository ur;

	@Override
	public int addContract(Contract contract) {
		if (contract.getStartDate() == null) {
			contract.setStartDate(LocalDate.now());
		}
		contract.setTotalPrice(contract.getPrice()*0.01);
		return cr.save(contract).getContractId();
	}

	@Override
	public Contract findContract(int contractId) {
		return cr.findById(contractId).orElse(null);
	}

	@Override
	public List<Contract> getAllContracts() {
		return cr.findAll();
	}

	@Override
	public void updateContractPrice(int contractId, float price) {
		Contract oldContract = findContract(contractId);
		oldContract.setPrice(price);
		addContract(oldContract);		
	}

	@Override
	public void updateContractStartDate(int contractId, String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
		LocalDate localDate = LocalDate.parse(date, formatter);
		Contract oldContract = findContract(contractId);
		oldContract.setStartDate(localDate);
		addContract(oldContract);
		
	}

	@Override
	public void updateContractDuration(int contractId, int duration) {
		Contract oldContract = findContract(contractId);
		oldContract.setDuration(duration);
		addContract(oldContract);
		
	}

	@Override
	public void affectContractToBuyer(int contractId, int buyerId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long getContractsNumberJPQL() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteContract(int contractId) {
		cr.deleteById(contractId);
		
	}

}
