package tn.esprit.spring.subscription;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface SubscriptionService {

	public int addSub(Subscription sub);

	public Subscription findSub(int subId);

	public List<Subscription> getAllSubs();

	// public void updateSubType(int subId, String type);

	public void updateSubPrice(int subId, double price);
	
	public void setSubPayed(int subId, int payed);
	
	public void updateSub(int subId, Subscription oldSub);

	public void updateSubStartDate(int subId, String date);

	public void affectSubToBuyer(int subId, int buyerId);
	
	public Subscription getLastSub();

	// *****************JPQL*****************
	// public long getSubNumberByType(String type);

	// **************************************

	public long getSubNumber();

	public void deleteSub(int subId);

}
