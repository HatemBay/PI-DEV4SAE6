package tn.esprit.spring.seller;

import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service
public class SellerServiceImpl implements SellerService{
	
	private static final Logger LOG = LoggerFactory.getLogger("LOG");
	
	@Autowired
	SellerRepository sr;

	@Override
	public int addSeller(Seller sub) {
		return sr.save(sub).getSelId();
	}

	@Override
	public Seller findSeller(int selId) {
		return sr.findById(selId).orElse(null);
	}
	
	@Override
	public List<Seller> getAllSellers() {
		return sr.findAll();
	}
	


	@Override
	public void updateSellerName(int selId, String name) {
		Seller oldSeller = findSeller(selId);
		oldSeller.setName(name);
		addSeller(oldSeller);
		
	}

	@Override
	public void updateSellerUserName(int selId, String username) {
		Seller oldSeller = findSeller(selId);
		oldSeller.setUsername(username);
		addSeller(oldSeller);
		
	}

	@Override
	public void updateAdress(int selId, String adress) {
		Seller oldSeller = findSeller(selId);
		oldSeller.setAdress(adress);
		addSeller(oldSeller);
		
	}

	@Override
	public void updatePhoneNumber(int selId, String phoneNumber) {
		Seller oldSeller = findSeller(selId);
		oldSeller.setPhoneNumber(phoneNumber);
		addSeller(oldSeller);
		
	}

	@Override
	public void updatePhoneBirthDay(int selId, Date birthDay) {
		// TODO Auto-generated method stub
	}

	@Override
	public long getSubNumberJPQL() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public void deleteSeller(int selId)   {	
		sr.deleteById(selId);		
	}
	

	

	

	
	
	
}
