package tn.esprit.spring.contract;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import lombok.Data;
import tn.esprit.spring.stripe.ChargeRequest;
import tn.esprit.spring.user.User;

@Data
@Entity
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

	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy = "insurance")
	private Set<ChargeRequest> chargeRequest;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

}
