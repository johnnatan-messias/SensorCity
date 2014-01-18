package Sensors;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import data.Audio;

@Entity
public class AudioEntity implements Serializable {
	@Transient
	private static final long serialVersionUID = 1L;
	@Id
	private long id;
	private double value;

	public AudioEntity() {

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

	public Audio toAudioData() {
		Audio a = new Audio();
		a.setId(this.getId());
		a.setValue(this.getValue());
		return a;
	}

}
