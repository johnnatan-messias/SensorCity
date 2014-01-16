package stateless;

import interfaces.AudioEJBRemote;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import Sensors.Audio;
import Sensors.Sensor;
import database.Commands;

@Stateless
@LocalBean
public class AudioEJB implements AudioEJBRemote {

	@PersistenceContext(unitName = "SensorCity", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;

	@Override
	public List<Audio> findAudio() {
		Query query = em.createQuery(Commands.findAudio);
		return query.getResultList();
	}

	@Override
	public Audio findAudioById(long id) {
		return em.find(Audio.class, id);
	}

	@Override
	public Audio createAudio(Audio audio) {
		em.persist(audio);
		return audio;
	}

	@Override
	public void deleteAudio(Audio audio) {
		em.remove(em.merge(audio));
	}

	@Override
	public Audio updateAudio(Audio audio) {
		return em.merge(audio);
	}

	@Override
	public List<Sensor> findSensorWithAudio() {
		Query query = em.createQuery(Commands.findSensorWithAudio);
		return query.getResultList();
	}

}
