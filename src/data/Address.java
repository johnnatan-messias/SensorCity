package data;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import kernel.AddressEntity;

@XmlRootElement
public class Address {

	private long id;
	private String zip;
	private String street;
	private long num;
	private String ap;
	private String city;
	private String state;
	private String country;
	private String neighbour;

	 //@XmlElementWrapper(name = "sensors")
	 //@XmlElement(name = "sensor")
	private List<Sensor> sensors = new ArrayList<Sensor>(); // 1 Sensor just can
															// have 1 Address.

	public Address() {
	}

	//@XmlAttribute(name = "id")
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

	public List<Sensor> getSensors() {
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

	public void setSensors(List<Sensor> sensors) {
		this.sensors = sensors;
	}

	public AddressEntity toAddress() {
/*		List<SensorEntity> lSensor = new ArrayList<SensorEntity>();

		for (Sensor s : this.getSensors()) {
			lSensor.add(s.toSensor());
		}*/

		AddressEntity a = new AddressEntity();
		a.setAp(this.getAp());
		a.setCity(this.getCity());
		a.setCountry(this.getCountry());
		a.setId(this.getId());
		a.setNeighbour(this.getNeighbour());
		a.setNum(this.getNum());
		//a.setSensors(lSensor);
		a.setState(this.getState());
		a.setStreet(this.getStreet());

		a.setZip(this.getZip());
		return a;
	}
}
