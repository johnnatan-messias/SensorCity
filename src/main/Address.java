package main;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import Sensors.Sensor;

@Entity
public class Address {
	@Id
	private int id;
	private String zip;
	private String street;
	private int num;
	private String ap;
	private String city;
	private String state;
	private String country;
	private String neighbour;
	
	@OneToMany(mappedBy = "address")
	private List<Users> users; // 1 User just can have 1 Address. 1 Address can
								// be the localozation of N Users.
	@OneToMany(mappedBy = "address")
	private List<Sensor> sensors; // 1 Sensor just can have 1 Address.

	public Address() {
	}

	public Address(int id, String zip, String street, int num, String ap,
			String city, String state, String country, String neighbour,
			List<Users> users, List<Sensor> sensors) {
		this.id = id;
		this.zip = zip;
		this.street = street;
		this.num = num;
		this.ap = ap;
		this.city = city;
		this.state = state;
		this.country = country;
		this.neighbour = neighbour;
		this.users = users;
		this.sensors = sensors;
	}

	public int getId() {
		return id;
	}

	public String getZip() {
		return zip;
	}

	public String getStreet() {
		return street;
	}

	public int getNum() {
		return num;
	}

	public String getAp() {
		return ap;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getCountry() {
		return country;
	}

	public String getNeighbour() {
		return neighbour;
	}

	public List<Users> getUsers() {
		return users;
	}

	public List<Sensor> getSensors() {
		return sensors;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setAp(String ap) {
		this.ap = ap;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setNeighbour(String neighbour) {
		this.neighbour = neighbour;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	public void setSensors(List<Sensor> sensors) {
		this.sensors = sensors;
	}

}
