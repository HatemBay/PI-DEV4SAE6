package tn.esprit.spring.insurance;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.forniture.repository.UserRepository;


@Service
public class InsuranceServiceImpl implements InsuranceService {

	@Autowired
	InsuranceRepository ir;

	@Autowired
	UserRepository ur;

	@Override
	public int addInsurance(Insurance ins) {
		if (ins.getStartDate() == null) {
			ins.setStartDate(LocalDate.now());
		}

		return ir.save(ins).getInsId();
	}

	@Override
	public Insurance findInsurance(int insId) {
		return ir.findById(insId).orElse(null);
	}

	@Override
	public List<Insurance> getAllInsurances() {
		return ir.findAll();
	}

	@Override
	public void updateInsurancePrice(int insId, double price) {
		Insurance oldIns = findInsurance(insId);
		oldIns.setPrice(price);
		addInsurance(oldIns);
	}

	@Override
	public void updateInsurancePartner(int insId, String partner) {
		Insurance oldIns = findInsurance(insId);
		oldIns.setPartner(Partner.valueOf(partner.toUpperCase()));
		addInsurance(oldIns);
	}

	@Override
	public void affectInsuranceToBuyer(int insId, int buyerId) {
		// TODO Auto-generated method stub

	}

	@Override
	public long getInsuranceNumber() {
		return ir.count();
	}
	
	//***************************JPQL***************************
	@Override
	public long getInsuranceNumberByPartner(String partner) {
		return ir.getInsuranceNumberByPartner(partner.toUpperCase());
	}
	//**********************************************************
	
	@Override
	public double getInsurancePercentByPartner(String partner) {
		double result = (double) getInsuranceNumberByPartner(partner.toUpperCase())/(double) getInsuranceNumber();
		return result;
	}
	@Override
	public void deleteInsurance(int serId) {
		ir.deleteById(serId);

	}

}
