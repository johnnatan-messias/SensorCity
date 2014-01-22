package endpoint;

import interfaces.AtmPressureEJBRemote;
import interfaces.AudioEJBRemote;
import interfaces.HumidityEJBRemote;
import interfaces.LuminosityEJBRemote;
import interfaces.SensorEJBRemote;
import interfaces.TemperatureEJBRemote;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;

import Sensors.AtmPressureEntity;
import Sensors.AudioEntity;
import Sensors.HumidityEntity;
import Sensors.LuminosityEntity;
import Sensors.SensorEntity;
import Sensors.TemperatureEntity;

@Startup
@Singleton
public class SendtoClientBean {
	/* Use the container's timer service */
	@Resource
	TimerService tservice;

	private static final Logger logger = Logger.getLogger("SendtoClientBean",
			null);
	@EJB
	AudioEJBRemote audioEJB;
	@EJB
	HumidityEJBRemote humidityEJB;
	@EJB
	AtmPressureEJBRemote atmPressureEJB;
	@EJB
	LuminosityEJBRemote luminosityEJB;
	@EJB
	TemperatureEJBRemote temperatureEJB;
	@EJB
	SensorEJBRemote sensorEJB;

	@PostConstruct
	public void init() {
		/* Intialize the EJB and create a timer */
		logger.log(Level.INFO, "Initializing EJB.");
		tservice.createIntervalTimer(1000, 5000, new TimerConfig());
	}

	@Timeout
	public void timeout() {
		double audio = 0;
		double humidity = 0;
		double atmPressure = 0;
		double luminosity = 0;
		double temperature = 0;
		String timestamp = null;
		AudioEntity audioEntity = audioEJB.findAudioById(1);
		if (audioEntity != null)
			audio = audioEntity.getValue();
		System.out.println(audio);

		HumidityEntity humidityEntity = humidityEJB.findHumidityById(1);
		if (humidityEntity != null)
			humidity = humidityEntity.getValue();
		System.out.println(humidity);

		AtmPressureEntity atmPressureEntity = atmPressureEJB
				.findAtmPressureById(1);
		if (atmPressureEntity != null)
			atmPressure = atmPressureEntity.getValue();
		System.out.println(atmPressure);

		LuminosityEntity luminosityEntity = luminosityEJB.findLuminosityById(1);
		if (luminosityEntity != null)
			luminosity = luminosityEntity.getValue();
		System.out.println(temperature);

		TemperatureEntity temperatureEntity = temperatureEJB
				.findTemperatureById(1);
		if (temperatureEntity != null)
			temperature = temperatureEntity.getValue();
		System.out.println(temperature);

		SensorEntity sensorEntity = sensorEJB.findSensorById(1);
		if (sensorEntity != null)
			timestamp = sensorEntity.getTimestamp().toLocaleString();
		System.out.println(timestamp);

		// audio += 1.0 * (random.nextInt(100) - 50) / 100.0;
		// humidity += random.nextInt(5000) - 2500;
		// atmPressure += random.nextInt(5000) - 2500;
		// luminosity += random.nextInt(5000) - 2500;
		// //temperature += random.nextInt(5000) - 2500;
		SensorEndpoint.send(audio, atmPressure, humidity, luminosity,
				temperature, timestamp);
	}
}
