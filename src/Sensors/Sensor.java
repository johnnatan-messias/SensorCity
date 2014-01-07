package Sensors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import main.Address;

@Entity
public class Sensor {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	protected int id;
	@Column(unique = true, nullable = false)
	protected String name;
	
	@ManyToOne
	protected Address address;

	public Sensor() {
	}

	public Sensor(int id, String name, Address address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
