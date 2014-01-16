package interfaces;

import java.util.List;

import javax.ejb.Remote;

import Sensors.Luminosity;
import Sensors.Sensor;

@Remote
public interface LuminosityEJBRemote {
	List<Luminosity> findLuminosity();
	Luminosity findLuminosityById(long id);
	Luminosity createLuminosity(Luminosity luminosity);
	void deleteLuminosity(Luminosity luminosity);
	Luminosity updateLuminosity(Luminosity luminosity);
	List<Sensor> findSensorWithLuminosity();
}
