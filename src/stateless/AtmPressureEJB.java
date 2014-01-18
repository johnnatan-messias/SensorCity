package stateless;

import interfaces.AtmPressureEJBRemote;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import Sensors.AtmPressureEntity;
import Sensors.SensorEntity;
import database.Commands;

@Stateless
@LocalBean
public class AtmPressureEJB implements AtmPressureEJBRemote {

	@PersistenceContext(unitName = "SensorCity", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;

	@Override
	public List<AtmPressureEntity> findAtmPressure() {
		Query query = em.createQuery(Commands.findAtmPressure);
		return query.getResultList();

	}

	@Override
	public AtmPressureEntity findAtmPressureById(long id) {
		return em.find(AtmPressureEntity.class, id);
	}

	@Override
	public AtmPressureEntity createAtmPressure(AtmPressureEntity atmPressure) {
		em.persist(atmPressure);
		return atmPressure;
	}

	@Override
	public void deleteAtmPressure(AtmPressureEntity atmPressure) {
		em.remove(em.merge(atmPressure));
	}

	@Override
	public AtmPressureEntity updateAtmPressure(AtmPressureEntity atmPressure) {
		return em.merge(atmPressure);
	}

	@Override
	public List<SensorEntity> findSensorWithAtmPressure() {
		Query query = em.createQuery(Commands.findSensorWithAtmPressure);
		return query.getResultList();
	}

}
