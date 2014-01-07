package interfaces;

import java.util.List;

import Sensors.AtmPressure;
import Sensors.Sensor;

public interface AtmPressureEJBRemote {
	List<AtmPressure> findAtmPressure();
	AtmPressure findAtmPressureById(int id);
	AtmPressure createAtmPressure(AtmPressure atmPressure);
	AtmPressure deleteAtmPressure(AtmPressure atmPressure);
	AtmPressure updateAtmPressure(AtmPressure atmPressure);
	List<Sensor> findSensorWthAtmPressure();
}
