package stateless;

import interfaces.GPSEJBRemote;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import Sensors.GPS;
import Sensors.Sensor;
import database.Commands;

@Stateless
@LocalBean
public class GPSEJB implements GPSEJBRemote {

	@PersistenceContext(unitName = "SensorCity", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;

	@Override
	public List<GPS> findGPS() {
		Query query = em.createQuery(Commands.findGPS);
		return query.getResultList();
	}

	@Override
	public GPS findGPSById(long id) {
		return em.find(GPS.class, id);
	}

	@Override
	public GPS createGPS(GPS gps) {
		em.persist(gps);
		return gps;
	}

	@Override
	public void deleteGPS(GPS gps) {
		em.remove(em.merge(gps));

	}

	@Override
	public GPS updateGPS(GPS gps) {
		return em.merge(gps);
	}

	@Override
	public List<Sensor> findSensorWithGPS() {
		Query query = em.createQuery(Commands.findSensorWithGPS);
		return query.getResultList();
	}

}
