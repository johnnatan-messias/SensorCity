package stateless;

import interfaces.AudioEJBRemote;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import Sensors.AudioEntity;
import Sensors.SensorEntity;
import database.Commands;

@Stateless
@LocalBean
public class AudioEJB implements AudioEJBRemote {

	@PersistenceContext(unitName = "SensorCity", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;

	@Override
	public List<AudioEntity> findAudio() {
		Query query = em.createQuery(Commands.findAudio);
		return query.getResultList();
	}

	@Override
	public AudioEntity findAudioById(long id) {
		return em.find(AudioEntity.class, id);
	}

	@Override
	public AudioEntity createAudio(AudioEntity audio) {
		em.persist(audio);
		return audio;
	}

	@Override
	public void deleteAudio(AudioEntity audio) {
		em.remove(em.merge(audio));
	}

	@Override
	public AudioEntity updateAudio(AudioEntity audio) {
		return em.merge(audio);
	}

	@Override
	public List<SensorEntity> findSensorWithAudio() {
		Query query = em.createQuery(Commands.findSensorWithAudio);
		return query.getResultList();
	}

}
