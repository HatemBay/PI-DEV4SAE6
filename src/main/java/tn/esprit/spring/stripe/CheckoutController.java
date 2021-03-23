package tn.esprit.spring.stripe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CheckoutController {

	@Autowired
	StripeService paymentsService;
	
	@Value("${stripe.public.key}")
    private String stripePublicKey;

    @RequestMapping("/checkout")
    public String checkout (Model model) {
        model.addAttribute("amount", 50 * 100); // in cents
        model.addAttribute("stripePublicKey", stripePublicKey);
        model.addAttribute("currency", Currency.EUR);

        return "checkout";
    }
    
}
