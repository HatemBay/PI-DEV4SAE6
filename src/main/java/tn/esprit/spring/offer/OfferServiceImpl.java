package tn.esprit.spring.offer;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


//@EnableScheduling
@Service
public class OfferServiceImpl implements OfferService{

	
	
	private static final Logger LOG = LoggerFactory.getLogger("LOG");
	
	@Autowired
	OfferRepository sr;
	
	@Autowired
	OfferFavRepository sf;
	
	@Autowired
	OfferFavService sff;
	
	@Autowired
	OfferHRepository sh;
	
	@Autowired
	UserRepository repository;
	
	@Autowired 
	private JavaMailSender JMS;

	@Override
	public int addOffer(Offer offer) {
		return sr.save(offer).getOfferId();
	}

	@Override
	public Offer findOffer(int offerId) {
		return sr.findById(offerId).orElse(null);
	}
	
	@Override
	public Offer favAff(int offerId) {
		Offer offer = sr.findById(offerId).orElse(null);
		/* OfferFav offerFav = new OfferFav();
		offerFav.setName(offer.getName());
		offerFav.setAdress(offer.getAdress());
		offerFav.setChamNb(offer.getChamNb());
		offerFav.setAirC(offer.getAirC());
		offerFav.setStartD(offer.getStartD());
		offerFav.setEndD(offer.getEndD());
		offerFav.setPool(offer.getPool());
		offerFav.setSpace(offer.getSpace());
		offerFav.setType(offer.getType());
		offerFav.setDescription(offer.getDescription());
		offerFav.setPrice(offer.getPrice());
		offerFav.setLevelNb(offer.getLevelNb());*/
		OfferFav offer2 = new OfferFav(offer.getType(),offer.getPrice(),offer.getAdress(),offer.getName(),offer.getDescription(),
				offer.getChamNb(),offer.getSpace(),offer.getLevelNb(),offer.getStartD(),offer.getEndD(),offer.getAirC(),offer.getPool());
		
		sff.addOffer(offer2);
		
		
		return offer;
	}
	

	
	@Override
	public List<Offer> getAllOffers() {
		return sr.findAll();
	}
	


	
	
	@Override
	public void updateOfferType(int offerId, String type) {
		Offer oldOffer = findOffer(offerId);
		oldOffer.setType(Type.valueOf(type.toUpperCase()));
		addOffer(oldOffer);
	}
	
	@Override
	public void updateOfferPrice(int offerId, float price) {
		Offer oldOffer = findOffer(offerId);
		oldOffer.setPrice(price);
		addOffer(oldOffer);
	}
	
	@Override
	public void updateOfferName(int offerId, String Name) {
		Offer oldOffer = findOffer(offerId);
		oldOffer.setName(Name);
		addOffer(oldOffer);
		
	}
	
	@Override
	public void updateOfferDescription(int offerId, String description) {
		Offer oldOffer = findOffer(offerId);
		oldOffer.setDescription(description);
		addOffer(oldOffer);
		
	}

	@Override
	public void updateOfferAdress(int offerId, String adress) {
		Offer oldOffer = findOffer(offerId);
		oldOffer.setName(adress);
		addOffer(oldOffer);
		
	}
	
	@Override
	public void updateOfferDAirC(int offerId, String airC) {
		Offer oldOfferD = findOffer(offerId);
		oldOfferD.setAirC(AirC.valueOf(airC.toUpperCase()));  
		addOffer(oldOfferD);
		
	}

	@Override
	public void updateOfferDPool(int offerId, String pool) {
		Offer oldOfferD = findOffer(offerId);
		oldOfferD.setPool(Pool.valueOf(pool.toUpperCase()));  
		addOffer(oldOfferD);
		
	}

	@Override
	public void updateOfferDChamb(int offerId, int ChamNb) {
		Offer oldOffer = findOffer(offerId);
		oldOffer.setChamNb(ChamNb);
		addOffer(oldOffer);
		
	}

	@Override
	public void updateOfferDLevel(int offerId, int LevelNb) {
		Offer oldOffer = findOffer(offerId);
		oldOffer.setLevelNb(LevelNb);
		addOffer(oldOffer);
		
	}

	@Override
	public void updateOfferDSpace(int offerId, int Space) {
		Offer oldOffer = findOffer(offerId);
		oldOffer.setSpace(Space);
		addOffer(oldOffer);
		
	}
	
	@Override
	public void updateOfferDstart(int offerId, String start) throws ParseException {
		Offer oldOffer = findOffer(offerId);
		Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(start);
		oldOffer.setStartD(date1);
		addOffer(oldOffer);
		
	}

	@Override
	public void updateOfferDend(int offerId, String end) throws ParseException {
		Offer oldOffer = findOffer(offerId);
		Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(end);
		oldOffer.setEndD(date1);
		addOffer(oldOffer);
		
	}
	
	
	



	@Override
	public long getSubNumberJPQL() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteOffer(int offerId)   {	
		sr.deleteById(offerId);		
	}

	@Override
	public List<OfferFav> getAllFav() {
		return sf.findAll();
	}

	@Override
	public List<OfferHistory> getAllHis() {
		return sh.findAll();
	}
	@Override
	public void deleteOfferFav(int offerId) {
		sf.deleteById(offerId);
		
	}

	@Override
	public void deleteOfferHis(int offerId) {
		sh.deleteById(offerId);
		
	}
	

    
    @Override
	public void sendMessageWithAttachment() {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom("oussamalester@gmail.com");
		msg.setTo("oussama.mleiki1@esprit.tn");
		msg.setSubject("subject test");
		msg.setText("testing Project");
		JMS.send(msg);
		
	}
    
    

    
    

    
	@Override
	//@Scheduled(cron = "0/10 * * * * * ")
	public void Scheduler() {
		List<Offer> offers = sr.findAll();
		List<OfferHistory> offerh = new ArrayList<>();
		for(Offer offer : offers){
			offerh = repository.searchOfferWithParamHistory(offer.getDescription(),offer.getName(),offer.getPrice(),offer.getLevelNb(),offer.getSpace(),offer.getChamNb());
			
		}
		if(offerh.isEmpty())
		 {
			System.out.println("no match");
		 }else
			 
		 {
			 for (OfferHistory offerz : offerh) 
			 {
				 String name = offerz.getName().toString();
				 String replace = name.replace(" ", "%20");
				 
				 String desc = offerz.getDescription().toString();
				 String replace2 = desc.replace(" ", "%20");
				  
				 
				 System.out.println("mail");
					SimpleMailMessage msg2 = new SimpleMailMessage();
					msg2.setFrom("oussamalester@gmail.com");
					msg2.setTo("oussama.mleiki1@esprit.tn");
					msg2.setSubject("subjet test");
					msg2.setText("an offer that fits the search you made before has been added here are the attributes : \r\n"
							+ "http://localhost:8081/SpringMVC/servlet/offer/get-by-all-mail/"
					+replace+"/"
					+replace2+"/"
					+ String.valueOf(offerz.getPrice()) +"/"
					+  String.valueOf(offerz.getLevelNb())+"/"
					+ offerz.getSpace() +"/"
					+ offerz.getChamNb()) ;

					
					JMS.send(msg2);
				 
			 }

			 
		 }
		
		
		
	}
	
	
	//@Scheduled(cron = "0/10 * * * * * ")
	@Override
	public void Scheduler2(String email) {
		List<Offer> offers = sr.findAll();
		List<OfferHistory> offerh = new ArrayList<>();
		for(Offer offer : offers){
			offerh = repository.searchOfferWithParamHistory(offer.getDescription(),offer.getName(),offer.getPrice(),offer.getLevelNb(),offer.getSpace(),offer.getChamNb());
			
		}
		if(offerh.isEmpty())
		 {
			System.out.println("no match");
		 }else
			 
		 {
			 for (OfferHistory offerz : offerh) 
			 {
				 String name = offerz.getName().toString();
				 String replace = name.replace(" ", "%20");
				 
				 String desc = offerz.getDescription().toString();
				 String replace2 = desc.replace(" ", "%20");
				  
				 
				 System.out.println("mail");
					SimpleMailMessage msg2 = new SimpleMailMessage();
					msg2.setFrom("oussamalester@gmail.com");
					msg2.setTo(email);
					msg2.setSubject("subjet test");
					msg2.setText("an offer that fits the search you made before has been added here are the attributes : \r\n"
							+ "http://localhost:8081/SpringMVC/servlet/offer/get-by-all-mail/"
					+replace+"/"
					+replace2+"/"
					+ String.valueOf(offerz.getPrice()) +"/"
					+  String.valueOf(offerz.getLevelNb())+"/"
					+ offerz.getSpace() +"/"
					+ offerz.getChamNb()) ;

					
					JMS.send(msg2);
				 
			 }

			 
		 }
		
		
		
	}


	

	

	

	
	
	
}
