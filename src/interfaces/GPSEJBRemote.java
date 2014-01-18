package interfaces;

import java.util.List;

import javax.ejb.Remote;

import Sensors.GPSEntity;
import Sensors.SensorEntity;

@Remote
public interface GPSEJBRemote {
	List<GPSEntity> findGPS();
	GPSEntity findGPSById(long id);
	GPSEntity createGPS(GPSEntity gps);
	void deleteGPS(GPSEntity gps);
	GPSEntity updateGPS(GPSEntity gps);
	List<SensorEntity> findSensorWithGPS();
}
