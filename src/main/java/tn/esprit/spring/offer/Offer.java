package tn.esprit.spring.offer;

import java.io.Serializable;


import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
public class Offer implements Serializable {

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
	




}
