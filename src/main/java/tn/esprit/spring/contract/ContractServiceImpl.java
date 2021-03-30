package tn.esprit.spring.contract;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import tn.esprit.spring.forniture.repository.UserRepository;
import tn.esprit.spring.surveillance.SurveillanceImages;
import tn.esprit.spring.surveillance.SurveillanceRepository;

@Service
public class ContractServiceImpl implements ContractService {

	@Autowired
	ContractRepository cr;

	@Autowired
	UserRepository ur;

	@Autowired
	SurveillanceRepository sr;

	@Override
	public int addContract(Contract contract) {
		if (contract.getStartDate() == null) {
			contract.setStartDate(LocalDate.now());
		}
		contract.setTotalPrice(contract.getPrice() * 0.01);

		if (contract.getSurveillance() == 1) {
			contract.setTotalPrice(contract.getPrice() + 10);
		}
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

	//activate surveillance
	@Override
	public void updateContractSurveillance(int contractId, int surveillance) {
		Contract oldContract = findContract(contractId);
		oldContract.setSurveillance(surveillance);
		//requires paying
		//oldContract.setPrice(oldContract.getPrice() + 10);
		addContract(oldContract);
	}

	@Override
	public void updateContractDuration(int contractId, int duration) {
		Contract oldContract = findContract(contractId);
		oldContract.setDuration(duration);
		addContract(oldContract);

	}

	@Override
	public void affectImageToContract(SurveillanceImages image, int contractId) {
		Contract contract = cr.findById(contractId).get();
		if (!ObjectUtils.isEmpty(contract) && !ObjectUtils.isEmpty(image)) {
			image.setContract(contract);
			sr.save(image);
		}
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
