package stateless;

import interfaces.AtmPressureEJBRemote;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Sensors.AtmPressure;
import Sensors.Sensor;
import database.Commands;

@Stateless
@LocalBean
@WebService
@Named
public class AtmPressureEJB implements AtmPressureEJBRemote {

	@PersistenceContext(unitName = "SensorCity")
	private EntityManager em;

	@Override
	public List<AtmPressure> findAtmPressure() {
		Query query = em.createQuery(Commands.findAtmPressure);
		return query.getResultList();

	}

	@Override
	public AtmPressure findAtmPressureById(int id) {
		return em.find(AtmPressure.class, id);
	}

	@Override
	public AtmPressure createAtmPressure(AtmPressure atmPressure) {
		em.persist(atmPressure);
		return atmPressure;
	}

	@Override
	public void deleteSensor(AtmPressure atmPressure) {
		em.remove(em.merge(atmPressure));
	}

	@Override
	public AtmPressure updateAtmPressure(AtmPressure atmPressure) {
		return em.merge(atmPressure);
	}

	@Override
	public List<Sensor> findSensorWithAtmPressure() {
		Query query = em.createQuery(Commands.findSensorWithAtmPressure);
		return query.getResultList();
	}

}
