
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

import lombok.Data;
import tn.esprit.spring.stripe.ChargeRequest;
import tn.esprit.spring.user.User;

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

	private boolean fidelity;



	private int state;

	@OneToOne(mappedBy = "subscription")
	private ChargeRequest chargeRequest;

	// private String mail;

	// private String country;

	@OneToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

}
