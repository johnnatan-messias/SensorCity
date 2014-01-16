package interfaces;

import java.util.List;

import javax.ejb.Remote;

import Sensors.AtmPressure;
import Sensors.Sensor;

@Remote
public interface AtmPressureEJBRemote {
	List<AtmPressure> findAtmPressure();
	AtmPressure findAtmPressureById(long id);
	AtmPressure createAtmPressure(AtmPressure atmPressure);
	void deleteSensor(AtmPressure atmPressure);
	AtmPressure updateAtmPressure(AtmPressure atmPressure);
	List<Sensor> findSensorWithAtmPressure();
}
