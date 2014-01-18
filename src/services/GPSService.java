package services;

import interfaces.GPSEJBRemote;

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

import Sensors.GPS;
import Sensors.Sensor;
import data.GPSData;
import data.SensorData;

@Path("/sensor/type/gps")
@Produces(MediaType.APPLICATION_XML)
public class GPSService {

	@EJB
	GPSEJBRemote gpsEJB;

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public void create(GPSData gps) {
		System.out.println("createGPS");
		gpsEJB.createGPS(gps.toGPS());
	}

	@GET
	@Path("/get")
	@Consumes(MediaType.APPLICATION_XML)
	public GPSData read(@QueryParam("id") long id) {
		System.out.println("readGPS");
		return gpsEJB.findGPSById(id).toGPSData();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public void update(GPSData gps) {
		System.out.println("updateGPS");
		gpsEJB.updateGPS(gps.toGPS());
	}

	@DELETE
	@Path("/del")
	public void delete(@QueryParam("id") long id) {
		System.out.println("deleteGPS");
		GPS gps = gpsEJB.findGPSById(id);
		if (gps != null) {
			gpsEJB.deleteGPS(gps);
		}
	}

	@GET
	@Path("/get/gps")
	@Consumes(MediaType.APPLICATION_XML)
	public List<GPSData> findGPS() {
		System.out.println("findGPS");
		List<GPS> gpss = gpsEJB.findGPS();
		List<GPSData> lGPSs = new ArrayList<GPSData>();
		for (GPS gps : gpss) {
			lGPSs.add(gps.toGPSData());
		}
		return lGPSs;
	}

	@GET
	@Path("/get/sensors")
	@Consumes(MediaType.APPLICATION_XML)
	public List<SensorData> findSensorWithGPS() {
		System.out.println("findSensorWithGPS");
		List<Sensor> sensors = gpsEJB.findSensorWithGPS();
		List<SensorData> lSensors = new ArrayList<SensorData>();
		for (Sensor sensor : sensors) {
			lSensors.add(sensor.toSensorData());
		}
		return lSensors;
	}
}
