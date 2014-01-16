package interfaces;

import java.util.List;

import javax.ejb.Remote;

import Sensors.Sensor;
import Sensors.Temperature;

@Remote
public interface TemperatureEJBRemote {
	List<Temperature> findTemperature();
	Temperature findTemperatureById(int id);
	Temperature createTemperature(Temperature temperature);
	void deleteTemperature(Temperature temperature);
	Temperature updateTemperature(Temperature temperature);
	List<Sensor> findSensorWithTemperature();
}
