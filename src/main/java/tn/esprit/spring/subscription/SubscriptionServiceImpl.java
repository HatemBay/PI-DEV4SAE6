package tn.esprit.spring.subscription;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

	@Autowired
	SubscriptionRepository sr;

	@Override
	public int addSub(Subscription sub) {
		sub.setStartDate(LocalDate.now());
		sub.setFinishDate(LocalDate.now().plusYears(1));
		return sr.save(sub).getSubId();
	}

	@Override
	public Subscription findSub(int subId) {
		return sr.findById(subId).orElse(null);
	}

	@Override
	public List<Subscription> getAllSubs() {
		return sr.findAll();
	}

	@Override
	public void updateSubType(int subId, String type) {
		Subscription oldSub = findSub(subId);
		oldSub.setType(Type.valueOf(type.toUpperCase()));
		addSub(oldSub);
	}

	@Override
	public void updateSubPrice(int subId, float price) {
		Subscription oldSub = findSub(subId);
		oldSub.setPrice(price);
		addSub(oldSub);
	}

	@Override
	public void updateSubStartDate(int subId, String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
		LocalDate localDate = LocalDate.parse(date, formatter);
		Subscription oldSub = findSub(subId);
		oldSub.setStartDate(localDate);
		addSub(oldSub);

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
	public long getSubNumberJPQL() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteSub(int subId) {
		sr.deleteById(subId);
	}

}
