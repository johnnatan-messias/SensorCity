package stateless;

import interfaces.HumidityEJBRemote;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Sensors.Humidity;
import Sensors.Sensor;
import database.Commands;

@Stateless
@LocalBean
@WebService
@Named
public class HumidityEJB implements HumidityEJBRemote {

	@PersistenceContext(unitName = "SensorCity")
	private EntityManager em;

	@Override
	public List<Humidity> findHumidity() {
		Query query = em.createQuery(Commands.findHumidity);
		return query.getResultList();
	}

	@Override
	public Humidity findHumidityById(int id) {
		return em.find(Humidity.class, id);
	}

	@Override
	public Humidity createHumidity(Humidity humidity) {
		em.persist(humidity);
		return humidity;
	}

	@Override
	public void deleteHumidity(Humidity humidity) {
		em.remove(em.merge(humidity));
	}

	@Override
	public Humidity updateHumidity(Humidity humidity) {
		return em.merge(humidity);
	}

	@Override
	public List<Sensor> findSensorWithHumidity() {
		Query query = em.createQuery(Commands.findSensorWithHumidity);
		return query.getResultList();
	}

}
