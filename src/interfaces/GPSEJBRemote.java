package interfaces;

import java.util.List;

import javax.ejb.Remote;

import Sensors.GPS;
import Sensors.Sensor;

@Remote
public interface GPSEJBRemote {
	List<GPS> findGPS();
	GPS findGPSById(int id);
	GPS createGPS(GPS gps);
	void deleteGPS(GPS gps);
	GPS updateGPS(GPS gps);
	List<Sensor> findSensorWithGPS();
}
