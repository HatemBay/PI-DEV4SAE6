package tn.esprit.spring.insurance;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsuranceServiceImpl implements InsuranceService{
	
	@Autowired
	InsuranceRepository ir;

	@Override
	public int addInsurance(Insurance ins) {
		ins.setStartDate(LocalDate.now());
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
	public void updateInsurancePrice(int insId, float price) {
		Insurance oldIns = findInsurance(insId);
		oldIns.setPrice(price);
		addInsurance(oldIns);		
	}

	@Override
	public void updateInsuranceCategory(int insId, String category) {
		Insurance oldIns = findInsurance(insId);
		oldIns.setCategory(Category.valueOf(category.toUpperCase()));
		addInsurance(oldIns);		
	}

	@Override
	public void updateInsurancePartner(int insId, String partner) {
		Insurance oldIns = findInsurance(insId);
		oldIns.setPartner(Partner.valueOf(partner.toUpperCase()));
		addInsurance(oldIns);		
	}
	
	@Override
	public void affectInsuranceToSeller(int insId, int sellerId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void affectInsuranceToBuyer(int insId, int buyerId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long getInsurancesNumberJPQL() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteInsurance(int serId) {
		ir.deleteById(serId);
		
	}

	
}
