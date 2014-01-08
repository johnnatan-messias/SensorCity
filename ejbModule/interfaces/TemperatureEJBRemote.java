package interfaces;

import java.util.List;

import Sensors.Sensor;

public interface TemperatureEJBRemote extends SensorEJBRemote {
	List<Sensor> findSensorWthTemperature();
}
