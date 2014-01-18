package Sensors;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import data.HumidityData;

@Entity
public class Humidity implements Serializable {
	@Transient
	private static final long serialVersionUID = 1L;
	@Id
	private long id;
	private double value;

	public Humidity() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public HumidityData toHumidityData() {
		HumidityData h = new HumidityData();
		h.setId(this.getId());
		h.setValue(this.getValue());
		return h;
	}
}
