package tn.esprit.spring.forniture.entities;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name="Forniture")
public class Forniture implements Serializable {

	 @Id
	 @GeneratedValue (strategy = GenerationType.IDENTITY)
	  private int id ;
	  private String description;
	  private String photo;
	  private int telephone ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	
	public Forniture(){}
	
	public Forniture(int id, String description, String photo, int telephone) {
		super();
		this.id = id;
		this.description = description;
		this.photo = photo;
		this.telephone = telephone;
	}
	@Override
	public String toString() {
		return "Forniture [id=" + id + ", description=" + description + ", photo=" + photo + ", telephone=" + telephone
				+ "]";
	}
	  
	  
}
