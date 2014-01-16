package interfaces;

import java.util.List;

import javax.ejb.Remote;

import Sensors.Audio;
import Sensors.Sensor;

@Remote
public interface AudioEJBRemote {
	List<Audio> findAudio();
	Audio findAudioById(long id);
	Audio createAudio(Audio audio);
	void deleteAudio(Audio audio);
	Audio updateAudio(Audio audio);
	List<Sensor> findSensorWithAudio();
}
