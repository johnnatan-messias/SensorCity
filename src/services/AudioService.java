package services;

import interfaces.AudioEJBRemote;

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

import Sensors.Audio;
import Sensors.Sensor;

@Path("/sensor/type/audio")
@Produces(MediaType.APPLICATION_XML)
public class AudioService {

	@EJB
	AudioEJBRemote audioEJB;

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public void create(Audio audio) {
		System.out.println("createAudio");
		audioEJB.createAudio(audio);
	}

	@GET
	@Path("/get")
	@Consumes(MediaType.APPLICATION_XML)
	public Audio read(@QueryParam("id") long id) {
		System.out.println("readAudio");
		return audioEJB.findAudioById(id);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public void update(Audio audio) {
		System.out.println("updateAudio");
		audioEJB.updateAudio(audio);
	}

	@DELETE
	@Path("/del")
	public void delete(@QueryParam("id") long id) {
		System.out.println("deleteAudio");
		Audio audio = audioEJB.findAudioById(id);
		if (audio != null) {
			audioEJB.deleteAudio(audio);
		}
	}

	@GET
	@Path("/get/audio")
	@Consumes(MediaType.APPLICATION_XML)
	public List<Audio> findAudio() {
		System.out.println("findAudio");
		return audioEJB.findAudio();
	}

	@GET
	@Path("/get/sensors")
	@Consumes(MediaType.APPLICATION_XML)
	public List<Sensor> findSensorWithAudio() {
		System.out.println("findSensorWithAudio");
		return audioEJB.findSensorWithAudio();
	}
}
