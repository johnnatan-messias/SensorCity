package data;

import javax.xml.bind.annotation.XmlRootElement;

import Sensors.GPSEntity;

@XmlRootElement
public class GPS {
	private long id;
	private double latitude;
	private double longitude;

	public GPS() {

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

	public GPSEntity toGPS() {
		GPSEntity g = new GPSEntity();
		g.setId(this.getId());
		g.setLatitude(this.getLatitude());
		g.setLongitude(this.getLongitude());
		return g;
	}

}
