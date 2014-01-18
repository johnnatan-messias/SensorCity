package interfaces;

import java.util.List;

import javax.ejb.Remote;

import Sensors.AtmPressureEntity;
import Sensors.SensorEntity;

@Remote
public interface AtmPressureEJBRemote {
	List<AtmPressureEntity> findAtmPressure();
	AtmPressureEntity findAtmPressureById(long id);
	AtmPressureEntity createAtmPressure(AtmPressureEntity atmPressure);
	void deleteAtmPressure(AtmPressureEntity atmPressure);
	AtmPressureEntity updateAtmPressure(AtmPressureEntity atmPressure);
	List<SensorEntity> findSensorWithAtmPressure();
}
