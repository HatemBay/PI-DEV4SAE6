package tn.esprit.spring.subscription;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface SubscriptionService {
	
	public int addSub(Subscription sub);
	public Subscription findSub(int subId);
	public List<Subscription> getAllSubs();
	public void updateSubType(int subId, String type);
	public void updateSubPrice(int subId, float price);
	public void updateSubStartDate(int subId, String date);
	public void affectSubToSeller(int subId, int sellerId);
	public void affectSubToBuyer(int subId, int buyerId);
	
	public long getSubNumberJPQL();
	public void deleteSub(int subId);
	
	
}
