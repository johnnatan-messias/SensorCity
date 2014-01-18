package data;

import javax.xml.bind.annotation.XmlRootElement;

import Sensors.Luminosity;

@XmlRootElement
public class LuminosityData {

	private long id;
	private double value;

	public LuminosityData() {
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

	public Luminosity toLuminosity() {
		Luminosity l = new Luminosity();
		l.setId(this.getId());
		l.setValue(this.getValue());
		return l;
	}

}
