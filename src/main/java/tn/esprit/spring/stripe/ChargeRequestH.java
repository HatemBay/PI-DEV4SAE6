package tn.esprit.spring.stripe;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;
import tn.esprit.spring.contract.Contract;
import tn.esprit.spring.insurance.Insurance;
import tn.esprit.spring.subscription.Subscription;

@Data
@Entity
public class ChargeRequestH {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int chargeId;

	private String description;
	private int amount;

	@Enumerated(EnumType.STRING)
	private Currency currency;
	
	private String stripeEmail;
	private String stripeToken;

	@OneToOne
	@JoinColumn(name = "contractId", referencedColumnName = "id")
	private Contract contract;

	@OneToOne
	@JoinColumn(name = "insuranceId", referencedColumnName = "id")
	private Insurance insurance;

	@OneToOne
	@JoinColumn(name = "subId", referencedColumnName = "id")
	private Subscription subscription;

}
