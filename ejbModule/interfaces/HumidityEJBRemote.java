package interfaces;

import java.util.List;

import Sensors.Sensor;

public interface HumidityEJBRemote extends SensorEJBRemote {
	List<Sensor> findSensorWthHumidity();
}
