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

	// Address
	public static String findAddress = "SELECT a FROM Address a";
	public static String findAddressByStreet = "SELECT a FROM Address a WHERE a.street = :value";
	public static String findUsersByAddress = "SELECT u FROM Users u WHERE u.address_id = :value";
	public static String findSensorByAddress = "SELECT s FROM Sensor s WHERE s.address_id = :value";

	// Comment
	public static String findComments = "SELECT c FROM Comment c";
	public static String findCommentByUser = "SELECT c FROM Comment c WHERE c.owner_id = :value";
	public static String findUserByComment = "SELECT u FROM Users u, Comment c WHERE u.id = c.owner_id AND c.owner_id = :value";

	// Users
	public static String findUsers = "SELECT u FROM Users u";
	public static String findUsersByDocument = "SELECT u FROM Users u WHERE u.document = :value";
	public static String findCommentByUsers = "SELECT c FROM Comment c, Users u WHERE c.owner_id = :value";

	// Sensors
	public static String findSensor = "SELECT s FROM Sensor s";
	public static String findSensorByName = "SELECT s FROM Sensor s WHERE s.name = :value";
	public static String findFunctionalitiesGPS = "SELECT COUNT(g.id) FROM GPS g WHERE g.id = :id";
	public static String findFunctionalitiesAudio = "SELECT COUNT(a.id) FROM Audio a WHERE a.id = :id";
	public static String findFunctionalitiesHumidity = "SELECT COUNT(h.id) FROM Humidity h WHERE h.id = :id";
	public static String findFunctionalitiesAtmPressure = "SELECT COUNT(a.id) FROM AtmPressure a WHERE a.id = :id";
	public static String findFunctionalitiesLuminosity = "SELECT COUNT(l.id) FROM Luminosity l WHERE l.id = :id";
	public static String findFunctionalitiesTemperature = "SELECT COUNT(t.id) FROM Temperature t WHERE t.id = :id";
	

	// AtmPressure
	public static String findAtmPressure = "SELECT a FROM AtmPressure a";
	public static String findSensorWithAtmPressure = "SELECT s FROM Sensor s, AtmPressure a WHERE s.id = a.id";

	// Audio
	public static String findAudio = "SELECT a FROM Audio a";
	public static String findSensorWithAudio = "SELECT s FROM Sensor s, Audio a WHERE s.id = a.id";

	// GPS
	public static String findGPS = "SELECT g FROM GPS g";
	public static String findSensorWithGPS = "SELECT s FROM Sensor s, GPS g WHERE s.id = g.id";

	// Humidity
	public static String findHumidity = "SELECT h FROM Humidity h";
	public static String findSensorWithHumidity = "SELECT s FROM Sensor s, Humidity h WHERE s.id = h.id";

	// Luminosity
	public static String findLuminosity = "SELECT l FROM Luminosity l";
	public static String findSensorWithLuminosity = "SELECT s FROM Sensor s, Luminosity l WHERE s.id = l.id";

	// Temperature
	public static String findTemperature = "SELECT t FROM Temperature t";
	public static String findSensorWithTemperature = "SELECT s FROM Sensor s, Temperature t WHERE s.id = t.id";

	public static String selectUser = "SELECT u FROM Users WHERE u.id = :value";
	public static String selectAddress = "SELECT a FROM Address WHERE a.id = :value";
	public static String selectComment = "SELECT c FROM Comment WHERE c.id = :value";
	public static String selectSensor = "SELECT s FROM Sensor WHERE s.id = :value";
	public static String selectGPS = "SELECT g FROM GPS WHERE g.id = :value";
	public static String selectAudio = "SELECT a FROM Audio WHERE a.id = :value";
	public static String selectHumidity = "SELECT h FROM Humidity WHERE h.id = :value";
	public static String selectAtmPressure = "SELECT a FROM AtmPressure WHERE a.id = :value";
	public static String selectLuminosity = "SELECT l FROM Luminosity WHERE l.id = :value";
	public static String selectTemperature = "SELECT t FROM Temperature WHERE t.id = :value";

	public static String selectAllTopicsOnBoard = "SELECT t FROM Topic t WHERE t.board.idBoard = :value";
	public static String selectAllPostsOnTopic = "SELECT p FROM Post p WHERE p.topic.id = :value";

	public static String selectAddressUser = "SELECT a FROM Address a, User u WHERE u.address = a.id AND u.id = :value";

}
