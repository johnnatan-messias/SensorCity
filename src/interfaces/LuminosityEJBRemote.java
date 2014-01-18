package interfaces;

import java.util.List;

import javax.ejb.Remote;

import Sensors.LuminosityEntity;
import Sensors.SensorEntity;

@Remote
public interface LuminosityEJBRemote {
	List<LuminosityEntity> findLuminosity();
	LuminosityEntity findLuminosityById(long id);
	LuminosityEntity createLuminosity(LuminosityEntity luminosity);
	void deleteLuminosity(LuminosityEntity luminosity);
	LuminosityEntity updateLuminosity(LuminosityEntity luminosity);
	List<SensorEntity> findSensorWithLuminosity();
}
