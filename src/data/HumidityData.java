package data;

import javax.xml.bind.annotation.XmlRootElement;

import Sensors.Humidity;

@XmlRootElement
public class HumidityData {

	private long id;
	private double value;

	public HumidityData() {
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

	public Humidity toHumidity() {
		Humidity h = new Humidity();
		h.setId(this.getId());
		h.setValue(this.getValue());
		return h;
	}
}
