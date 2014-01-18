package data;

import javax.xml.bind.annotation.XmlRootElement;

import Sensors.Temperature;

@XmlRootElement
public class TemperatureData {

	private long id;
	private long value;

	public TemperatureData() {

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

	public Temperature toTemperature() {
		Temperature t = new Temperature();
		t.setId(this.getId());
		t.setValue(this.getValue());
		return t;
	}

}
