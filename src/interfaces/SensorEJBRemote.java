package interfaces;

import java.util.List;

import javax.ejb.Remote;

import Sensors.Sensor;

@Remote
public interface SensorEJBRemote {
	List<Sensor> findSensor();
	Sensor findSensorById(long id);
	Sensor findSensorByName(String name);
	Sensor createSensor(Sensor sensor);
	void deleteSensor(Sensor sensor);
	Sensor updateSensor(Sensor sensor);
	boolean[] findFunctionalities(long id);
}
