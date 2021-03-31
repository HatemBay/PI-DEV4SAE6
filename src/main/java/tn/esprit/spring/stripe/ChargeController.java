package tn.esprit.spring.stripe;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

import tn.esprit.spring.contract.ContractService;
import tn.esprit.spring.forniture.entity.User;

@Controller
public class ChargeController {

	@Autowired
    private StripeServiceH paymentsService;
	
	@Autowired
    private ContractService contractService;

	@Value("${stripe.secret.key}")
	private String secretKey;

	@PostConstruct
	public void init() {
		Stripe.apiKey = secretKey;
	}
	
    @PostMapping("/charge")
    public String charge(ChargeRequestH chargeRequest, Model model)
      throws StripeException {
        chargeRequest.setDescription("Example charge");
        chargeRequest.setCurrency(Currency.EUR);
        Charge charge = paymentsService.charge(chargeRequest);
        model.addAttribute("id", charge.getId());
        model.addAttribute("status", charge.getStatus());
        model.addAttribute("chargeId", charge.getId());
        model.addAttribute("balance_transaction", charge.getBalanceTransaction());
        paymentsService.addChargev(chargeRequest);
        return "result";
    }
    
    @PostMapping("/charge/contract/{contractId}")
	public void newPayment(@PathVariable int contractId, @RequestBody ChargeRequestH chargeRequest) {
		// chargeRequest.setDescription("Example charge");
		chargeRequest.setCurrency(Currency.TND);
		contractService.setContractPayed(contractId);
		User u = contractService.findContract(contractId).getUser();
		System.out.println(u);
		chargeRequest.setStripeEmail(u.getEmail());
		chargeRequest.setStripeToken(secretKey);
		int chargeId = paymentsService.addCharge(chargeRequest);
		paymentsService.affectPaymentToContract(chargeId, contractId);
	}

    @ExceptionHandler(StripeException.class)
    public String handleError(Model model, StripeException ex) {
        model.addAttribute("error", ex.getMessage());
        return "result";
    }
}
