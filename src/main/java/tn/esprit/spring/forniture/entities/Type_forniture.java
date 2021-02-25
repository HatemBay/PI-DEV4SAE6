package tn.esprit.spring.forniture.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Type_Forniture")
public class Type_forniture implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String type;
	
	
	public Type_forniture(){}
	
	public Type_forniture(int id, String type) {
		super();
		this.id = id;
		this.type = type;}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	
	@Override
	public String toString() {
		return "Type_forniture [id=" + id + ", type=" + type + "]";
	}
	
	
}
