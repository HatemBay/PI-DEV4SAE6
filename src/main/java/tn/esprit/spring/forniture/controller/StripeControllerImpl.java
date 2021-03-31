package tn.esprit.spring.forniture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.exception.StripeException;

import tn.esprit.spring.forniture.service.StripeService;

@RestController
public class StripeControllerImpl {

	@Autowired
	StripeService stripeSer;

	// http://localhost:8081/SpringMVC/servlet/add-Customer/1
	// Ajouter costumer :
	// http://localhost:8081/SpringMVC/servlet/add-Customer/{idUser}

	@PostMapping("/add-Customer/{idUser}")
	@ResponseBody
	public String ajouetrCustomer(@PathVariable("idUser") Long idUser) {

		stripeSer.createStripeCustomer(idUser);

		return "Customer added";
	}

	// String customerId, String carta, String expMonth, String expYear, String
	// cvc
	// http://localhost:8081/SpringMVC/servlet/add-Card/cus_JBk1IR27EfeNFq/4242424242424242/11/2023/123
	// Ajouter card :
	// http://localhost:8081/SpringMVC/servlet/add-Card/{customerId}/{carta}/{expMonth}/{expYear}/{cvc}

	@PostMapping("/add-Card/{customerId}/{carta}/{expMonth}/{expYear}/{cvc}")
	@ResponseBody
	public String ajouetrCustomerCard(@PathVariable("customerId") String customerId,
			@PathVariable("carta") String carta, @PathVariable("expMonth") String expMonth,
			@PathVariable("expYear") String expYear, @PathVariable("cvc") String cvc) throws StripeException {

		stripeSer.createCustumorStripeCard(String.valueOf(customerId), String.valueOf(carta), String.valueOf(expMonth),
				String.valueOf(expYear), String.valueOf(cvc));

		return "card added";
	}

	// // cus_JBk1IR27EfeNFq
	// charge card :
	// http://localhost:8081/SpringMVC/servlet/charge-Card/{amountt}/{currency}/{cust}

	@PostMapping("/charge-Card/{amountt}/{currency}/{cust}")
	public String ChargeCard(@PathVariable("amountt") int amountt, @PathVariable("currency") String currency,
			@PathVariable("cust") String cust

	) throws StripeException {

		stripeSer.ChargeCustomer(amountt, currency, cust);

		return "card charged";
	}

	//http://localhost:8000/pay/1/1/4242424242424242/11/2024/321
	@PostMapping("pay/{idCommand}/{idc}/{carta}/{expMonth}/{expYear}/{cvc}")
	public void Pay(@PathVariable("idCommand") int idCommande, @PathVariable("idc") long idc,
			@PathVariable("carta") String carta, @PathVariable("expMonth") int expMonth,
			@PathVariable("expYear") int expYear, @PathVariable("cvc") String cvc)
			throws AuthenticationException, InvalidRequestException, CardException, StripeException {
		stripeSer.Pay(idCommande, idc, carta, expMonth, expYear, cvc);
	}
	
	@PostMapping("pay/contract/{idContract}/{idc}")
	public void PayContract(@PathVariable("idContract") int idContract, @PathVariable("idc") long idc,
			@PathVariable("carta") String carta, @PathVariable("expMonth") int expMonth,
			@PathVariable("expYear") int expYear, @PathVariable("cvc") String cvc)
			throws AuthenticationException, InvalidRequestException, CardException, StripeException {
		stripeSer.PayContract(idContract, idc, carta, expMonth, expYear, cvc);
	}

}
