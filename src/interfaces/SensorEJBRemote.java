package interfaces;

import java.util.List;

import javax.ejb.Remote;

import Sensors.SensorEntity;

@Remote
public interface SensorEJBRemote {
	List<SensorEntity> findSensor();
	SensorEntity findSensorById(long id);
	SensorEntity findSensorByName(String name);
	SensorEntity createSensor(SensorEntity sensor);
	void deleteSensor(SensorEntity sensor);
	SensorEntity updateSensor(SensorEntity sensor);
	boolean[] findFunctionalities(long id);
}
