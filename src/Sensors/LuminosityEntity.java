package Sensors;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import data.Luminosity;

@Entity
public class LuminosityEntity implements Serializable {
	@Transient
	private static final long serialVersionUID = 1L;
	@Id
	private long id;
	private double value;

	public LuminosityEntity() {
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

	public Luminosity toLuminosityData() {
		Luminosity l = new Luminosity();
		l.setId(this.getId());
		l.setValue(this.getValue());
		return l;
	}

}
