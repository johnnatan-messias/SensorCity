package data;

import javax.xml.bind.annotation.XmlRootElement;

import Sensors.Audio;

@XmlRootElement
public class AudioData {

	private long id;
	private double value;

	public AudioData() {

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

	public Audio toAudio() {
		Audio a = new Audio();
		a.setId(this.getId());
		a.setValue(this.getValue());
		return a;
	}

}
