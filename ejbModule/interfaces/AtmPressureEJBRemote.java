package interfaces;

import java.util.List;

import Sensors.Sensor;

public interface AtmPressureEJBRemote extends SensorEJBRemote {
	List<Sensor> findSensorWthAtmPressure();
}
