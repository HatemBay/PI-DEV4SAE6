package tn.esprit.spring.insurance;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface InsuranceService {
	
	public int addInsurance(Insurance ins);
	public Insurance findInsurance(int insId);
	public List<Insurance> getAllInsurances();
	public void updateInsurancePrice(int insId, float price);
	public void updateInsuranceCategory(int insId, String category);
	public void updateInsurancePartner(int insId, String partner);	
	public void affectInsuranceToSeller(int insId, int sellerId);
	public void affectInsuranceToBuyer(int insId, int buyerId);
	
	public long getInsurancesNumberJPQL();
	public void deleteInsurance(int serId);
	

}
