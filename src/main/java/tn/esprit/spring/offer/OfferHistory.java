package tn.esprit.spring.offer;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import tn.esprit.spring.seller.Seller;
import tn.esprit.spring.user.User;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "offerId")
public class OfferHistory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6877439087555274641L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int offerId;

	//private String name;

	@Enumerated
	private Type type;
	
	private float price;

	private String adress;

	private String name;
	
	private String description;
	
	private int chamNb;

	private int space;

	private int levelNb;
	
    private Date startD;
    
    private Date endD;
    
    private AirC airC;
    
    private Pool pool;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
    
	@ManyToOne
	@JoinColumn(name = "seller_id", referencedColumnName = "id")
	private Seller seller;
	

	public OfferHistory() {
		
	}
	
	
	

	public OfferHistory(String name) {
		
		this.name = name;
	}

	


	public OfferHistory(String name, String description, float price, int space, int levelNb, int chamNb) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.space = space;
		this.levelNb = levelNb;
		this.chamNb = chamNb;
	}




	public int getOfferId() {
		return offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getAdress() {
		return adress;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}




    




	public int getChamNb() {
		return chamNb;
	}

	public void setChamNb(int chamNb) {
		this.chamNb = chamNb;
	}

	public int getSpace() {
		return space;
	}

	public void setSpace(int space) {
		this.space = space;
	}

	public int getLevelNb() {
		return levelNb;
	}

	public void setLevelNb(int levelNb) {
		this.levelNb = levelNb;
	}

	public Date getStartD() {
		return startD;
	}

	public void setStartD(Date startD) {
		this.startD = startD;
	}

	public Date getEndD() {
		return endD;
	}

	public void setEndD(Date endD) {
		this.endD = endD;
	}

	public AirC getAirC() {
		return airC;
	}

	public void setAirC(AirC airC) {
		this.airC = airC;
	}

	public Pool getPool() {
		return pool;
	}

	public void setPool(Pool pool) {
		this.pool = pool;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	


	@Override
	public String toString() {
		return "Offer [offerId=" + offerId + ", type=" + type + ", price=" + price + ", adress=" + adress + ", name="
				+ name + ", description=" + description + ", chamNb=" + chamNb + ", space=" + space + ", levelNb="
				+ levelNb + ", startD=" + startD + ", endD=" + endD + ", airC=" + airC + ", pool=" + pool + "]";
	}

	

	
	


	




}
