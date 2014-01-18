package Sensors;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import data.AtmPressure;

@Entity
public class AtmPressureEntity implements Serializable {
	@Transient
	private static final long serialVersionUID = 1L;
	@Id
	private long id;
	private double value;

	public AtmPressureEntity() {
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

	public AtmPressure toAtmPressureData() {
		AtmPressure a = new AtmPressure();
		a.setId(this.getId());
		a.setValue(this.getValue());
		return a;
	}
}
