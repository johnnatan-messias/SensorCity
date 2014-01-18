package stateless;

import interfaces.GPSEJBRemote;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import Sensors.GPSEntity;
import Sensors.SensorEntity;
import database.Commands;

@Stateless
@LocalBean
public class GPSEJB implements GPSEJBRemote {

	@PersistenceContext(unitName = "SensorCity", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;

	@Override
	public List<GPSEntity> findGPS() {
		Query query = em.createQuery(Commands.findGPS);
		return query.getResultList();
	}

	@Override
	public GPSEntity findGPSById(long id) {
		return em.find(GPSEntity.class, id);
	}

	@Override
	public GPSEntity createGPS(GPSEntity gps) {
		em.persist(gps);
		return gps;
	}

	@Override
	public void deleteGPS(GPSEntity gps) {
		em.remove(em.merge(gps));

	}

	@Override
	public GPSEntity updateGPS(GPSEntity gps) {
		return em.merge(gps);
	}

	@Override
	public List<SensorEntity> findSensorWithGPS() {
		Query query = em.createQuery(Commands.findSensorWithGPS);
		return query.getResultList();
	}

}
