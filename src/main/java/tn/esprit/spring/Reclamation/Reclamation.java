package tn.esprit.spring.Reclamation;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
@Entity
public class Reclamation implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7037511792330284649L;
	
	@Column(name = "id")

	private int IdRec;
	private String Description;
	private Date DateRec;
	@Enumerated
	private Type type;
	public Reclamation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reclamation(String description, Date dateRec, Type type) {
		super();
		Description = description;
		DateRec = dateRec;
		this.type = type;
	}
	public int getIdRec() {
		return IdRec;
	}
	public void setIdRec(int idRec) {
		IdRec = idRec;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Date getDateRec() {
		return DateRec;
	}
	public void setDateRec(Date dateRec) {
		DateRec = dateRec;
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

	
	

}
