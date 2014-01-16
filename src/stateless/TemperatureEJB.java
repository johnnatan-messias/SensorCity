package stateless;

import interfaces.TemperatureEJBRemote;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Sensors.Sensor;
import Sensors.Temperature;
import database.Commands;

@Stateless
@LocalBean
@WebService
@Named
public class TemperatureEJB implements TemperatureEJBRemote {

	@PersistenceContext(unitName = "SensorCity")
	private EntityManager em;

	@Override
	public List<Temperature> findTemperature() {
		Query query = em.createQuery(Commands.findTemperature);
		return query.getResultList();
	}

	@Override
	public Temperature findTemperatureById(int id) {
		return em.find(Temperature.class, id);
	}

	@Override
	public Temperature createTemperature(Temperature temperature) {
		em.persist(temperature);
		return temperature;
	}

	@Override
	public void deleteTemperature(Temperature temperature) {
		em.remove(em.merge(temperature));

	}

	@Override
	public Temperature updateTemperature(Temperature temperature) {
		return em.merge(temperature);
	}

	@Override
	public List<Sensor> findSensorWithTemperature() {
		Query query = em.createQuery(Commands.findSensorWithTemperature);
		return query.getResultList();
	}

}
