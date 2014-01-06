package Sensors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import main.Address;

@Entity
public class Sensor {
	@Id
	protected int id;
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
