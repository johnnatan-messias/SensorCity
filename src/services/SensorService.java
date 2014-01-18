package services;

import interfaces.SensorEJBRemote;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import Sensors.SensorEntity;
import data.Sensor;

@Path("/sensor")
public class SensorService {

	@EJB
	SensorEJBRemote sensorEJB;

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public void create(Sensor sensor) {
		System.out.println("createSensor");
		sensorEJB.createSensor(sensor.toSensor());
	}

	@GET
	@Path("/get")
	@Consumes(MediaType.APPLICATION_XML)
	public Sensor read(@QueryParam("id") long id) {
		System.out.println("readSensor");
		return sensorEJB.findSensorById(id).toSensorData();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public void update(Sensor sensor) {
		System.out.println("updateSensor");
		sensorEJB.updateSensor(sensor.toSensor());
	}

	@DELETE
	@Path("/del")
	public void delete(@QueryParam("id") long id) {
		System.out.println("deleteSensor");
		SensorEntity sensor = sensorEJB.findSensorById(id);
		if (sensor != null) {
			sensorEJB.deleteSensor(sensor);
		}
	}

	@GET
	@Path("/get/sensor")
	@Consumes(MediaType.APPLICATION_XML)
	public List<Sensor> findSensors() {
		System.out.println("findSensor");
		List<SensorEntity> sensors = sensorEJB.findSensor();
		List<Sensor> lSensors = new ArrayList<Sensor>();
		for (SensorEntity sensor : sensors) {
			lSensors.add(sensor.toSensorData());
		}
		return lSensors;
	}

	@GET
	@Path("/byname")
	@Consumes(MediaType.APPLICATION_XML)
	public Sensor findSensorByName(@QueryParam("name") String name) {
		System.out.println("findSensorByName");
		return sensorEJB.findSensorByName(name).toSensorData();
	}

	@GET
	@Path("/get/func")
	@Consumes(MediaType.APPLICATION_XML)
	public boolean[] findFunctionalities(@QueryParam("id") long id) {
		System.out.println("findFunctionalities");
		return sensorEJB.findFunctionalities(id);
	}

}
