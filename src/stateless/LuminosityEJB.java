package stateless;

import interfaces.LuminosityEJBRemote;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import Sensors.LuminosityEntity;
import Sensors.SensorEntity;
import database.Commands;

@Stateless
@LocalBean
public class LuminosityEJB implements LuminosityEJBRemote {

	@PersistenceContext(unitName = "SensorCity", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;

	@Override
	public List<LuminosityEntity> findLuminosity() {
		Query query = em.createQuery(Commands.findLuminosity);
		return query.getResultList();
	}

	@Override
	public LuminosityEntity findLuminosityById(long id) {
		return em.find(LuminosityEntity.class, id);
	}

	@Override
	public LuminosityEntity createLuminosity(LuminosityEntity luminosity) {
		em.persist(luminosity);
		return luminosity;
	}

	@Override
	public void deleteLuminosity(LuminosityEntity luminosity) {
		em.remove(em.merge(luminosity));
	}

	@Override
	public LuminosityEntity updateLuminosity(LuminosityEntity luminosity) {
		return em.merge(luminosity);
	}

	@Override
	public List<SensorEntity> findSensorWithLuminosity() {
		Query query = em.createQuery(Commands.findSensorWithLuminosity);
		return query.getResultList();
	}

}
