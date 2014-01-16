package stateless;

import interfaces.LuminosityEJBRemote;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import Sensors.Luminosity;
import Sensors.Sensor;
import database.Commands;

@Stateless
@LocalBean
public class LuminosityEJB implements LuminosityEJBRemote {

	@PersistenceContext(unitName = "SensorCity", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;

	@Override
	public List<Luminosity> findLuminosity() {
		Query query = em.createQuery(Commands.findLuminosity);
		return query.getResultList();
	}

	@Override
	public Luminosity findLuminosityById(long id) {
		return em.find(Luminosity.class, id);
	}

	@Override
	public Luminosity createLuminosity(Luminosity luminosity) {
		em.persist(luminosity);
		return luminosity;
	}

	@Override
	public void deleteLuminosity(Luminosity luminosity) {
		em.remove(em.merge(luminosity));
	}

	@Override
	public Luminosity updateLuminosity(Luminosity luminosity) {
		return em.merge(luminosity);
	}

	@Override
	public List<Sensor> findSensorWithLuminosity() {
		Query query = em.createQuery(Commands.findSensorWithLuminosity);
		return query.getResultList();
	}

}
