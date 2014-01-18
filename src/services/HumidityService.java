package services;

import interfaces.HumidityEJBRemote;

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

import Sensors.HumidityEntity;
import Sensors.SensorEntity;
import data.Humidity;
import data.Sensor;

@Path("/sensor/type/humidity")
@Produces(MediaType.APPLICATION_XML)
public class HumidityService {

	@EJB
	HumidityEJBRemote humidityEJB;

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public void create(Humidity humidity) {
		System.out.println("createHumidity");
		humidityEJB.createHumidity(humidity.toHumidity());
	}

	@GET
	@Path("/get")
	@Consumes(MediaType.APPLICATION_XML)
	public Humidity read(@QueryParam("id") long id) {
		System.out.println("readHumidity");
		return humidityEJB.findHumidityById(id).toHumidityData();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public void update(Humidity humidity) {
		System.out.println("updateHumidity");
		humidityEJB.updateHumidity(humidity.toHumidity());
	}

	@DELETE
	@Path("/del")
	public void delete(@QueryParam("id") long id) {
		System.out.println("deleteHumidity");
		HumidityEntity humidity = humidityEJB.findHumidityById(id);
		if (humidity != null) {
			humidityEJB.deleteHumidity(humidity);
		}
	}

	@GET
	@Path("/get/humidity")
	@Consumes(MediaType.APPLICATION_XML)
	public List<Humidity> findHumidity() {
		System.out.println("findHumidity");
		List<HumidityEntity> humiditys = humidityEJB.findHumidity();
		List<Humidity> lHumiditys = new ArrayList<Humidity>();
		for (HumidityEntity humidity : humiditys) {
			lHumiditys.add(humidity.toHumidityData());
		}
		return lHumiditys;
	}

	@GET
	@Path("/get/sensors")
	@Consumes(MediaType.APPLICATION_XML)
	public List<Sensor> findSensorWithHumidity() {
		System.out.println("findSensorWithHumidity");
		List<SensorEntity> sensors = humidityEJB.findSensorWithHumidity();
		List<Sensor> lSensors = new ArrayList<Sensor>();
		for (SensorEntity sensor : sensors) {
			lSensors.add(sensor.toSensorData());
		}
		return lSensors;
	}
}
