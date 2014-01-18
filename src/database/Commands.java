package database;

public class Commands {
	public static String id = "id";

	public static String persistenceUnitName = "SensorCity";

	public static String value = "value";
	public static int posGPS = 0;
	public static int posAudio = 1;
	public static int posHumidity = 2;
	public static int posAtmPressure = 3;
	public static int posLuminosity = 4;
	public static int posTemperature = 5;

	// AddressEntity
	public static String findAddress = "SELECT a FROM AddressEntity a";
	public static String findAddressByStreet = "SELECT a FROM AddressEntity a WHERE a.street = :value";
	public static String findUsersByAddress = "SELECT u FROM UsersEntity u WHERE u.address_id = :value";
	public static String findSensorByAddress = "SELECT s FROM SensorEntity s WHERE s.address_id = :value";

	// Comment
	public static String findComments = "SELECT c FROM Comment c";
	public static String findCommentByUser = "SELECT c FROM Comment c WHERE c.owner_id = :value";
	public static String findUserByComment = "SELECT u FROM UsersEntity u, Comment c WHERE u.id = c.owner_id AND c.owner_id = :value";

	// UsersEntity
	public static String findUsers = "SELECT u FROM UsersEntity u";
	public static String findUsersByDocument = "SELECT u FROM UsersEntity u WHERE u.document = :value";
	public static String findCommentByUsers = "SELECT c FROM Comment c, UsersEntity u WHERE c.owner_id = :value";

	// Sensors
	public static String findSensor = "SELECT s FROM SensorEntity s";
	public static String findSensorByName = "SELECT s FROM SensorEntity s WHERE s.name = :value";
	public static String findFunctionalitiesGPS = "SELECT COUNT(g.id) FROM GPSEntity g WHERE g.id = :id";
	public static String findFunctionalitiesAudio = "SELECT COUNT(a.id) FROM AudioEntity a WHERE a.id = :id";
	public static String findFunctionalitiesHumidity = "SELECT COUNT(h.id) FROM HumidityEntity h WHERE h.id = :id";
	public static String findFunctionalitiesAtmPressure = "SELECT COUNT(a.id) FROM AtmPressureEntity a WHERE a.id = :id";
	public static String findFunctionalitiesLuminosity = "SELECT COUNT(l.id) FROM LuminosityEntity l WHERE l.id = :id";
	public static String findFunctionalitiesTemperature = "SELECT COUNT(t.id) FROM TemperatureEntity t WHERE t.id = :id";
	

	// AtmPressureEntity
	public static String findAtmPressure = "SELECT a FROM AtmPressureEntity a";
	public static String findSensorWithAtmPressure = "SELECT s FROM SensorEntity s, AtmPressureEntity a WHERE s.id = a.id";

	// AudioEntity
	public static String findAudio = "SELECT a FROM AudioEntity a";
	public static String findSensorWithAudio = "SELECT s FROM SensorEntity s, AudioEntity a WHERE s.id = a.id";

	// GPSEntity
	public static String findGPS = "SELECT g FROM GPSEntity g";
	public static String findSensorWithGPS = "SELECT s FROM SensorEntity s, GPSEntity g WHERE s.id = g.id";

	// HumidityEntity
	public static String findHumidity = "SELECT h FROM HumidityEntity h";
	public static String findSensorWithHumidity = "SELECT s FROM SensorEntity s, HumidityEntity h WHERE s.id = h.id";

	// LuminosityEntity
	public static String findLuminosity = "SELECT l FROM LuminosityEntity l";
	public static String findSensorWithLuminosity = "SELECT s FROM SensorEntity s, LuminosityEntity l WHERE s.id = l.id";

	// TemperatureEntity
	public static String findTemperature = "SELECT t FROM TemperatureEntity t";
	public static String findSensorWithTemperature = "SELECT s FROM SensorEntity s, TemperatureEntity t WHERE s.id = t.id";

	public static String selectUser = "SELECT u FROM UsersEntity WHERE u.id = :value";
	public static String selectAddress = "SELECT a FROM AddressEntity WHERE a.id = :value";
	public static String selectComment = "SELECT c FROM Comment WHERE c.id = :value";
	public static String selectSensor = "SELECT s FROM SensorEntity WHERE s.id = :value";
	public static String selectGPS = "SELECT g FROM GPSEntity WHERE g.id = :value";
	public static String selectAudio = "SELECT a FROM AudioEntity WHERE a.id = :value";
	public static String selectHumidity = "SELECT h FROM HumidityEntity WHERE h.id = :value";
	public static String selectAtmPressure = "SELECT a FROM AtmPressureEntity WHERE a.id = :value";
	public static String selectLuminosity = "SELECT l FROM LuminosityEntity WHERE l.id = :value";
	public static String selectTemperature = "SELECT t FROM TemperatureEntity WHERE t.id = :value";

	public static String selectAllTopicsOnBoard = "SELECT t FROM Topic t WHERE t.board.idBoard = :value";
	public static String selectAllPostsOnTopic = "SELECT p FROM Post p WHERE p.topic.id = :value";

	public static String selectAddressUser = "SELECT a FROM AddressEntity a, UsersEntity u WHERE u.address = a.id AND u.id = :value";

}
