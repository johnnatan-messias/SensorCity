package services;

import interfaces.TemperatureEJBRemote;

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

import Sensors.Sensor;
import Sensors.Temperature;
import data.SensorData;
import data.TemperatureData;

@Path("/sensor/type/temperature")
@Produces(MediaType.APPLICATION_XML)
public class TemperatureService {

	@EJB
	TemperatureEJBRemote temperatureEJB;

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public void create(TemperatureData temperature) {
		System.out.println("createTemperature");
		temperatureEJB.createTemperature(temperature.toTemperature());
	}

	@GET
	@Path("/get")
	@Consumes(MediaType.APPLICATION_XML)
	public TemperatureData read(@QueryParam("id") long id) {
		System.out.println("readTemperature");
		return temperatureEJB.findTemperatureById(id).toTemperatureData();

	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public void update(TemperatureData temperature) {
		System.out.println("updateTemperature");
		temperatureEJB.updateTemperature(temperature.toTemperature());
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
	public List<TemperatureData> findTemperature() {
		System.out.println("findTemperature");
		List<Temperature> temperatures = temperatureEJB.findTemperature();
		List<TemperatureData> lTemperatures = new ArrayList<TemperatureData>();
		for (Temperature temperature : temperatures) {
			lTemperatures.add(temperature.toTemperatureData());
		}
		return lTemperatures;
	}

	@GET
	@Path("/get/sensors")
	@Consumes(MediaType.APPLICATION_XML)
	public List<SensorData> findSensorWithTemperature() {
		System.out.println("findSensorWithTemperature");
		List<Sensor> sensors = temperatureEJB.findSensorWithTemperature();
		List<SensorData> lSensors = new ArrayList<SensorData>();
		for (Sensor sensor : sensors) {
			lSensors.add(sensor.toSensorData());
		}
		return lSensors;
	}
}
