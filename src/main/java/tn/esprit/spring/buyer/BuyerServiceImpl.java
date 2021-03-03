package tn.esprit.spring.buyer;

import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service
public class BuyerServiceImpl implements BuyerService{
	
	private static final Logger LOG = LoggerFactory.getLogger("LOG");
	
	@Autowired
	BuyerRepository sr;

	@Override
	public int addBuyer(Buyer buyer) {
		return sr.save(buyer).getBuyerId();
	}

	@Override
	public Buyer findBuyer(int buyerId) {
		return sr.findById(buyerId).orElse(null);
	}
	
	@Override
	public List<Buyer> getAllBuyers() {
		return sr.findAll();
	}
	


	@Override
	public void updateBuyerName(int buyerId, String name) {
		Buyer oldBuyer = findBuyer(buyerId);
		oldBuyer.setName(name);
		addBuyer(oldBuyer);
		
	}

	@Override
	public void updateBuyerUserName(int buyerId, String username) {
		Buyer oldBuyer = findBuyer(buyerId);
		oldBuyer.setUsername(username);
		addBuyer(oldBuyer);
		
	}

	@Override
	public void updateAdress(int buyerId, String adress) {
		Buyer oldBuyer = findBuyer(buyerId);
		oldBuyer.setAdress(adress);
		addBuyer(oldBuyer);
		
	}

	@Override
	public void updatePhoneNumber(int buyerId, String phoneNumber) {
		Buyer oldSeller = findBuyer(buyerId);
		oldSeller.setPhoneNumber(phoneNumber);
		addBuyer(oldSeller);
		
	}

	@Override
	public void updatePhoneBirthDay(int buyerId, Date birthDay) {
		// TODO Auto-generated method stub
	}

	@Override
	public long getSubNumberJPQL() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public void deleteBuyer(int buyerId)   {	
		sr.deleteById(buyerId);		
	}
	

	

	

	
	
	
}
