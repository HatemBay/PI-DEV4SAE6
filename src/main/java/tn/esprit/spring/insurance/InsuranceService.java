package tn.esprit.spring.insurance;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.spring.subscription.Subscription;

@Service
public interface InsuranceService {

	public int addInsurance(Insurance ins);

	public Insurance findInsurance(int insId);

	public List<Insurance> getAllInsurances();

	public void updateInsurancePrice(int insId, double price);
	
	public void setInsurancePayed(int insId, int payed);
	
	public void updateInsurance(int insId, Insurance oldIns);

	public void updateInsurancePartner(int insId, String partner);

	public void affectInsuranceToBuyer(int insId, int buyerId);

	public long getInsuranceNumber();
	
	//***************************JPQL***************************
	public long getInsuranceNumberByPartner(String partner);

	//**********************************************************
	
	public double getInsurancePercentByPartner(String partner);
	
	public void deleteInsurance(int insId);

}
