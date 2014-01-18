package Sensors;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import data.AtmPressureData;

@Entity
public class AtmPressure implements Serializable {
	@Transient
	private static final long serialVersionUID = 1L;
	@Id
	private long id;
	private double value;

	public AtmPressure() {
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

	public AtmPressureData toAtmPressureData() {
		AtmPressureData a = new AtmPressureData();
		a.setId(this.getId());
		a.setValue(this.getValue());
		return a;
	}
}
