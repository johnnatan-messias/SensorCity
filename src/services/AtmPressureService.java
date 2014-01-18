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

import Sensors.AtmPressureEntity;
import Sensors.SensorEntity;
import data.AtmPressure;
import data.Sensor;

@Path("/sensor/type/atmPressure")
@Produces(MediaType.APPLICATION_XML)
public class AtmPressureService {

	@EJB
	AtmPressureEJBRemote atmPressureEJB;

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public void create(AtmPressure atmPressure) {
		System.out.println("createAtmPressure");
		atmPressureEJB.createAtmPressure(atmPressure.toAtmPressure());
	}

	@GET
	@Path("/get")
	@Consumes(MediaType.APPLICATION_XML)
	public AtmPressure read(@QueryParam("id") long id) {
		System.out.println("readAtmPressure");
		return atmPressureEJB.findAtmPressureById(id).toAtmPressureData();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public void update(AtmPressure atmPressure) {
		System.out.println("updateAtmPressure");
		atmPressureEJB.updateAtmPressure(atmPressure.toAtmPressure());
	}

	@DELETE
	@Path("/del")
	public void delete(@QueryParam("id") long id) {
		System.out.println("deleteAtmPressure");
		AtmPressureEntity atmPressure = atmPressureEJB.findAtmPressureById(id);
		if (atmPressure != null) {
			atmPressureEJB.deleteAtmPressure(atmPressure);
		}
	}

	@GET
	@Path("/get/atmPressure")
	@Consumes(MediaType.APPLICATION_XML)
	public List<AtmPressure> findAtmPressure() {
		System.out.println("findAtmPressure");
		List<AtmPressureEntity> atmPressures = atmPressureEJB.findAtmPressure();
		List<AtmPressure> lAtmPressures = new ArrayList<AtmPressure>();
		for (AtmPressureEntity atmPressure : atmPressures) {
			lAtmPressures.add(atmPressure.toAtmPressureData());
		}
		return lAtmPressures;
	}

	@GET
	@Path("/get/sensors")
	@Consumes(MediaType.APPLICATION_XML)
	public List<Sensor> findSensorWithAtmPressure() {
		System.out.println("findSensorWithAtmPressure");
		List<SensorEntity> sensors = atmPressureEJB.findSensorWithAtmPressure();
		List<Sensor> lSensors = new ArrayList<Sensor>();
		for (SensorEntity sensor : sensors) {
			lSensors.add(sensor.toSensorData());
		}
		return lSensors;
	}
}
