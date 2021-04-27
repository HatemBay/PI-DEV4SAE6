package tn.esprit.spring.contract;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import tn.esprit.spring.forniture.entity.User;
import tn.esprit.spring.surveillance.SurveillanceImages;

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "contractId")
public class Contract implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int contractId;

	private int duration;

	private LocalDate startDate;

	private double price;
	
	private double totalPrice;
	
	private int surveillance;
	
	private int payed;

//	@OneToMany(fetch = FetchType.EAGER, mappedBy = "contract", cascade = CascadeType.ALL)
//	private Set<ChargeRequestH> chargeRequest;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	@JsonIgnore
	private User user;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "contract", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<SurveillanceImages> surveillanceImages;

}
