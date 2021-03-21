package tn.esprit.spring.offer;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class OfferFavServiceImpl implements OfferFavService{
	
	private static final Logger LOG = LoggerFactory.getLogger("LOG");
	


	@Autowired
	OfferFavRepository sf;


/*	
	@Transactional
	public <OfferHistory extends Offer> List<OfferHistory> addOffers(Iterable<OfferHistory> entities) {

	    List<OfferHistory> result = new ArrayList<OfferHistory>();

	    if (entities == null) {
	        return result;
	    }

	    for (OfferHistory entity : entities) {
	        result.add(sh.save(entity));
	    }

	    return result;
	}
*/


	@Override
	public int addOffer(OfferFav offer) {
		return sf.save(offer).getOfferId();
	}



		
	}






	

	

	

	
	
	

