package tn.esprit.spring.seller;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Seller implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6877439087555274641L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int selId;

	private String name;
	private String username;
    private String adress;
    private String phoneNumber;
    private Date birthDate;
	//private String name;

	
   
    public int getSelId() {
		return selId;
	}
	public void setSelId(int selId) {
		this.selId = selId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Seller [selId=" + selId + ", username=" + username + ", adress=" + adress + ", phoneNumber="
				+ phoneNumber + ", birthDate=" + birthDate + ", name=" + name + "]";
	}





}
