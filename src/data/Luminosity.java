package data;

import javax.xml.bind.annotation.XmlRootElement;

import Sensors.LuminosityEntity;

@XmlRootElement
public class Luminosity {

	private long id;
	private double value;

	public Luminosity() {

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

	public LuminosityEntity toLuminosity() {
		LuminosityEntity l = new LuminosityEntity();
		l.setId(this.getId());
		l.setValue(this.getValue());
		return l;
	}

}
