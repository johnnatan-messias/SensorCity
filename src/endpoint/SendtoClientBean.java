package endpoint;

import interfaces.AtmPressureEJBRemote;
import interfaces.AudioEJBRemote;
import interfaces.HumidityEJBRemote;
import interfaces.LuminosityEJBRemote;
import interfaces.TemperatureEJBRemote;

import java.util.Random;
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

import Sensors.TemperatureEntity;
import data.Luminosity;
import stateless.AtmPressureEJB;

@Startup
@Singleton
public class SendtoClientBean {
	/* Use the container's timer service */
	@Resource
	TimerService tservice;
	private Random random;
	private volatile double audio = 0;
	private volatile double atmPressure = 0;
	private volatile double humidity = 0;
	private volatile double luminosity = 0;
	private volatile double temperature = 0;
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

	@PostConstruct
	public void init() {
		/* Intialize the EJB and create a timer */
		logger.log(Level.INFO, "Initializing EJB.");
		random = new Random();
		tservice.createIntervalTimer(1000, 5000, new TimerConfig());
	}

	@Timeout
	public void timeout() {
		// audio=audioEJB.findAudioById(1).getValue();
		// humidity=humidityEJB.findHumidityById(1).getValue();
		// atmPressure=atmPressureEJB.findAtmPressureById(1).getValue();
		// luminosity = luminosityEJB.findLuminosityById(1).getValue();
		// temperature = temperatureEJB.findTemperatureById(1).getValue();
		// System.out.println(audioEJB.findAudioById(2).getValue());
		temperature = 0;
		TemperatureEntity t = temperatureEJB.findTemperatureById(1);
		if (t != null)
			temperature = temperatureEJB.findTemperatureById(1).getValue();

		System.out.println(temperature);
		audio += 1.0 * (random.nextInt(100) - 50) / 100.0;
		humidity += random.nextInt(5000) - 2500;
		atmPressure += random.nextInt(5000) - 2500;
		luminosity += random.nextInt(5000) - 2500;
		//temperature += random.nextInt(5000) - 2500;
		SensorEndpoint.send(audio, atmPressure, humidity, luminosity,
				temperature);
	}
}
