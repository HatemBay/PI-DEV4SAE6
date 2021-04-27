package tn.esprit.spring.stripe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.contract.Contract;
import tn.esprit.spring.contract.ContractRepository;
import tn.esprit.spring.contract.ContractService;
import tn.esprit.spring.insurance.Insurance;
import tn.esprit.spring.insurance.InsuranceRepository;
import tn.esprit.spring.insurance.InsuranceService;
import tn.esprit.spring.subscription.Subscription;
import tn.esprit.spring.subscription.SubscriptionRepository;
import tn.esprit.spring.subscription.SubscriptionService;

@RestController
public class ChargeController {

	@Autowired
    private StripeServiceH paymentsService;
	
	@Autowired
    private ContractService contractService;
	
	@Autowired
	ContractRepository contractRepository;

	@Autowired
    private SubscriptionService subService;
	
	@Autowired
	SubscriptionRepository subRepository;
	
	@Autowired
    private InsuranceService insService;
	
	@Autowired
	InsuranceRepository insRepository;

	@Value("${stripe.secret.key}")
	private String secretKey;

	@Value("${stripe.public.key}")
    private String stripePublicKey;
	
//	@PostConstruct
//	public void init() {
//		Stripe.apiKey = secretKey;
//	}
	
//    @PostMapping("/charge")
//    public String charge(ChargeRequestH chargeRequest, Model model)
//      throws StripeException {
//        chargeRequest.setDescription("Example charge");
//        chargeRequest.setCurrency(Currency.EUR);
//        Charge charge = paymentsService.charge(chargeRequest);
//        model.addAttribute("id", charge.getId());
//        model.addAttribute("status", charge.getStatus());
//        model.addAttribute("chargeId", charge.getId());
//        model.addAttribute("balance_transaction", charge.getBalanceTransaction());
//        paymentsService.addChargev(chargeRequest);
//        return "result";
//    }
    
    @PostMapping("/charge/contract/{contractId}")
	public int payContract(@PathVariable int contractId, @RequestBody ChargeRequestH chargeRequest) {
    	//ChargeRequestH chargeRequest = new ChargeRequestH();
    	Contract c = contractRepository.findById(contractId).get();
    	chargeRequest.setContract(c);
		// chargeRequest.setDescription("Example charge");
		chargeRequest.setCurrency(Currency.TND);
		chargeRequest.setAmount((int) c.getTotalPrice());
//		User u = contractService.findContract(contractId).getUser();
//		System.out.println(u);
		//chargeRequest.setStripeEmail(stripeEmail);
		chargeRequest.setStripeToken(stripePublicKey);
		//int chargeId = paymentsService.addCharge(chargeRequest);
		
		System.out.println(chargeRequest);
		paymentsService.addChargev(chargeRequest);
		contractService.setContractPayed(contractId, 1);
		paymentsService.affectPaymentToContract(chargeRequest, contractId);
		
		return 1;
	}
    
    @PostMapping("/charge/sub/{subId}")
	public int paySub(@PathVariable int subId, @RequestBody ChargeRequestH chargeRequest) {
    	//ChargeRequestH chargeRequest = new ChargeRequestH();
    	Subscription s = subRepository.findById(subId).get();
    	chargeRequest.setSubscription(s);
		// chargeRequest.setDescription("Example charge");
		chargeRequest.setCurrency(Currency.TND);
		chargeRequest.setAmount((int) s.getPrice());
//		User u = contractService.findContract(contractId).getUser();
//		System.out.println(u);
//		chargeRequest.setStripeEmail(stripeEmail);
		chargeRequest.setStripeToken(stripePublicKey);
		//int chargeId = paymentsService.addCharge(chargeRequest);
		
		System.out.println(chargeRequest);
		paymentsService.addChargev(chargeRequest);
		paymentsService.affectPaymentToSub(chargeRequest, subId);
		subService.setSubPayed(subId, 1);
		return 1;
	}
    
    @PostMapping("/charge/insurance/{insId}/{stripeEmail}")
	public int payInsurance(@PathVariable int insId, @PathVariable String stripeEmail) {
    	ChargeRequestH chargeRequest = new ChargeRequestH();
    	Insurance i = insRepository.findById(insId).get();
    	chargeRequest.setInsurance(i);
		// chargeRequest.setDescription("Example charge");
		chargeRequest.setCurrency(Currency.TND);
		chargeRequest.setAmount((int) i.getPrice());
//		User u = contractService.findContract(contractId).getUser();
//		System.out.println(u);
		chargeRequest.setStripeEmail(stripeEmail);
		chargeRequest.setStripeToken(stripePublicKey);
		//int chargeId = paymentsService.addCharge(chargeRequest);
		
		System.out.println(chargeRequest);
		paymentsService.addChargev(chargeRequest);
		paymentsService.affectPaymentToInsurance(chargeRequest, insId);
		insService.setInsurancePayed(insId, 1);
		return 1;
	}
    
    @DeleteMapping("/charge/delete/{chargeId}")
   	public void deleteCharge(@PathVariable int chargeId){
   		paymentsService.deleteCharge(chargeId);
   	}

//    @ExceptionHandler(StripeException.class)
//    public String handleError(Model model, StripeException ex) {
//        model.addAttribute("error", ex.getMessage());
//        return "result";
//    }
}
