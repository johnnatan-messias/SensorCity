package interfaces;

import java.util.List;

import javax.ejb.Remote;

import Sensors.Humidity;
import Sensors.Sensor;

@Remote
public interface HumidityEJBRemote {
	List<Humidity> findHumidity();
	Humidity findHumidityById(int id);
	Humidity createHumidity(Humidity humidity);
	void deleteHumidity(Humidity humidity);
	Humidity updateHumidity(Humidity humidity);
	List<Sensor> findSensorWithHumidity();
}
