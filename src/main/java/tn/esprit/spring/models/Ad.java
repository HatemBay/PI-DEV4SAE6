package tn.esprit.spring.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(	name = "Ad")
public class Ad {
	
	@Id
	@GeneratedValue
	private long id;
	private int superficie;
	private Type type;
	private String description;
	private boolean garage;
	private boolean jardin;
	private float price;
	
	
	
	public Ad(int superficie, Type type, String description, String photo, boolean garage, boolean jardin,
			float price) {
		super();
		this.superficie = superficie;
		this.type = type;
		this.description = description;
		this.garage = garage;
		this.jardin = jardin;
		this.price = price;
	}


	public Ad(long id, int superficie, Type type, String description, String photo, boolean garage, boolean jardin,
			float price) {
		super();
		this.id = id;
		this.superficie = superficie;
		this.type = type;
		this.description = description;
		this.garage = garage;
		this.jardin = jardin;
		this.price = price;
	}


	public boolean isJardin() {
		return jardin;
	}


	public void setJardin(boolean jardin) {
		this.jardin = jardin;
	}


	public Ad(int superficie, Type type, String description, String photo, boolean garage, float price) {
		super();
		this.superficie = superficie;
		this.type = type;
		this.description = description;
		this.garage = garage;
		this.price = price;
	}


	public Ad(int id, int superficie, Type type, String description, String photo, boolean garage, float price) {
		super();
		this.id = id;
		this.superficie = superficie;
		this.type = type;
		this.description = description;
		this.garage = garage;
		this.price = price;
	}


	public int getSuperficie() {
		return superficie;
	}


	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}


	public Type getType() {
		return type;
	}


	public void setType(Type type) {
		this.type = type;
	}


	public boolean isGarage() {
		return garage;
	}


	public void setGarage(boolean garage) {
		this.garage = garage;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public Ad() {
		super();
	}


	public Ad(int id, String description, String photo) {
		super();
		this.id = id;
		this.description = description;
	
	}

	
	

	public Ad(String description, String photo) {
		super();
		this.description = description;
	
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}



	
	
	

}
