package interfaces;

import java.util.List;

import javax.ejb.Remote;

import Sensors.AudioEntity;
import Sensors.SensorEntity;

@Remote
public interface AudioEJBRemote {
	List<AudioEntity> findAudio();
	AudioEntity findAudioById(long id);
	AudioEntity createAudio(AudioEntity audio);
	void deleteAudio(AudioEntity audio);
	AudioEntity updateAudio(AudioEntity audio);
	List<SensorEntity> findSensorWithAudio();
}
