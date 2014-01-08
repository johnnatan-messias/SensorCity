package interfaces;

import java.util.List;

import Sensors.Sensor;

public interface AudioEJBRemote extends SensorEJBRemote {
	List<Sensor> findSensorWthAudio();
}
