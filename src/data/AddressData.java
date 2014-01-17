package data;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AddressData {

	private long id;
	private String zip;
	private String street;
	private long num;
	private String ap;
	private String city;
	private String state;
	private String country;
	private String neighbour;

	@XmlElementWrapper(name = "users")
	@XmlElement(name = "user")
	private List<UsersData> users; // 1 User just can have 1 Address. 1 Address
									// can

	@XmlElementWrapper(name = "sensors")
	@XmlElement(name = "sensor")
	private List<SensorData> sensors; // 1 Sensor just can have 1 Address.

	public AddressData() {
	}

	@XmlAttribute(name = "id")
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

	public List<UsersData> getUsers() {
		return users;
	}

	public List<SensorData> getSensors() {
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

	public void setUsers(List<UsersData> users) {
		this.users = users;
	}

	public void setSensors(List<SensorData> sensors) {
		this.sensors = sensors;
	}

}
