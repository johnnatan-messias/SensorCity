package services;

import interfaces.GPSEJBRemote;

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

@Path("/sensor/type/gps")
@Produces(MediaType.APPLICATION_XML)
public class GPSService {

	@EJB
	GPSEJBRemote gpsEJB;

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public void create(GPS gps) {
		System.out.println("createGPS");
		gpsEJB.createGPS(gps);
	}

	@GET
	@Path("/get")
	@Consumes(MediaType.APPLICATION_XML)
	public GPS read(@QueryParam("id") long id) {
		System.out.println("readAudio");
		return gpsEJB.findGPSById(id);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public void update(GPS gps) {
		System.out.println("updateGPS");
		gpsEJB.updateGPS(gps);
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
	public List<GPS> findGPS() {
		System.out.println("findGPS");
		return gpsEJB.findGPS();
	}

	@GET
	@Path("/get/sensors")
	@Consumes(MediaType.APPLICATION_XML)
	public List<Sensor> findSensorWithGPS() {
		System.out.println("findSensorWithGPS");
		return gpsEJB.findSensorWithGPS();
	}
}
