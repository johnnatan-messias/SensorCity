package data;

import javax.xml.bind.annotation.XmlRootElement;

import Sensors.AtmPressureEntity;

@XmlRootElement
public class AtmPressure {

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

	public AtmPressureEntity toAtmPressure() {
		AtmPressureEntity a = new AtmPressureEntity();
		a.setId(this.getId());
		a.setValue(this.getValue());
		return a;
	}

}
