package stateless;

import interfaces.AtmPressureEJBRemote;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import Sensors.AtmPressure;
import Sensors.Sensor;
import database.Commands;

@Stateless
@LocalBean
public class AtmPressureEJB implements AtmPressureEJBRemote {

	@PersistenceContext(unitName = "SensorCity", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;

	@Override
	public List<AtmPressure> findAtmPressure() {
		Query query = em.createQuery(Commands.findAtmPressure);
		return query.getResultList();

	}

	@Override
	public AtmPressure findAtmPressureById(long id) {
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
