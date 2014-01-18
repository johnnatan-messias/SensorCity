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

import Sensors.Sensor;
import data.SensorData;

@Path("/sensor")
public class SensorService {

	@EJB
	SensorEJBRemote sensorEJB;

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public void create(SensorData sensor) {
		System.out.println("createSensor");
		sensorEJB.createSensor(sensor.toSensor());
	}

	@GET
	@Path("/get")
	@Consumes(MediaType.APPLICATION_XML)
	public SensorData read(@QueryParam("id") long id) {
		System.out.println("readSensor");
		return sensorEJB.findSensorById(id).toSensorData();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public void update(SensorData sensor) {
		System.out.println("updateSensor");
		sensorEJB.updateSensor(sensor.toSensor());
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
	@Path("/get/sensor")
	@Consumes(MediaType.APPLICATION_XML)
	public List<SensorData> findSensors() {
		System.out.println("findSensor");
		List<Sensor> sensors = sensorEJB.findSensor();
		List<SensorData> lSensors = new ArrayList<SensorData>();
		for (Sensor sensor : sensors) {
			lSensors.add(sensor.toSensorData());
		}
		return lSensors;
	}

	@GET
	@Path("/byname")
	@Consumes(MediaType.APPLICATION_XML)
	public SensorData findSensorByName(@QueryParam("name") String name) {
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
