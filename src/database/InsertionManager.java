package database;

import interfaces.AddressEJBRemote;
import interfaces.AtmPressureEJBRemote;
import interfaces.AudioEJBRemote;
import interfaces.GPSEJBRemote;
import interfaces.HumidityEJBRemote;
import interfaces.LuminosityEJBRemote;
import interfaces.SensorEJBRemote;
import interfaces.TemperatureEJBRemote;
import interfaces.UsersEJBRemote;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.ejb.EJB;

import stateless.SensorEJB;
import Sensors.AtmPressureEntity;
import Sensors.AudioEntity;
import Sensors.HumidityEntity;
import Sensors.LuminosityEntity;
import Sensors.SensorEntity;
import Sensors.TemperatureEntity;

public class InsertionManager {
	@EJB
	private static AddressEJBRemote addressEJB;
	@EJB
	private static AtmPressureEJBRemote atmPressureEJB;
	@EJB
	private static AudioEJBRemote audioEJB;
	@EJB
	private static GPSEJBRemote GPSEJB;
	@EJB
	private static HumidityEJBRemote humidityEJB;
	@EJB
	private static LuminosityEJBRemote luminosityEJB;
	@EJB
	private static SensorEJBRemote sensorEJB;
	@EJB
	private static TemperatureEJBRemote temperatureEJB;
	@EJB
	private static UsersEJBRemote userEJB;

	public static void deal(String msg) throws java.text.ParseException {
		String[] instr = msg.split(";");

		if (instr[0].compareTo("s") == 0) {
			// s;idSensor;timestamp;audio;humidity;atm_press;light;temperature
			int id = Integer.valueOf(instr[1]);
			if (instr[3].compareTo("null") != 0) {
				AudioEntity audio = new AudioEntity();
				audio.setId(id);
				audio.setValue(Integer.parseInt(instr[3]));
				audioEJB.createAudio(audio);
			}
			if (instr[4].compareTo("null") != 0) {
				HumidityEntity humidity = new HumidityEntity();
				humidity.setId(id);
				humidity.setValue(Integer.parseInt(instr[4]));
				humidityEJB.createHumidity(humidity);
			}
			if (instr[5].compareTo("null") != 0) {
				AtmPressureEntity atmPressure = new AtmPressureEntity();
				atmPressure.setId(id);
				atmPressure.setValue(Integer.parseInt(instr[5]));
				atmPressureEJB.createAtmPressure(atmPressure);
			}
			if (instr[6].compareTo("null") != 0) {
				LuminosityEntity luminosity = new LuminosityEntity();
				luminosity.setId(id);
				luminosity.setValue(Integer.parseInt(instr[6]));
				luminosityEJB.createLuminosity(luminosity);
			}
			if (instr[7].compareTo("null") != 0) {
				TemperatureEntity temperature = new TemperatureEntity();
				temperature.setId(id);
				temperature.setValue(Integer.parseInt(instr[3]));
				temperatureEJB.createTemperature(temperature);
			}
			SensorEJB sensorEjb = new SensorEJB();
			SensorEntity sensor = sensorEjb
					.findSensorById(Integer.parseInt(instr[1]));

			java.sql.Date date = null;
			DateFormat formatter = new SimpleDateFormat("yyyy MM dd HH:mm:ss");
			date = new java.sql.Date(
					((java.util.Date) formatter.parse(instr[2])).getTime());
			sensor.setTimestamp(date);
			sensorEjb.updateSensor(sensor);
		}
	}
}
