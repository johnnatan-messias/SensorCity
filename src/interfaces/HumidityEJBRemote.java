package interfaces;

import java.util.List;

import javax.ejb.Remote;

import Sensors.HumidityEntity;
import Sensors.SensorEntity;

@Remote
public interface HumidityEJBRemote {
	List<HumidityEntity> findHumidity();
	HumidityEntity findHumidityById(long id);
	HumidityEntity createHumidity(HumidityEntity humidity);
	void deleteHumidity(HumidityEntity humidity);
	HumidityEntity updateHumidity(HumidityEntity humidity);
	List<SensorEntity> findSensorWithHumidity();
}
