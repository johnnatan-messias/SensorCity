package interfaces;

import java.util.List;

import Sensors.Sensor;

public interface LuminosityEJBRemote extends SensorEJBRemote {
	List<Sensor> findSensorWthLuminosity();
}
