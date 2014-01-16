package services;

import interfaces.AtmPressureEJBRemote;

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

@Path("/sensor/type/atmpressure")
@Produces(MediaType.APPLICATION_XML)
public class AtmPressureService {

	@EJB
	AtmPressureEJBRemote atmPressureEJB;

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public void create(AtmPressure atmPressure) {
		System.out.println("createAtmPressure");
		atmPressureEJB.createAtmPressure(atmPressure);
	}

	@GET
	@Path("/get")
	@Consumes(MediaType.APPLICATION_XML)
	public AtmPressure read(@QueryParam("id") long id) {
		System.out.println("readAtmPressure");
		return atmPressureEJB.findAtmPressureById(id);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public void update(AtmPressure atmPressure) {
		System.out.println("updateAtmPressure");
		atmPressureEJB.updateAtmPressure(atmPressure);
	}

	@DELETE
	@Path("/del")
	public void delete(@QueryParam("id") long id) {
		System.out.println("deleteAtmPressure");
		AtmPressure atmPressure = atmPressureEJB.findAtmPressureById(id);
		if (atmPressure != null) {
			atmPressureEJB.deleteSensor(atmPressure);
		}
	}

	@GET
	@Path("/get/atmpressure")
	@Consumes(MediaType.APPLICATION_XML)
	public List<AtmPressure> findAtmPressure() {
		System.out.println("findAtmPressure");
		return atmPressureEJB.findAtmPressure();
	}

	@GET
	@Path("/get/sensors")
	@Consumes(MediaType.APPLICATION_XML)
	public List<Sensor> findSensorWithAtmPressure() {
		System.out.println("findSensorWithAtmPressure");
		return atmPressureEJB.findSensorWithAtmPressure();
	}
}
