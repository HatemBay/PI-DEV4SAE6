
package tn.esprit.spring.subscription;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import tn.esprit.spring.forniture.entity.User;
import tn.esprit.spring.stripe.ChargeRequestH;

@Entity
@Data
public class Subscription implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6877439087555274641L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int subId;

	// private String name;

	private int duration;

	private double price;

	private LocalDate startDate;

	private LocalDate finishDate;

	private int fidelity;

	private int state;
	
	private int payed;

	@OneToOne(mappedBy = "subscription")
	@JsonIgnore
	private ChargeRequestH chargeRequest;

	// private String mail;

	// private String country;

	@OneToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	@JsonIgnore
	private User user;


}
