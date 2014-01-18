package services;

import interfaces.AtmPressureEJBRemote;

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

import Sensors.AtmPressure;
import Sensors.Sensor;
import data.AtmPressureData;
import data.SensorData;

@Path("/sensor/type/atmPressure")
@Produces(MediaType.APPLICATION_XML)
public class AtmPressureService {

	@EJB
	AtmPressureEJBRemote atmPressureEJB;

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public void create(AtmPressureData atmPressure) {
		System.out.println("createAtmPressure");
		atmPressureEJB.createAtmPressure(atmPressure.toAtmPressure());
	}

	@GET
	@Path("/get")
	@Consumes(MediaType.APPLICATION_XML)
	public AtmPressureData read(@QueryParam("id") long id) {
		System.out.println("readAtmPressure");
		return atmPressureEJB.findAtmPressureById(id).toAtmPressureData();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public void update(AtmPressureData atmPressure) {
		System.out.println("updateAtmPressure");
		atmPressureEJB.updateAtmPressure(atmPressure.toAtmPressure());
	}

	@DELETE
	@Path("/del")
	public void delete(@QueryParam("id") long id) {
		System.out.println("deleteAtmPressure");
		AtmPressure atmPressure = atmPressureEJB.findAtmPressureById(id);
		if (atmPressure != null) {
			atmPressureEJB.deleteAtmPressure(atmPressure);
		}
	}

	@GET
	@Path("/get/atmPressure")
	@Consumes(MediaType.APPLICATION_XML)
	public List<AtmPressureData> findAtmPressure() {
		System.out.println("findAtmPressure");
		List<AtmPressure> atmPressures = atmPressureEJB.findAtmPressure();
		List<AtmPressureData> lAtmPressures = new ArrayList<AtmPressureData>();
		for (AtmPressure atmPressure : atmPressures) {
			lAtmPressures.add(atmPressure.toAtmPressureData());
		}
		return lAtmPressures;
	}

	@GET
	@Path("/get/sensors")
	@Consumes(MediaType.APPLICATION_XML)
	public List<SensorData> findSensorWithAtmPressure() {
		System.out.println("findSensorWithAtmPressure");
		List<Sensor> sensors = atmPressureEJB.findSensorWithAtmPressure();
		List<SensorData> lSensors = new ArrayList<SensorData>();
		for (Sensor sensor : sensors) {
			lSensors.add(sensor.toSensorData());
		}
		return lSensors;
	}
}
