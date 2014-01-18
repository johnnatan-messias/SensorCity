package data;

import javax.xml.bind.annotation.XmlRootElement;

import Sensors.AtmPressure;

@XmlRootElement
public class AtmPressureData {

	private long id;
	private double value;

	public AtmPressureData() {
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

	public AtmPressure toAtmPressure() {
		AtmPressure a = new AtmPressure();
		a.setId(this.getId());
		a.setValue(this.getValue());
		return a;
	}

}
