package data;

import javax.xml.bind.annotation.XmlRootElement;

import Sensors.GPS;

@XmlRootElement
public class GPSData {
	private long id;
	private long latitude;
	private long longitude;

	public GPSData() {
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
	
	public GPS toGPS() {
		GPS g = new GPS();
		g.setId(this.getId());
		g.setLatitude(this.getLatitude());
		g.setLongitude(this.getLongitude());
		return g;
	}

}
