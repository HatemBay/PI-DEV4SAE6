package tn.esprit.spring.forniture.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stripe.Stripe;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.model.PaymentIntent;
import com.stripe.model.Refund;
import com.stripe.model.Token;

import tn.esprit.spring.contract.Contract;
import tn.esprit.spring.contract.ContractRepository;
import tn.esprit.spring.contract.ContractService;
import tn.esprit.spring.forniture.entity.ChargeRequest;
import tn.esprit.spring.forniture.entity.Commande;
import tn.esprit.spring.forniture.entity.User;
import tn.esprit.spring.forniture.repository.CommandeRepository;
import tn.esprit.spring.forniture.repository.FurnitureRepository;
import tn.esprit.spring.forniture.repository.LigneCommandeRepository;
import tn.esprit.spring.forniture.repository.UserRepository;

@Service
public class StripeService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ContractService contractService;

	@Value("${stripe.keys.secret}")
	private String secretKey;

	@PostConstruct
	public void init() {
		Stripe.apiKey = secretKey;
	}

	public String createStripeCustomer(long idUser) {
		// stripe key
		Stripe.apiKey = "sk_test_51ITZGtLl5l7ZEYZMMkq6Qoqmm6NP52miIX5wnjDAtAXBhB7sFWHuwgyZzB28d5TpkrHzlmfoeXq9R6UAGiP3330c00HpmjXByh";
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
		Stripe.apiKey = "sk_test_51ITZGtLl5l7ZEYZMMkq6Qoqmm6NP52miIX5wnjDAtAXBhB7sFWHuwgyZzB28d5TpkrHzlmfoeXq9R6UAGiP3330c00HpmjXByh";

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
		// TODO Auto-generated method stub
		// return null;
		// stripe key
		Stripe.apiKey = "sk_test_51ITZGtLl5l7ZEYZMMkq6Qoqmm6NP52miIX5wnjDAtAXBhB7sFWHuwgyZzB28d5TpkrHzlmfoeXq9R6UAGiP3330c00HpmjXByh";

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

	public String paymentIntent(ChargeRequest chargerequest) throws StripeException {
		// TODO Auto-generated method stub
		// return null;
		// stripe key
		Stripe.apiKey = "sk_test_51ITZGtLl5l7ZEYZMMkq6Qoqmm6NP52miIX5wnjDAtAXBhB7sFWHuwgyZzB28d5TpkrHzlmfoeXq9R6UAGiP3330c00HpmjXByh";

		// `source` is obtained with Stripe.js; see
		// https://stripe.com/docs/payments/accept-a-payment-charges#web-create-token
		List<String> paymentMethodTypes = new ArrayList<String>();
		paymentMethodTypes.add("card");

		Map<String, Object> params = new HashMap<>();
		params.put("amount", chargerequest.getAmount());
		params.put("currency", chargerequest.getCurrency());
		params.put("description", chargerequest.getDescription());
		params.put("payment_method_types", paymentMethodTypes);

		PaymentIntent p = PaymentIntent.create(params);
		p.getId();
		// Charge charge = Charge.create(params);
		return p.getId();
	}

	/*
	 * this methode is to confirm that your customer intends to pay with current
	 * or provided payment method. Upon confirmation, the PaymentIntent will
	 * attempt to initiate a payment
	 */
	@Autowired
	CommandeRepository commandeRepository;
	@Autowired
	CommandeServiceImpl commandeServiceImpl;
	@Autowired
	LigneCommandeRepository ligneCommandeRepository;
	@Autowired
	IFurnitureService iFurnitureService;
	@Autowired
	FurnitureRepository furnitureRepository;

	public PaymentIntent confirm(String id) throws StripeException {
		Stripe.apiKey = "sk_test_51ITZGtLl5l7ZEYZMMkq6Qoqmm6NP52miIX5wnjDAtAXBhB7sFWHuwgyZzB28d5TpkrHzlmfoeXq9R6UAGiP3330c00HpmjXByh";
		PaymentIntent paymentIntent = PaymentIntent.retrieve(id);
		Map<String, Object> params = new HashMap<>();
		params.put("payment_method", "pm_card_visa");
		// params.put("customer", "cus_H1OvsnwEn1KX36");

		paymentIntent.confirm(params);

		return paymentIntent;
	}

	@Transactional
	public Commande Pay(long idCommande, long idc, String carta, int expMonth, int expYear, String cvc)
			throws AuthenticationException, InvalidRequestException, CardException, StripeException {

		Commande order = commandeRepository.commandeParIdclient1(idc);

		System.out.println("orde  " + order);
		System.out.println("ordetotlale  " + order.getTotal());

		// LigneCommande ligne=
		// ligneCommandeRepository.getLigneCommandByUserId1(idc);
		// System.out.println("ligne "+ligne);
		if (order.getStatus().contentEquals("IN_PROGRESS")) {
			Map<String, Object> params = new HashMap<>();
			Map<String, Object> tokenParams = new HashMap<>();
			Map<String, Object> cardParams = new HashMap<>();
			Stripe.apiKey = "sk_test_51ITZGtLl5l7ZEYZMMkq6Qoqmm6NP52miIX5wnjDAtAXBhB7sFWHuwgyZzB28d5TpkrHzlmfoeXq9R6UAGiP3330c00HpmjXByh";
			cardParams.put("number", carta);
			cardParams.put("exp_month", expMonth);
			cardParams.put("exp_year", expYear);
			cardParams.put("cvc", cvc);
			int nMontant = (int) order.getTotal() * 100;
			tokenParams.put("card", cardParams);
			Token token = Token.create(tokenParams);
			// System.out.println(token.getCard().getId());
			if (token.getId() != null) {
				params.put("amount", nMontant);
				params.put("description", "payement en ligne avec stripe");
				params.put("currency", "eur");
				params.put("source", token.getId());

				Charge.create(params);

				// params.put(
				// "charge",
				// "ch_1Ia53bLl5l7ZEYZMDrrHubCm"
				// );

				// Refund refund = Refund.create(params);
				// Refund.create(params);
			}

		}

		// String a="EN_LIGNE";
		// Commande f=commandeServiceImpl.saveCommande(idc, ligne.getId(),a );
		// System.out.println("Commande "+f);

		return null;

	}
	
//	@Transactional
//	public void PayContract(int idContract, long idc, String carta, int expMonth, int expYear, String cvc)
//			throws AuthenticationException, InvalidRequestException, CardException, StripeException {
//
//		Commande order = commandeRepository.commandeParIdclient1(idc);
//		
////		System.out.println("orde  " + order);
////		System.out.println("ordetotlale  " + order.getTotal());
//
//		// LigneCommande ligne=
//		// ligneCommandeRepository.getLigneCommandByUserId1(idc);
//		// System.out.println("ligne "+ligne);
//		if (order.getStatus().contentEquals("IN_PROGRESS")) {
//			Map<String, Object> params = new HashMap<>();
//			Map<String, Object> tokenParams = new HashMap<>();
//			Map<String, Object> cardParams = new HashMap<>();
//			Stripe.apiKey = "sk_test_51ITZGtLl5l7ZEYZMMkq6Qoqmm6NP52miIX5wnjDAtAXBhB7sFWHuwgyZzB28d5TpkrHzlmfoeXq9R6UAGiP3330c00HpmjXByh";
//			cardParams.put("number", carta);
//			cardParams.put("exp_month", expMonth);
//			cardParams.put("exp_year", expYear);
//			cardParams.put("cvc", cvc);
//			int nMontant = (int) order.getTotal() * 100;
//			tokenParams.put("card", cardParams);
//			Token token = Token.create(tokenParams);
//			// System.out.println(token.getCard().getId());
//			if (token.getId() != null) {
//				params.put("amount", nMontant);
//				params.put("description", "payement en ligne avec stripe");
//				params.put("currency", "eur");
//				params.put("source", token.getId());
//
//				Charge.create(params);
//
//				// params.put(
//				// "charge",
//				// "ch_1Ia53bLl5l7ZEYZMDrrHubCm"
//				// );
//
//				// Refund refund = Refund.create(params);
//				// Refund.create(params);
//			}
//
//		}
//
//		// String a="EN_LIGNE";
//		// Commande f=commandeServiceImpl.saveCommande(idc, ligne.getId(),a );
//		// System.out.println("Commande "+f);
//
//
//	}
}