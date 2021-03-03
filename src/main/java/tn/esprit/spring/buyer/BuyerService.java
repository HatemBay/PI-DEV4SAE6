package tn.esprit.spring.buyer;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface BuyerService {
	
	public int addBuyer(Buyer buyer);
	public Buyer findBuyer(int buyerId);
	public List<Buyer> getAllBuyers();
	public void updateBuyerName(int buyerId, String name);
	public void updateBuyerUserName(int buyerId, String username);
	public void updateAdress(int buyerId, String adress);
	public void updatePhoneNumber(int buyerId, String phoneNumber);
	public void updatePhoneBirthDay(int buyerId, Date birthDay);
	

	public long getSubNumberJPQL();
	public void deleteBuyer(int buyerId);
	
	
}
