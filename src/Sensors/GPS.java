package Sensors;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GPS {
	@Id
	private int id;
	private long latitude;
	private long longitude;

	public GPS() {
	}

	public GPS(int id, long latitude, long longitude) {
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	
	
}
