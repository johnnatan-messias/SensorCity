package data;

import javax.xml.bind.annotation.XmlRootElement;

import Sensors.GPS;

@XmlRootElement
public class GPSData {
	private long id;
	private double latitude;
	private double longitude;

	public GPSData() {
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
	
	public GPS toGPS() {
		GPS g = new GPS();
		g.setId(this.getId());
		g.setLatitude(this.getLatitude());
		g.setLongitude(this.getLongitude());
		return g;
	}

}
