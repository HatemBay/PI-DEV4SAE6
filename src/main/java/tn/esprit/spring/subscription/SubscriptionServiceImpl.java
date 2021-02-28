package tn.esprit.spring.subscription;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService{

	@Autowired
	SubscriptionRepository sr;

	@Override
	public int addSub(Subscription sub) {
		return sr.save(sub).getSubId();
	}

	@Override
	public Subscription findSub(int subId) {
		return sr.findById(subId).orElse(null);
	}
	
	@Override
	public void affectSubToSeller(int subId, int sellerId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void affectSubToBuyer(int subId, int buyerId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Subscription> getAllSubs() {
		return sr.findAll();
	}

	@Override
	public long getSubNumberJPQL() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteSub(int subId)   {	
		sr.deleteById(subId);		
	}

	

	
	
	
}
