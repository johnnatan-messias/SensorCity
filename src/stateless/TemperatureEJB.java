package stateless;

import interfaces.TemperatureEJBRemote;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import Sensors.SensorEntity;
import Sensors.TemperatureEntity;
import database.Commands;

@Stateless
@LocalBean
public class TemperatureEJB implements TemperatureEJBRemote {

	@PersistenceContext(unitName = "SensorCity", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;

	@Override
	public List<TemperatureEntity> findTemperature() {
		Query query = em.createQuery(Commands.findTemperature);
		return query.getResultList();
	}

	@Override
	public TemperatureEntity findTemperatureById(long id) {
		return em.find(TemperatureEntity.class, id);
	}

	@Override
	public TemperatureEntity createTemperature(TemperatureEntity temperature) {
		em.persist(temperature);
		return temperature;
	}

	@Override
	public void deleteTemperature(TemperatureEntity temperature) {
		em.remove(em.merge(temperature));

	}

	@Override
	public TemperatureEntity updateTemperature(TemperatureEntity temperature) {
		return em.merge(temperature);
	}

	@Override
	public List<SensorEntity> findSensorWithTemperature() {
		Query query = em.createQuery(Commands.findSensorWithTemperature);
		return query.getResultList();
	}

}
