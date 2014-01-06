package database;

public class Commands {
	public static String persistenceUnitName = "SensorCity";
	public static String selectAllBoards = "SELECT b FROM Board b";
	public static String selectAllTopics = "SELECT t FROM Topic t";
	public static String selectAllPosts = "SELECT p FROM Post p";
	public static String selectAllTopicsOnBoard = "SELECT t FROM Topic t WHERE t.board.idBoard = :idBoard";
	public static String selectAllPostsOnTopic = "SELECT p FROM Post p WHERE p.topic.id = :idTopic";
	public static String selectBoard = "SELECT b FROM Board b WHERE b.idBoard = :idBoard";
	public static String selectTopic = "SELECT t FROM Topic t WHERE t.id = :idTopic";
	public static String selectPost = "SELECT p FROM Post p WHERE p.id = :idPost";
	public static String idBoard = "idBoard";
	public static String idTopic = "idTopic";
	public static String idPost = "idPost";

}
