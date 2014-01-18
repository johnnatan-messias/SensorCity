package data;

import javax.xml.bind.annotation.XmlRootElement;

import Sensors.HumidityEntity;

@XmlRootElement
public class Humidity {

	private long id;
	private double value;

	public Humidity() {
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

	public HumidityEntity toHumidity() {
		HumidityEntity h = new HumidityEntity();
		h.setId(this.getId());
		h.setValue(this.getValue());
		return h;
	}
}
