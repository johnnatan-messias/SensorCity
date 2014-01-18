package Sensors;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import data.GPSData;

@Entity
public class GPS implements Serializable {
	@Transient
	private static final long serialVersionUID = 1L;
	@Id
	private long id;
	private long latitude;
	private long longitude;

	public GPS() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getLatitude() {
		return latitude;
	}

	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}

	public long getLongitude() {
		return longitude;
	}

	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}

	public GPSData toGPSData() {
		GPSData g = new GPSData();
		g.setId(this.getId());
		g.setLatitude(this.getLatitude());
		g.setLongitude(this.getLongitude());
		return g;
	}

}
