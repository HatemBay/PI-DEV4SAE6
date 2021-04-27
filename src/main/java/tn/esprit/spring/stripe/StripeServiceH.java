package tn.esprit.spring.stripe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.model.Token;

import tn.esprit.spring.contract.Contract;
import tn.esprit.spring.contract.ContractRepository;
import tn.esprit.spring.contract.ContractService;
import tn.esprit.spring.forniture.entity.User;
import tn.esprit.spring.forniture.repository.UserRepository;
import tn.esprit.spring.insurance.Insurance;
import tn.esprit.spring.insurance.InsuranceRepository;
import tn.esprit.spring.subscription.Subscription;
import tn.esprit.spring.subscription.SubscriptionRepository;

@Service
public class StripeServiceH {

	@Autowired
	ChargeRepository cr;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ChargeRepository chargeRepository;
	
	@Autowired
	ContractRepository contractRepository;
	
	@Autowired
	ContractService contractService;
	
	@Autowired
	SubscriptionRepository subRepository;
	
	@Autowired
	InsuranceRepository insRepository;

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
	
	public void affectPaymentToContract(ChargeRequestH chargeRequest, int contractId) {
		Contract contract = contractRepository.findById(contractId).get();
		if (!ObjectUtils.isEmpty(chargeRequest) && !ObjectUtils.isEmpty(contract)) {
			chargeRequest.setContract(contract);
			chargeRepository.save(chargeRequest);
		}
	}
	
	public void affectPaymentToSub(ChargeRequestH chargeRequest, int subId) {
		Subscription subscription= subRepository.findById(subId).get();
		if (!ObjectUtils.isEmpty(chargeRequest) && !ObjectUtils.isEmpty(subscription)) {
			chargeRequest.setSubscription(subscription);
			chargeRepository.save(chargeRequest);
		}
	}
	
	public void affectPaymentToInsurance(ChargeRequestH chargeRequest, int insId) {
		Insurance insurance= insRepository.findById(insId).get();
		if (!ObjectUtils.isEmpty(chargeRequest) && !ObjectUtils.isEmpty(insurance)) {
			chargeRequest.setInsurance(insurance);
			chargeRepository.save(chargeRequest);
		}
	}

	public String createStripeCustomer(long idUser) {
		// stripe key
		Stripe.apiKey = secretKey;
		User user = userRepository.findById(idUser).get();

		Map<String, Object> params = new HashMap<>();
		params.put("description", "My First Test Customer (created for API docs)");
		params.put("email", user.getEmail());

		try {
			Customer customer = Customer.create(params);

			System.out.println("create customer id: {}");
			return customer.getId();
		} catch (StripeException e) {

			throw new RuntimeException(e);
		}
		// TODO Auto-generated method stub
		// return null;

	}

	@Transactional
	public String ChargeCustomer(int amountt, String currency, String cust) throws StripeException {
		Stripe.apiKey = secretKey;
		// cus_JBk1IR27EfeNFq
		Customer a = Customer.retrieve(cust);

		Map<String, Object> chargeParam = new HashMap<String, Object>();
		chargeParam.put("amount", amountt);
		chargeParam.put("currency", currency);
		chargeParam.put("customer", a.getId());
		Charge.create(chargeParam);

		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		return gson.toJson(a);
	}

	public String createCustumorStripeCard(String customerId, String carta, String expMonth, String expYear, String cvc)
			throws StripeException {
		Stripe.apiKey = secretKey;
		Customer customer = Customer.retrieve(customerId);

		Map<String, Object> cardParam = new HashMap<String, Object>();
		cardParam.put("number", carta);
		cardParam.put("exp_month", expMonth);
		cardParam.put("exp_year", expYear);
		cardParam.put("cvc", cvc);

		Map<String, Object> tokenParam = new HashMap<String, Object>();
		tokenParam.put("card", cardParam);

		Token token = Token.create(tokenParam);

		Map<String, Object> source = new HashMap<String, Object>();
		source.put("source", token.getId());

		customer.getSources().create(source);
		return token.getId();
	}

	public int addCharge(ChargeRequestH charge) {
		return cr.save(charge).getChargeId();
	}

	public void addChargev(ChargeRequestH charge) {
		cr.save(charge);
	}

	public List<ChargeRequestH> getAllRequests() {
		return cr.findAll();
	}
	
	public void deleteCharge(int chargeId){
		cr.deleteById(chargeId);
	}
}
