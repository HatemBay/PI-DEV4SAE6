package tn.esprit.spring.surveillance;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import tn.esprit.spring.contract.Contract;

@Entity
@Getter
@Setter
public class SurveillanceImages implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int idImage;
	
	@Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] Content;
	
	@ManyToOne
	@JoinColumn(name = "contract_id", referencedColumnName = "id")
	private Contract contract;	
	
}
