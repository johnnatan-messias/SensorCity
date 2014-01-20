package services;

import interfaces.AudioEJBRemote;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import Sensors.AudioEntity;
import Sensors.SensorEntity;
import data.Audio;
import data.Sensor;

@Path("/sensor/type/audio")
@Produces(MediaType.APPLICATION_XML)
public class AudioService {

	@EJB
	AudioEJBRemote audioEJB;

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public void create(Audio audio) {
		System.out.println("createAudio");
		audioEJB.createAudio(audio.toAudio());
	}

	@GET
	@Path("/get")
	@Consumes(MediaType.APPLICATION_XML)
	public Audio read(@QueryParam("id") long id) {
		System.out.println("readAudio");
		return audioEJB.findAudioById(id).toAudioData();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public void update(Audio audio) {
		System.out.println("updateAudio");
		audioEJB.updateAudio(audio.toAudio());
	}

	@DELETE
	@Path("/del")
	public void delete(@QueryParam("id") long id) {
		System.out.println("deleteAudio");
		AudioEntity audio = audioEJB.findAudioById(id);
		if (audio != null) {
			audioEJB.deleteAudio(audio);
		}
	}

	@GET
	@Path("/get/audio")
	@Consumes(MediaType.APPLICATION_XML)
	public List<Audio> findAudio() {
		System.out.println("findAudio");
		List<AudioEntity> audios = audioEJB.findAudio();
		List<Audio> lAudios = new ArrayList<Audio>();
		for (AudioEntity audio : audios) {
			lAudios.add(audio.toAudioData());
		}
		return lAudios;
	}

	@GET
	@Path("/get/sensors")
	@Consumes(MediaType.APPLICATION_XML)
	public List<Sensor> findSensorWithAudio() {
		System.out.println("findSensorWithAudio");
		List<SensorEntity> sensors = audioEJB.findSensorWithAudio();
		List<Sensor> lSensors = new ArrayList<Sensor>();
		for (SensorEntity sensor : sensors) {
			lSensors.add(sensor.toSensorData());
		}
		return lSensors;
	}
	
}
