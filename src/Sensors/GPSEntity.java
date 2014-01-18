package Sensors;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import data.GPS;

@Entity
public class GPSEntity implements Serializable {
	@Transient
	private static final long serialVersionUID = 1L;
	@Id
	private long id;
	private double latitude;
	private double longitude;

	public GPSEntity() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public GPS toGPSData() {
		GPS g = new GPS();
		g.setId(this.getId());
		g.setLatitude(this.getLatitude());
		g.setLongitude(this.getLongitude());
		return g;
	}

}
