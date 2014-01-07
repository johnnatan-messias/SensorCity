package interfaces;

import java.util.List;

import Sensors.Sensor;

public interface SensorEJBRemote {
	List<Sensor> findSensor();
	Sensor findSensorById(int id);
	Sensor findSensorByName(String Name);
	Sensor createSensor(Sensor sensor);
	Sensor deleteSensor(Sensor sensor);
	Sensor updateSensor(Sensor sensor);
	Boolean[] findFuncionalits(int id);
}
