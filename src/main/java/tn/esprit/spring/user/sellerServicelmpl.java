package tn.esprit.spring.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class sellerServicelmpl implements sellerService {
	@Autowired
	sellerRepository sel;
	
	@Override
	public int addSeller(seller sell) {
		return sel.save(sell).getIdSeller();
	}

	@Override
	public seller findSel(int IdSeller) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<seller> getAllSeller() {
		return sel.findAll();
		
	}

	@Override
	public void updateSellerusename(int IdSeller, String username) {
		seller oldSel = findSel(IdSeller);
		oldSel.setUserName(username);
		addSeller(oldSel);
		
	}

	@Override
	public void updateSellerpassword(int IdSeller, String password) {
		seller oldSel = findSel(IdSeller);
		oldSel.setPassword(password);
		addSeller(oldSel);
		
		
	}

	

	@Override
	public void deleteSeller(int IdSeller) {
		sel.deleteById(IdSeller);

		
	}

	

}
