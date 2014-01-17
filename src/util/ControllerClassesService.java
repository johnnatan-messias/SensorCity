package util;

import kernel.Address;
import kernel.Users;
import Sensors.AtmPressure;
import Sensors.GPS;
import Sensors.Humidity;
import Sensors.Luminosity;
import Sensors.Sensor;
import Sensors.Temperature;
import data.AddressData;
import data.AtmPressureData;
import data.AudioData;
import data.GPSData;
import data.HumidityData;
import data.LuminosityData;
import data.SensorData;
import data.TemperatureData;
import data.UsersData;

public class ControllerClassesService {
	
	public static Temperature toTemperature(TemperatureData temperatureData){
		Temperature t = new Temperature();
		t.setId(temperatureData.getId());
		t.setValue(temperatureData.getValue());
		return t;
		
	}
	
	public static TemperatureData toTemperatureData(Temperature temperature){
		TemperatureData t = new TemperatureData();
		t.setId(temperature.getId());
		t.setValue(temperature.getValue());
		return t;
		
	}
	
	/*
	public static Users userData(UsersData user) {
		Users u = new Users();

		a.set
		u.setAddress(address);
		u.setAge(user.getAge());
		

	}

	public static Address addressData(AddressData address) {
		
		Address a = new Address();
		a.setAp(address.getAp());
		a.setCity(a.getCity());
		a.setCountry(address.getCountry());
		a.setId(address.getId());
		a.setNeighbour(address.getNeighbour());
		a.setNum(address.getNum());
		a.setSensors(address.getSensors());
		

	}

	public static Sensor sensorData(SensorData sensor) {

	}

	public static AtmPressure atmPressureData(AtmPressureData atmPressure) {

	}

	public static GPS gpsData(GPSData gps) {

	}

	public static Humidity humidityData(HumidityData humidity) {

	}

	public static Luminosity LuminosityData(LuminosityData luminosity) {

	}

	public static Temperature temperaturaData(AudioData audio) {

	}
*/
}
