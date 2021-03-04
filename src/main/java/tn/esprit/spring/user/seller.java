package tn.esprit.spring.user;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class seller implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer IdSeller;
	private String UserName;
	private String Password;
	@Embedded
	@AttributeOverrides(value = { @AttributeOverride(name = "firstName", column = @Column(name = "contact_first_name")),
			@AttributeOverride(name = "lastName", column = @Column(name = "contact_last_name")),
			@AttributeOverride(name = "phone", column = @Column(name = "contact_phone")),
			@AttributeOverride(name = "mail", column = @Column(name = "contact_mail")),
			@AttributeOverride(name = "DateNaissance", column = @Column(name = "contact_DateNaissance"))

	})
	private contactInfo contactInfo;

	
	
	public seller(String userName, String password) {
		super();
		UserName = userName;
		Password = password;
	}

	public seller() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getIdSeller() {
		return IdSeller;
	}

	public void setIdSeller(Integer idSeller) {
		IdSeller = idSeller;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public contactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(contactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "seller [IdSeller=" + IdSeller + ", UserName=" + UserName + ", Password=" + Password + "]";
	}

}
