package Sensors;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import kernel.AddressEntity;
import data.Sensor;

@Entity
public class SensorEntity implements Serializable {
	@Transient
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	protected long id;
	@Column(unique = true, nullable = false)
	protected String name;

	@Temporal(TemporalType.TIMESTAMP)
	protected Date timestamp;

	@ManyToOne
	protected AddressEntity address;

	public SensorEntity() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
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

	public Sensor toSensorData() {
		Sensor s = new Sensor();
		s.setAddress(this.getAddress().toAddressData());
		s.setId(this.getId());
		s.setName(this.getName());
		s.setTimestamp(this.getTimestamp());
		return s;
	}

}
