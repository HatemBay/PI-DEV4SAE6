package tn.esprit.spring.subscription;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface SubscriptionService {
	
	public int addSub(Subscription sub);
	public Subscription findSub(int subId);
	public void affectSubToSeller(int subId, int sellerId);
	public void affectSubToBuyer(int subId, int buyerId);
	public List<Subscription> getAllSubs();
	public long getSubNumberJPQL();
	public void deleteSub(int subId);
	
	
}
