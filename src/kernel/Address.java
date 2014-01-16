package kernel;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import Sensors.Sensor;

@Entity
@XmlRootElement
public class Address implements Serializable {
	@Transient
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	@Column(nullable = false)
	private String zip;
	@Column(nullable = false)
	private String street;
	private int num;
	private String ap;
	@Column(nullable = false)
	private String city;
	@Column(nullable = false)
	private String state;
	@Column(nullable = false)
	private String country;
	@Column(nullable = false)
	private String neighbour;

	@OneToMany(mappedBy = "address")
	private List<Users> users; // 1 User just can have 1 Address. 1 Address can
								// be the localozation of N Users.
	@OneToMany(mappedBy = "address")
	private List<Sensor> sensors; // 1 Sensor just can have 1 Address.

	public Address() {
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
