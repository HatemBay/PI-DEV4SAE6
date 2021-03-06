package tn.esprit.spring.subscription;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.forniture.repository.UserRepository;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

	@Autowired
	SubscriptionRepository sr;

	@Autowired
	UserRepository ur;

	// @Scheduled(fixedDelay = 10000)
	// public void scheduleStatus() {
	// System.out.println("sub expired");
	// }
	//
	@Override
	public int addSub(Subscription sub) {
		if (sub.getStartDate() == null) {
			sub.setStartDate(LocalDate.now());
			sub.setFinishDate(LocalDate.now().plusYears(1));
			sub.setState(1);
		}
		if (sub.getDuration() <= 3) {
			sub.setPrice(15);
		} else if (sub.getDuration() <= 6) {
			sub.setPrice(25);
		} else if (sub.getDuration() <= 12) {
			sub.setPrice(30);
		}
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
	public void updateSubPrice(int subId, double price) {
		Subscription oldSub = findSub(subId);
		oldSub.setPrice(price);
		addSub(oldSub);
	}

	@Override
	public void setSubPayed(int subId, int payed) {
		Subscription oldSub = findSub(subId);
		oldSub.setPayed(payed);
		addSub(oldSub);
	}

	@Override
	public void updateSub(int subId, Subscription oldSub) {
		Subscription sub = findSub(subId);
		if(oldSub != null){
			if (oldSub.getDuration() != 0) {
				sub.setDuration(oldSub.getDuration());
			}
			if (oldSub.getPrice() != 0) {
				sub.setPrice(oldSub.getPrice());
			}
			sub.setState(oldSub.getState());
			sub.setFidelity(oldSub.getFidelity());
			sub.setPayed(oldSub.getPayed());

			addSub(sub);
		}
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
	public Subscription getLastSub() {
		return sr.getSubsDesc();

	}
	
	@Override
	public void affectSubToBuyer(int subId, int buyerId) {
		// TODO Auto-generated method stub

	}

	@Override
	public long getSubNumber() {
		return sr.count();
	}
	//
	// @Override
	// public long getSubNumberByType(String type) {
	// // TODO Auto-generated method stub
	// return sr.getSubNumberByType(type.toUpperCase());
	// }

	@Override
	public void deleteSub(int subId) {
		sr.deleteById(subId);
	}

}
