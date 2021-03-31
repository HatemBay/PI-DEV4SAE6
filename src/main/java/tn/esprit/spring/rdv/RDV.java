package tn.esprit.spring.rdv;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
public class RDV {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id_rdv")
	private int id_rdv;
	private int id_client;
	private int id_imm;
	@Enumerated(EnumType.STRING)
	private Status status;
	
	
	@Column(name="daterdv")
	@Temporal(TemporalType.DATE)
	private Date date_rdv;

	public int getId_rdv() {
		return id_rdv;
	}

	public void setId_rdv(int id_rdv) {
		this.id_rdv = id_rdv;
	}

	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	public int getId_imm() {
		return id_imm;
	}

	public void setId_imm(int id_imm) {
		this.id_imm = id_imm;
	}

	public Date getDate_rdv() {
		return date_rdv;
	}

	public void setDate_rdv(Date date_rdv) {
		this.date_rdv = date_rdv;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	
}
