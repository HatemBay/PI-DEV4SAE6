package tn.esprit.spring.user;

import java.util.List;


import org.springframework.data.repository.query.Param;

public interface UserService {

	public int addUser(User user);

	public User findUser(int userId);
	
	public User findUserByContractId(int contractId);

	public List<User> getAllUsers();

	public void updateUserName(int userId, String name);

	public void updateEmail(int userId, String email);

	public void affectOfferToBuyer(int subId, int sellerId);
	
	public void affectOfferHToBuyer(int subId, int sellerId);

	public void affectContractToSeller(int contractId, int sellerId);

	public void affectInsuranceToBuyer(int insId, int buyerId);

	// *****************JPQL*****************
	public long getUserNumberWithOffer();
	
	public float getAvgPrices();
	
	public float getMinPrices();
	
	public float getMaxPrices();
	
	public float getAvgPricePerUser(int id);
	
	public float getMinPricePerUser(int id);
	
	public float getMaxPricePerUser(int id);
	
	public long getPoolNumber(String pool);
	
	public float getAvgSpace();
	
	public float getMinSpace();
	
	public float getMaxSpace();
	
	public float getAvgSpacePerUser(int id);
	
	public float getMinSpacePerUser(int id);
	
	public float getMaxSpacePerUser(int id);
	
	

	// **************************************

	public long getUserNumber();

	// *****************Percentages*****************
	public double getUserPercentWithOffers();


	// *********************************************

	public void deleteUser(int userId);

}
