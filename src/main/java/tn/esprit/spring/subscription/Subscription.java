
package tn.esprit.spring.subscription;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Subscription implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6877439087555274641L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int subId;

	//private String name;

	@Enumerated
	private Type type;
	
	private float price;
	
    private LocalDate startDate;
     
    private LocalDate finishDate;
    
	private boolean fidelity;
	
	

	//private String mail;

	//private String country;
	
//	@OneToOne
//	@JoinColumn(name = "u", referencedColumnName = "id")
//	private User user;
	


	public Subscription(Type type, float price, boolean fidelity) {
		super();
		
		this.type = type;
		this.price = price;
		this.startDate = LocalDate.now();
		this.finishDate = LocalDate.now().plusYears(1);
		this.fidelity = fidelity;
		if(fidelity)
			this.price = price -((price * 15)/100);
	}
	
	public Subscription(Type type, float price) {
		super();
		this.type = type;
		this.price = price;
		this.startDate = LocalDate.now();
		this.finishDate = LocalDate.now().plusYears(1);
		this.fidelity = false;
	}
	
	public Subscription() {
		super();
	}
	

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getSubId() {
		return subId;
	}

	public void setSubId(int subId) {
		this.subId = subId;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean getFidelity() {
		return fidelity;
	}

	public void setFidelity(boolean fidelity) {
		this.fidelity = fidelity;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(LocalDate finishDate) {
		this.finishDate = finishDate;
	}
	
	


}
