package database;

public class Commands {
	public static String id = "id";
	
	public static String persistenceUnitName = "SensorCity";
	public static String selectAllSensors = "SELECT s FROM Sensor s";
	public static String selectAllUsers = "SELECT u FROM Users u";
	public static String selectAllAddress = "SELECT a FROM Address a";
	public static String selectAllComments = "SELECT c FROM Comment c";
	public static String selectAllGPS = "SELECT g FROM GPS g";
	public static String selectAllAudio = "SELECT a FROM Audio a";
	public static String selectAllHumidity = "SELECT h FROM Humidity h";
	public static String selectAllAtmPressure = "SELECT a FROM AtmPressure a";
	public static String selectAllLuminosity = "SELECT l FROM Luminosity l";
	public static String selectAllTemperature = "SELECT t FROM Temperature t";

	
	public static String selectUser = "SELECT u FROM Users WHERE u.id = :id";
	public static String selectAddress = "SELECT a FROM Address WHERE a.id = :id";
	public static String selectComment = "SELECT c FROM Comment WHERE c.id = :id";
	public static String selectSensor = "SELECT s FROM Sensor WHERE s.id = :id";
	public static String selectGPS = "SELECT g FROM GPS WHERE g.id = :id";
	public static String selectAudio = "SELECT a FROM Audio WHERE a.id = :id";
	public static String selectHumidity = "SELECT h FROM Humidity WHERE h.id = :id";
	public static String selectAtmPressure = "SELECT a FROM AtmPressure WHERE a.id = :id";
	public static String selectLuminosity = "SELECT l FROM Luminosity WHERE l.id = :id";
	public static String selectTemperature = "SELECT t FROM Temperature WHERE t.id = :id";
	
	
	
	
	public static String selectAllTopicsOnBoard = "SELECT t FROM Topic t WHERE t.board.idBoard = :idBoard";
	public static String selectAllPostsOnTopic = "SELECT p FROM Post p WHERE p.topic.id = :idTopic";

	public static String selectAddressUser = "SELECT a FROM Address a, User u WHERE u.address = a.id AND u.id = :idUser";
	

}
