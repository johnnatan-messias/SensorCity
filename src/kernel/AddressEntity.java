package kernel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import Sensors.SensorEntity;
import data.Address;
import data.Sensor;
import data.Users;

@Entity
public class AddressEntity implements Serializable {
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id;
	@Column(nullable = false)
	private String zip;
	@Column(nullable = false)
	private String street;
	private long num;
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
	private List<UsersEntity> users; // 1 User just can have 1 Address. 1 Address can

	// be the localization of N Users.
	@OneToMany(mappedBy = "address")
	private List<SensorEntity> sensors; // 1 Sensor just can have 1 Address.

	public AddressEntity() {
	}

	public long getId() {
		return id;
	}

	public String getZip() {
		return zip;
	}

	public String getStreet() {
		return street;
	}

	public long getNum() {
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

	public List<UsersEntity> getUsers() {
		return users;
	}

	public List<SensorEntity> getSensors() {
		return sensors;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setNum(long num) {
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

	public void setUsers(List<UsersEntity> users) {
		this.users = users;
	}

	public void setSensors(List<SensorEntity> sensors) {
		this.sensors = sensors;
	}

	public Address toAddressData() {
		List<Sensor> lSensor = new ArrayList<Sensor>();
		List<Users> lUsers = new ArrayList<Users>();

		for (SensorEntity s : this.getSensors()) {
			lSensor.add(s.toSensorData());
		}

		for (UsersEntity u : this.getUsers()) {
			lUsers.add(u.toUserData());
		}
		
		Address a = new Address();
		a.setAp(this.getAp());
		a.setCity(a.getCity());
		a.setCountry(this.getCountry());
		a.setId(this.getId());
		a.setNeighbour(this.getNeighbour());
		a.setNum(a.getNum());
		a.setSensors(lSensor);
		a.setState(this.getState());
		a.setStreet(this.getStreet());
		a.setUsers(lUsers);
		a.setZip(this.getZip());
		return a;
	}

}
