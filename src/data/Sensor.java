package data;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import Sensors.SensorEntity;

@XmlRootElement
public class Sensor {

	protected long id;
	protected String name;
	protected Date timestamp;

	protected Address address;

	public Sensor() {
	}

	@XmlAttribute(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	//@XmlInverseReference(mappedBy = "sensors")
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

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Date getTimestamp() {
		return this.timestamp;
	}

	public SensorEntity toSensor() {
		SensorEntity s = new SensorEntity();
		s.setAddress(this.getAddress().toAddress());
		s.setId(this.getId());
		s.setName(this.getName());
		s.setTimestamp(this.getTimestamp());
		return s;
	}

}
