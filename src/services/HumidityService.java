package services;

import interfaces.HumidityEJBRemote;

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

import Sensors.Humidity;
import Sensors.Sensor;

@Path("/sensor/type/humidity")
@Produces(MediaType.APPLICATION_XML)
public class HumidityService {

	@EJB
	HumidityEJBRemote humidityEJB;

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public void create(Humidity humidity) {
		System.out.println("createHumidity");
		humidityEJB.createHumidity(humidity);
	}

	@GET
	@Path("/get")
	@Consumes(MediaType.APPLICATION_XML)
	public Humidity read(@QueryParam("id") long id) {
		System.out.println("readHumidity");
		return humidityEJB.findHumidityById(id);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public void update(Humidity humidity) {
		System.out.println("updateHumidity");
		humidityEJB.updateHumidity(humidity);
	}

	@DELETE
	@Path("/del")
	public void delete(@QueryParam("id") long id) {
		System.out.println("deleteHumidity");
		Humidity humidity = humidityEJB.findHumidityById(id);
		if (humidity != null) {
			humidityEJB.deleteHumidity(humidity);
		}
	}

	@GET
	@Path("/get/humidity")
	@Consumes(MediaType.APPLICATION_XML)
	public List<Humidity> findHumidity() {
		System.out.println("findHumidity");
		return humidityEJB.findHumidity();
	}

	@GET
	@Path("/get/sensors")
	@Consumes(MediaType.APPLICATION_XML)
	public List<Sensor> findSensorWithHumidity() {
		System.out.println("findSensorWithHumidity");
		return humidityEJB.findSensorWithHumidity();
	}
}
