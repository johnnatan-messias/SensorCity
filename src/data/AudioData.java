package data;

import javax.xml.bind.annotation.XmlRootElement;

import Sensors.Audio;

@XmlRootElement
public class AudioData {

	private long id;
	private long value;

	public AudioData() {

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

	public Audio toAudio() {
		Audio a = new Audio();
		a.setId(this.getId());
		a.setValue(this.getValue());
		return a;
	}

}
