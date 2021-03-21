package tn.esprit.spring.offer;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OfferController {
	
	private static final Logger LOG = LoggerFactory.getLogger("LOG");
	
	@Autowired
	OfferServiceImpl ss;
	
	@Autowired
	UserServiceImpl si;
	
	@Autowired
	OfferHService sh;
	

	
	

	
	@PostMapping("/offer/add")
	public int newOffer(@RequestBody Offer offer){
		return ss.addOffer(offer);
	}
	
	@GetMapping("/offer/get/{offerId}")
	public Offer getSub(@PathVariable int offerId){
		return ss.findOffer(offerId);
		
	}
	
	@GetMapping("/offer/fav/{offerId}")
	public Offer DoFav(@PathVariable int offerId){
		return ss.favAff(offerId);
		
	}
	
	@GetMapping("/offer/get-name/{name}")
	public List<Offer> getName(@PathVariable String name){
		return si.findByName(name);

	}
	
	@GetMapping("/offer/get-greater-price/{price}")
	public List<Offer> getPriceGreaterThan(@PathVariable float price){
		return si.findByPriceGreaterThan(price);
	}
	
	@GetMapping("/offer/get-by-all/{search}")
	public List<Offer> SearchAll(@PathVariable String search){
		return si.searchOffer(search);
	}
	
	
	@GetMapping("/offer/get-by-all-save/{description}/{name}/{price}/{levelNb}/{space}/{chamNb}")
	public List<Offer> SearchAllSave(@PathVariable String description,@PathVariable String name,@PathVariable float price,@PathVariable int levelNb,@PathVariable int space,@PathVariable int chamNb){
		return si.searchOfferWithParam(description,name,price,levelNb,space,chamNb);
	}
	
	
	@GetMapping("/offer/get-by-all-mail/{description}/{name}/{price}/{levelNb}/{space}/{chamNb}")
	public List<Offer> SearchAll(@PathVariable String description,@PathVariable String name,@PathVariable float price,@PathVariable int levelNb,@PathVariable int space,@PathVariable int chamNb){
		return si.searchOfferWithParamAff(description,name,price,levelNb,space,chamNb);
	}
	

	
	@GetMapping("/offer/get-pool/{spool}")
	public List<Offer> SearchPool(@PathVariable String spool){
		return si.searchOfferPool(spool);
	}
	
	
	@GetMapping("/offer/scheduler")
	public void getSchedule(@PathVariable String to){
		 ss.Scheduler();
		
	}
	
	@GetMapping("/offer/scheduler2/{to}")
	public void getSchedule2(@PathVariable String to){
		 ss.Scheduler2(to);
		
	}
	
	

	
	
	
	@GetMapping("/offer/get-price-between/{from}/{to}")
	public List<Offer> SearchPriceBetween(@PathVariable float from,@PathVariable float to){
		return si.findByPriceBetween(from, to);
	}
	
	
	@GetMapping("/offer/get-all")
	public List<Offer> getAllSubs(){
		return ss.getAllOffers();
	}
	
	@GetMapping("/offer/get-fav")
	public List<OfferFav> getAllFav(){
		return ss.getAllFav();
	}
	
	@GetMapping("/offer/get-history")
	public List<OfferHistory> getAllHis(){
		return ss.getAllHis();
	}
	

	@GetMapping("/offer/mail")
	public void sendMessageWithAttachment(){
		ss.sendMessageWithAttachment();
		return ;
	}
	
	
	@PostMapping("/offer/update-type/{offerId}/{type}")
	public void updateSubType(@PathVariable int offerId, @PathVariable String type){
		LOG.info("offer updated");
		ss.updateOfferType(offerId, type);
	}
	

	
	@PostMapping("/offer/update-price/{offerId}/{price}")
	public void updateSubPrice(@PathVariable int offerId, @PathVariable float price){
		LOG.info("Price updated");
		ss.updateOfferPrice(offerId, price);
	}
	
	@PostMapping("/offer/update-name/{offerId}/{name}")
	public void updateOfferNamee(@PathVariable int offerId, @PathVariable String name){
		LOG.info("name updated");
		ss.updateOfferName(offerId, name);
	}
	
	@PostMapping("/offer/update-adress/{offerId}/{adress}")
	public void updateAdress(@PathVariable int offerId, @PathVariable String adress){
		LOG.info("adress updated");
		ss.updateOfferAdress(offerId, adress);
	}
	
	@PostMapping("/offer/update-description/{offerId}/{description}")
	public void updateDescription(@PathVariable int offerId, @PathVariable String description){
		LOG.info("description updated");
		ss.updateOfferDescription(offerId, description);
		
		
	}
	
	@PostMapping("/offer/update-air/{offerDId}/{airC}")
	public void updateOfferAir(@PathVariable int offerDId, @PathVariable String airC){
		LOG.info("air updated");
		ss.updateOfferDAirC(offerDId, airC);
	}
	
	@PostMapping("/offer/update-pool/{offerDId}/{pool}")
	public void updateSubPrice(@PathVariable int offerDId, @PathVariable String pool){
		LOG.info("pool updated");
		ss.updateOfferDPool(offerDId, pool);
	}
	
	@PostMapping("/offer/update-level/{offerDId}/{level}")
	public void updateSubPrice(@PathVariable int offerDId, @PathVariable int level){
		LOG.info("level updated");
		ss.updateOfferDLevel(offerDId, level);
	}
	@PostMapping("/offer/update-champ/{offerDId}/{chambNb}")
	public void updateSubChamb(@PathVariable int offerDId, @PathVariable int chambNb){
		LOG.info("chamb updated");
		ss.updateOfferDChamb(offerDId, chambNb);
	}
	
	@PostMapping("/offer/update-space/{offerDId}/{space}")
	public void updateSubSpace(@PathVariable int offerDId, @PathVariable int space){
		LOG.info("space updated");
		ss.updateOfferDSpace(offerDId, space);
	}
	
	@PostMapping("/offer/update-start/{offerDId}/{startD}")
	public void updateStart(@PathVariable int offerDId, @PathVariable String startD) throws ParseException{
		LOG.info("space updated");
		ss.updateOfferDstart(offerDId, startD);
	}
	
	@PostMapping("/offer/update-end/{offerDId}/{endD}")
	public void updateEnd(@PathVariable int offerDId, @PathVariable String endD) throws ParseException{
		LOG.info("space updated");
		ss.updateOfferDend(offerDId, endD);
	}
	@DeleteMapping("/offer/delete/{offerId}")
	public void deleteSub(@PathVariable int offerId){
		ss.deleteOffer(offerId);
	}
	
	@DeleteMapping("/offer/delete-fav/{offerId}")
	public void deleteFav(@PathVariable int offerId){
		ss.deleteOfferFav(offerId);
	}
	
	@DeleteMapping("/offer/delete-his/{offerId}")
	public void deleteHis(@PathVariable int offerId){
		ss.deleteOfferHis(offerId);
	}
	

	
	

}
