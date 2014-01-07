package database;

public class Commands {
	public static String id = "id";
	public static String persistenceUnitName = "SensorCity";
	public static String selectAllSensors = "SELECT s FROM Sensor s";
	public static String selectAllUsers = "SELECT u FROM Users u";
	public static String selectAllAddress = "SELECT a FROM Address a";
	public static String selectAllGPS = "SELECT g FROM GPS g";
	public static String selectAllAudio = "SELECT a FROM Audio a";
	public static String selectAllHumidity = "SELECT h FROM Humidity h";
	public static String selectAllAtmPressure = "SELECT a FROM AtmPressure a";
	public static String selectAllLuminosity = "SELECT l FROM Luminosity l";
	public static String selectAllTemperature = "SELECT t FROM Temperature t";
	
	
	
	
	public static String selectAllTopicsOnBoard = "SELECT t FROM Topic t WHERE t.board.idBoard = :idBoard";
	public static String selectAllPostsOnTopic = "SELECT p FROM Post p WHERE p.topic.id = :idTopic";
	public static String selectBoard = "SELECT b FROM Board b WHERE b.idBoard = :idBoard";
	public static String selectTopic = "SELECT t FROM Topic t WHERE t.id = :idTopic";
	public static String selectPost = "SELECT p FROM Post p WHERE p.id = :idPost";
	public static String idBoard = "idBoard";
	public static String idTopic = "idTopic";
	public static String idPost = "idPost";

}
