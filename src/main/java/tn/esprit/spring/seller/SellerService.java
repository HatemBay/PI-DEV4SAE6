package tn.esprit.spring.seller;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface SellerService {
	
	public int addSeller(Seller sel);
	public Seller findSeller(int selId);
	public List<Seller> getAllSellers();
	public void updateSellerName(int selId, String name);
	public void updateSellerUserName(int selId, String username);
	public void updateAdress(int selId, String adress);
	public void updatePhoneNumber(int selId, String phoneNumber);
	public void updatePhoneBirthDay(int selId, Date birthDay);
	

	public long getSubNumberJPQL();
	public void deleteSeller(int selId);
	
	
}
