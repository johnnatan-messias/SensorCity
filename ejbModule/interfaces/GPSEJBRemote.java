package interfaces;

import java.util.List;

import Sensors.Sensor;

public interface GPSEJBRemote extends SensorEJBRemote {
	List<Sensor> findSensorWthGPS();
}
