package Sensors;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import data.TemperatureData;

@Entity
public class Temperature implements Serializable {
	@Transient
	private static final long serialVersionUID = 1L;
	@Id
	private long id;
	private long value;

	public Temperature() {

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

	public  TemperatureData toTemperatureData(){
		TemperatureData t = new TemperatureData();
		t.setId(this.getId());
		t.setValue(this.getValue());
		return t;
	}
}
