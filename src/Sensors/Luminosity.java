package Sensors;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import data.LuminosityData;

@Entity
public class Luminosity implements Serializable {
	@Transient
	private static final long serialVersionUID = 1L;
	@Id
	private long id;
	private long value;

	public Luminosity() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

	public LuminosityData toLuminosityData() {
		LuminosityData l = new LuminosityData();
		l.setId(this.getId());
		l.setValue(this.getValue());
		return l;
	}

}
