package interfaces;

import java.util.List;

import javax.ejb.Remote;

import Sensors.SensorEntity;
import Sensors.TemperatureEntity;

@Remote
public interface TemperatureEJBRemote {
	List<TemperatureEntity> findTemperature();
	TemperatureEntity findTemperatureById(long id);
	TemperatureEntity createTemperature(TemperatureEntity temperature);
	void deleteTemperature(TemperatureEntity temperature);
	TemperatureEntity updateTemperature(TemperatureEntity temperature);
	List<SensorEntity> findSensorWithTemperature();
}
