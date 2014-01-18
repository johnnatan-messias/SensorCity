package Sensors;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import kernel.Address;
import data.SensorData;

@Entity
public class Sensor implements Serializable {
	@Transient
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	protected long id;
	@Column(unique = true, nullable = false)
	protected String name;

	protected Date timestamp;

	@ManyToOne
	protected Address address;

	public Sensor() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Date getTimestamp() {
		return this.timestamp;
	}

	public SensorData toSensorData() {
		SensorData s = new SensorData();
		s.setAddress(this.getAddress().toAddressData());
		s.setId(this.getId());
		s.setName(this.getName());
		s.setTimestamp(this.getTimestamp());
		return s;
	}

}
