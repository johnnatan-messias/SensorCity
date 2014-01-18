package stateless;

import interfaces.SensorEJBRemote;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import Sensors.SensorEntity;
import database.Commands;

@Stateless
@LocalBean
public class SensorEJB implements SensorEJBRemote {

	@PersistenceContext(unitName = "SensorCity", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;

	@Override
	public List<SensorEntity> findSensor() {
		Query query = em.createQuery(Commands.findSensor);
		return query.getResultList();
	}

	@Override
	public SensorEntity findSensorById(long id) {
		return em.find(SensorEntity.class, id);
	}

	@Override
	public SensorEntity findSensorByName(String name) {
		Query query = em.createQuery(Commands.findSensorByName);
		query.setParameter(Commands.value, name);
		return (SensorEntity) query.getSingleResult();
	}

	@Override
	public SensorEntity createSensor(SensorEntity sensor) {
		em.persist(sensor);
		return sensor;
	}

	@Override
	public void deleteSensor(SensorEntity sensor) {
		em.remove(em.merge(sensor));
	}

	@Override
	public SensorEntity updateSensor(SensorEntity sensor) {
		return em.merge(sensor);
	}

	@Override
	public boolean[] findFunctionalities(long id) {
		boolean[] functionalities = new boolean[6];
		Query query;

		// Query to check GPS
		query = em.createQuery(Commands.findFunctionalitiesGPS);
		query.setParameter(Commands.value, id);
		if ((int) query.getSingleResult() > 0) {
			functionalities[Commands.posGPS] = true;
		} else {
			functionalities[Commands.posGPS] = false;
		}

		// Query to check Audio
		query = em.createQuery(Commands.findFunctionalitiesAudio);
		query.setParameter(Commands.value, id);
		if ((int) query.getSingleResult() > 0) {
			functionalities[Commands.posAudio] = true;
		} else {
			functionalities[Commands.posAudio] = false;
		}

		// Query to check Humidity
		query = em.createQuery(Commands.findFunctionalitiesHumidity);
		query.setParameter(Commands.value, id);
		if ((int) query.getSingleResult() > 0) {
			functionalities[Commands.posHumidity] = true;
		} else {
			functionalities[Commands.posHumidity] = false;
		}

		// Query to check AtmPressure
		query = em.createQuery(Commands.findFunctionalitiesAtmPressure);
		query.setParameter(Commands.value, id);
		if ((int) query.getSingleResult() > 0) {
			functionalities[Commands.posAtmPressure] = true;
		} else {
			functionalities[Commands.posAtmPressure] = false;
		}

		// Query to check Luminosity
		query = em.createQuery(Commands.findFunctionalitiesLuminosity);
		query.setParameter(Commands.value, id);
		if ((int) query.getSingleResult() > 0) {
			functionalities[Commands.posLuminosity] = true;
		} else {
			functionalities[Commands.posLuminosity] = false;
		}

		// Query to check Temperature
		query = em.createQuery(Commands.findFunctionalitiesTemperature);
		query.setParameter(Commands.value, id);
		if ((int) query.getSingleResult() > 0) {
			functionalities[Commands.posTemperature] = true;
		} else {
			functionalities[Commands.posTemperature] = false;
		}

		return functionalities;
	}
}
