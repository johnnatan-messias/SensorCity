package services;

import interfaces.LuminosityEJBRemote;

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

import Sensors.Luminosity;
import Sensors.Sensor;

@Path("/sensor/type/luminosity")
@Produces(MediaType.APPLICATION_XML)
public class LuminosityService {

	@EJB
	LuminosityEJBRemote luminosityEJB;

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public void create(Luminosity luminosity) {
		System.out.println("createLuminosity");
		luminosityEJB.createLuminosity(luminosity);
	}

	@GET
	@Path("/get")
	@Consumes(MediaType.APPLICATION_XML)
	public Luminosity read(@QueryParam("id") long id) {
		System.out.println("readLuminosity");
		return luminosityEJB.findLuminosityById(id);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public void update(Luminosity luminosity) {
		System.out.println("updateLuminosity");
		luminosityEJB.updateLuminosity(luminosity);
	}

	@DELETE
	@Path("/del")
	public void delete(@QueryParam("id") long id) {
		System.out.println("deleteLuminosity");
		Luminosity luminosity = luminosityEJB.findLuminosityById(id);
		if (luminosity != null) {
			luminosityEJB.deleteLuminosity(luminosity);
		}
	}

	@GET
	@Path("/get/luminosity")
	@Consumes(MediaType.APPLICATION_XML)
	public List<Luminosity> findLuminosity() {
		System.out.println("findLuminosity");
		return luminosityEJB.findLuminosity();
	}

	@GET
	@Path("/get/sensors")
	@Consumes(MediaType.APPLICATION_XML)
	public List<Sensor> findSensorWithLuminosity() {
		System.out.println("findSensorWithLuminosity");
		return luminosityEJB.findSensorWithLuminosity();
	}
}
