package data;

import java.sql.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlInverseReference;

import Sensors.Sensor;

@XmlRootElement
public class SensorData {

	protected long id;
	protected String name;
	protected Date timestamp;

	protected AddressData address;

	public SensorData() {
	}

	@XmlAttribute(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@XmlInverseReference(mappedBy = "sensors")
	public AddressData getAddress() {
		return address;
	}

	public void setAddress(AddressData address) {
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

	public Sensor toSensor() {
		Sensor s = new Sensor();
		s.setAddress(this.getAddress().toAddress());
		s.setId(this.getId());
		s.setName(this.getName());
		s.setTimestamp(this.getTimestamp());
		return s;
	}

}
