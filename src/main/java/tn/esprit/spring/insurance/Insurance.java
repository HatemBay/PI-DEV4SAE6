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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
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
		
	private int payed;
	
	@Enumerated(EnumType.STRING)
	private Partner partner;
	
    private LocalDate startDate;
    
    //to remove
    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy = "insurance")
    @JsonIgnore
	private Set<ChargeRequestH> chargeRequest;
    
    @ManyToOne()
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

    
}
