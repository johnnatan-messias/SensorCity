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

import Sensors.Humidity;
import Sensors.Sensor;
import data.HumidityData;
import data.SensorData;

@Path("/sensor/type/humidity")
@Produces(MediaType.APPLICATION_XML)
public class HumidityService {

	@EJB
	HumidityEJBRemote humidityEJB;

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public void create(HumidityData humidity) {
		System.out.println("createHumidity");
		humidityEJB.createHumidity(humidity.toHumidity());
	}

	@GET
	@Path("/get")
	@Consumes(MediaType.APPLICATION_XML)
	public HumidityData read(@QueryParam("id") long id) {
		System.out.println("readHumidity");
		return humidityEJB.findHumidityById(id).toHumidityData();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public void update(HumidityData humidity) {
		System.out.println("updateHumidity");
		humidityEJB.updateHumidity(humidity.toHumidity());
	}

	@DELETE
	@Path("/del")
	public void delete(@QueryParam("id") long id) {
		System.out.println("deleteHumidity");
		Humidity humidity = humidityEJB.findHumidityById(id);
		if (humidity != null) {
			humidityEJB.deleteHumidity(humidity);
		}
	}

	@GET
	@Path("/get/humidity")
	@Consumes(MediaType.APPLICATION_XML)
	public List<HumidityData> findHumidity() {
		System.out.println("findHumidity");
		List<Humidity> humiditys = humidityEJB.findHumidity();
		List<HumidityData> lHumiditys = new ArrayList<HumidityData>();
		for (Humidity humidity : humiditys) {
			lHumiditys.add(humidity.toHumidityData());
		}
		return lHumiditys;
	}

	@GET
	@Path("/get/sensors")
	@Consumes(MediaType.APPLICATION_XML)
	public List<SensorData> findSensorWithHumidity() {
		System.out.println("findSensorWithHumidity");
		List<Sensor> sensors = humidityEJB.findSensorWithHumidity();
		List<SensorData> lSensors = new ArrayList<SensorData>();
		for (Sensor sensor : sensors) {
			lSensors.add(sensor.toSensorData());
		}
		return lSensors;
	}
}
