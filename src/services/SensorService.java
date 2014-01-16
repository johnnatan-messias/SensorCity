package services;

import interfaces.SensorEJBRemote;

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

import Sensors.Sensor;

@Path("/sensor")
public class SensorService {

	@EJB
	SensorEJBRemote sensorEJB;

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public void create(Sensor sensor) {
		System.out.println("createSensor");
		sensorEJB.createSensor(sensor);
	}

	@GET
	@Path("/get")
	@Consumes(MediaType.APPLICATION_XML)
	public Sensor read(@QueryParam("id") long id) {
		System.out.println("readSensor");
		return sensorEJB.findSensorById(id);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public void update(Sensor sensor) {
		System.out.println("updateSensor");
		sensorEJB.updateSensor(sensor);
	}

	@DELETE
	@Path("/del")
	public void delete(@QueryParam("id") long id) {
		System.out.println("deleteSensor");
		Sensor sensor = sensorEJB.findSensorById(id);
		if (sensor != null) {
			sensorEJB.deleteSensor(sensor);
		}
	}

	@GET
	@Path("/get/sensors")
	@Consumes(MediaType.APPLICATION_XML)
	public List<Sensor> findSensors() {
		System.out.println("findSensor");
		return sensorEJB.findSensor();
	}

	@GET
	@Path("/byname")
	@Consumes(MediaType.APPLICATION_XML)
	public Sensor findSensorByName(@QueryParam("name") String name) {
		System.out.println("findSensorByName");
		return sensorEJB.findSensorByName(name);
	}

	@GET
	@Path("/get/func")
	@Consumes(MediaType.APPLICATION_XML)
	public boolean[] findFunctionalities(@QueryParam("id") long id) {
		System.out.println("findFunctionalities");
		return sensorEJB.findFunctionalities(id);
	}

}
