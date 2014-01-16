package services;

import interfaces.TemperatureEJBRemote;

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

import Sensors.Sensor;
import Sensors.Temperature;

@Path("/sensor/type/temperature")
@Produces(MediaType.APPLICATION_XML)
public class TemperatureService {

	@EJB
	TemperatureEJBRemote temperatureEJB;

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public void create(Temperature temperature) {
		System.out.println("createTemperature");
		temperatureEJB.createTemperature(temperature);
	}

	@GET
	@Path("/get")
	@Consumes(MediaType.APPLICATION_XML)
	public Temperature read(@QueryParam("id") long id) {
		System.out.println("readTemperature");
		return temperatureEJB.findTemperatureById(id);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public void update(Temperature temperature) {
		System.out.println("updateTemperature");
		temperatureEJB.updateTemperature(temperature);
	}

	@DELETE
	@Path("/del")
	public void delete(@QueryParam("id") long id) {
		System.out.println("deleteTemperature");
		Temperature temperature = temperatureEJB.findTemperatureById(id);
		if (temperature != null) {
			temperatureEJB.deleteTemperature(temperature);
		}
	}

	@GET
	@Path("/get/temperature")
	@Consumes(MediaType.APPLICATION_XML)
	public List<Temperature> findTemperature() {
		System.out.println("findTemperature");
		return temperatureEJB.findTemperature();
	}

	@GET
	@Path("/get/sensors")
	@Consumes(MediaType.APPLICATION_XML)
	public List<Sensor> findSensorWithTemperature() {
		System.out.println("findSensorWithTemperature");
		return temperatureEJB.findSensorWithTemperature();
	}
}
