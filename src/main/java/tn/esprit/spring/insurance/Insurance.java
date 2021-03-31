package tn.esprit.spring.insurance;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import tn.esprit.spring.forniture.entity.Commande;
import tn.esprit.spring.forniture.entity.User;
import tn.esprit.spring.stripe.ChargeRequestH;

@Entity
@Data
public class Insurance implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int insId;
	
	private double price;
	
	@Enumerated(EnumType.STRING)
	private Partner partner;
	
    private LocalDate startDate;
    
    //to remove
    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy = "insurance")
	private Set<ChargeRequestH> chargeRequest;
    
    @ManyToOne()
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
    
    @OneToOne
	private Commande commande;
    
}