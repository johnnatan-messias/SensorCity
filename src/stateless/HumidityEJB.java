package stateless;

import interfaces.HumidityEJBRemote;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import Sensors.HumidityEntity;
import Sensors.SensorEntity;
import database.Commands;

@Stateless
@LocalBean
public class HumidityEJB implements HumidityEJBRemote {

	@PersistenceContext(unitName = "SensorCity", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;

	@Override
	public List<HumidityEntity> findHumidity() {
		Query query = em.createQuery(Commands.findHumidity);
		return query.getResultList();
	}

	@Override
	public HumidityEntity findHumidityById(long id) {
		return em.find(HumidityEntity.class, id);
	}

	@Override
	public HumidityEntity createHumidity(HumidityEntity humidity) {
		em.persist(humidity);
		return humidity;
	}

	@Override
	public void deleteHumidity(HumidityEntity humidity) {
		em.remove(em.merge(humidity));
	}

	@Override
	public HumidityEntity updateHumidity(HumidityEntity humidity) {
		return em.merge(humidity);
	}

	@Override
	public List<SensorEntity> findSensorWithHumidity() {
		Query query = em.createQuery(Commands.findSensorWithHumidity);
		return query.getResultList();
	}

}
