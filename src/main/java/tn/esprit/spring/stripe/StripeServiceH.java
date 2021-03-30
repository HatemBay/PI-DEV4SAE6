package tn.esprit.spring.stripe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

@Service
public class StripeServiceH {

	@Autowired
	ChargeRepository cr;

	@Value("${stripe.secret.key}")
	private String secretKey;

	@PostConstruct
	public void init() {
		Stripe.apiKey = secretKey;
	}

	public Charge charge(ChargeRequestH chargeRequest) throws StripeException {
		Map<String, Object> chargeParams = new HashMap<>();
		chargeParams.put("amount", chargeRequest.getAmount());
		chargeParams.put("currency", chargeRequest.getCurrency());
		chargeParams.put("description", chargeRequest.getDescription());
		chargeParams.put("source", chargeRequest.getStripeToken());
		return Charge.create(chargeParams);
	}

	public int addCharge(ChargeRequestH charge) {
		return cr.save(charge).getChargeId();
	}
	
	public void addChargev(ChargeRequestH charge) {
		cr.save(charge);
	}
	
	public List<ChargeRequestH> getAllRequests(){
		return cr.findAll();
	}
}
