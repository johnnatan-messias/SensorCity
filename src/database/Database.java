package database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import kernel.Address;
import kernel.Users;
import Sensors.AtmPressure;
import Sensors.Audio;
import Sensors.GPS;
import Sensors.Humidity;
import Sensors.Luminosity;
import Sensors.Sensor;
import Sensors.Temperature;

public class Database {
	/* I need to check if delete methods are ok */
	/* I have problems with insertion topic and post */

	private static Database db = null;
	private EntityManagerFactory emf = null;

	private Database() {
		emf = Persistence
				.createEntityManagerFactory(Commands.persistenceUnitName);
	}

	public static Database getInstance() {
		if (db == null) {
			db = new Database();
		}
		return db;
	}

	public int insertUser(Users user) {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return user.getId();
	}

	public int insertAddress(Address address) {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(address);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return address.getId();
	}

	public void insertAddress(Sensor sensor) {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(sensor);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public void insertGPS(GPS gps) {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(gps);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public void insertAudio(Audio audio) {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(audio);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public void insertHumidity(Humidity humidity) {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(humidity);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public void insertAtmPressure(AtmPressure atmPressure) {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(atmPressure);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public void insertLuminosity(Luminosity luminosity) {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(luminosity);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public void insertTemperature(Temperature temperature) {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(temperature);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public Users selectUser(int idUser) {
		Users user = null;
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			user = em.find(Users.class, idUser);
			if (user == null) {
				System.out.println("There's no user on Users");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			em.close();
		}
		return user;
	}

	public Address selectAddress(int idAddress) {
		Address address = null;
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			address = em.find(Address.class, idAddress);
			if (address == null) {
				System.out.println("There's no address on Address");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			em.close();
		}
		return address;
	}

	public Sensor selectSensor(int idSensor) {
		Sensor sensor = null;
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			sensor = em.find(Sensor.class, idSensor);
			if (sensor == null) {
				System.out.println("There's no sensor on Sensor");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			em.close();
		}
		return sensor;
	}

	public GPS selectGPS(int idGPS) {
		GPS gps = null;
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			gps = em.find(GPS.class, idGPS);
			if (gps == null) {
				System.out.println("There's no gps on GPS");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			em.close();
		}
		return gps;
	}

	public Audio selectAudio(int idAudio) {
		Audio audio = null;
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			audio = em.find(Audio.class, idAudio);
			if (audio == null) {
				System.out.println("There's no audio on Audio");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			em.close();
		}
		return audio;
	}

	public Humidity selectHumidity(int idHumidity) {
		Humidity humidity = null;
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			humidity = em.find(Humidity.class, idHumidity);
			if (humidity == null) {
				System.out.println("There's no humidity on Humidity");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			em.close();
		}
		return humidity;
	}

	public AtmPressure selectAtmPressure(int idAtmPressure) {
		AtmPressure atmPressure = null;
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			atmPressure = em.find(AtmPressure.class, idAtmPressure);
			if (atmPressure == null) {
				System.out.println("There's no atmPressure on AtmPressure");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			em.close();
		}
		return atmPressure;
	}

	public Luminosity selectLuminosity(int idLuminosity) {
		Luminosity luminosity = null;
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			luminosity = em.find(Luminosity.class, idLuminosity);
			if (luminosity == null) {
				System.out.println("There's no luminosity on Luminosity");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			em.close();
		}
		return luminosity;
	}

	public Temperature selectTemperature(int idTemperature) {
		Temperature temperature = null;
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			temperature = em.find(Temperature.class, idTemperature);
			if (temperature == null) {
				System.out.println("There's no temperature on Temperature");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			em.close();
		}
		return temperature;
	}

	/*
	 * public int insertBoard(String nameBoard) { Board board = null;
	 * EntityManager em = null; try { em = emf.createEntityManager();
	 * em.getTransaction().begin(); board = new Board();
	 * board.setNameBoard(nameBoard); em.persist(board);
	 * em.getTransaction().commit(); } catch (Exception e) {
	 * System.err.println(e.getMessage()); } finally { em.close(); } return
	 * board.getIdBoard(); }
	 * 
	 * public Topic insertTopic(Board board, String nameTopic) { Topic topic =
	 * null; EntityManager em = null; try { em = emf.createEntityManager();
	 * em.getTransaction().begin(); topic = new Topic();
	 * topic.setName(nameTopic); topic.setDate(DateUtil.getLocalDate());
	 * board.getTopics().add(topic); topic.setBoard(board); em.persist(topic);
	 * em.getTransaction().commit(); } catch (Exception e) {
	 * System.err.println(e.getMessage()); } finally { em.close(); } return
	 * topic; }
	 * 
	 * public Post insertPost(Topic topic, String author, String message) { Post
	 * post = null; EntityManager em = null; try { em =
	 * emf.createEntityManager(); em.getTransaction().begin(); post = new
	 * Post(); post.setAuthor(author); post.setMessage(message);
	 * post.setPosted(DateUtil.getLocalDate()); topic.getPosts().add(post);
	 * post.setTopic(topic); em.persist(post); em.getTransaction().commit(); }
	 * catch (Exception e) { System.err.println(e.getMessage()); } finally {
	 * em.close(); } return post; }
	 * 
	 * public void updateBoard(int id, String name) { Board board = null;
	 * EntityManager em = null; try { em = emf.createEntityManager();
	 * em.getTransaction().begin(); board = em.find(Board.class, id); if (board
	 * == null) { throw new NotFoundException("The Board " + id +
	 * " was not found!"); } board.setNameBoard(name);
	 * em.getTransaction().commit(); } catch (Exception e) {
	 * System.err.println(e.getMessage()); } finally { em.close(); } }
	 * 
	 * public void updateTopic(int id, String name) { Topic topic = null;
	 * EntityManager em = null; try { em = emf.createEntityManager();
	 * em.getTransaction().begin(); topic = em.find(Topic.class, id); if (topic
	 * == null) { throw new NotFoundException("The Topic " + id +
	 * " was not found!"); } topic.setName(name); em.getTransaction().commit();
	 * } catch (Exception e) { System.err.println(e.getMessage()); } finally {
	 * em.close(); } }
	 * 
	 * public void updatePost(int id, String message) { Post post = null;
	 * EntityManager em = null; try { em = emf.createEntityManager();
	 * em.getTransaction().begin(); post = em.find(Post.class, id); if (post ==
	 * null) { throw new NotFoundException("The Post " + id +
	 * " was not found!"); } post.setMessage(message);
	 * em.getTransaction().commit(); } catch (Exception e) {
	 * System.err.println(e.getMessage()); } finally { em.close(); } }
	 * 
	 * public void deleteBoard(int id) { Board board = null; EntityManager em =
	 * null; try { em = emf.createEntityManager(); em.getTransaction().begin();
	 * board = em.find(Board.class, id); if (board == null) { throw new
	 * NotFoundException("The Board " + id + " was not found!"); }
	 * em.remove(board); em.getTransaction().commit(); } catch (Exception e) {
	 * System.err.println(e.getMessage()); } finally { em.close(); } }
	 * 
	 * public void deleteTopic(int id) { Topic topic = null; EntityManager em =
	 * null; try { em = emf.createEntityManager(); em.getTransaction().begin();
	 * topic = em.find(Topic.class, id); if (topic == null) { throw new
	 * NotFoundException("The Topic " + id + " was not found!"); }
	 * em.remove(topic); em.getTransaction().commit(); } catch (Exception e) {
	 * System.err.println(e.getMessage()); } finally { em.close(); } }
	 * 
	 * public void deletePost(int id) { Post post = null; EntityManager em =
	 * null; try { em = emf.createEntityManager(); em.getTransaction().begin();
	 * post = em.find(Post.class, id); if (post == null) { throw new
	 * NotFoundException("The Post " + id + " was not found!"); }
	 * em.remove(post); em.getTransaction().commit(); } catch (Exception e) {
	 * System.err.println(e.getMessage()); } finally { em.close(); } }
	 * 
	 * public List<Board> selectAllBoards() { List<Board> boards = null;
	 * EntityManager em = null; try { em = emf.createEntityManager();
	 * em.getTransaction().begin(); Query q =
	 * em.createQuery(Commands.selectAllBoards); boards = q.getResultList(); if
	 * (boards.size() == 0) { System.out.println("There's not board on Board");
	 * } } catch (Exception e) { System.err.println(e.getMessage()); } finally {
	 * em.close(); } return boards; }
	 * 
	 * public List<Topic> selectAllTopics() { List<Topic> topics = null;
	 * EntityManager em = null; try { em = emf.createEntityManager();
	 * em.getTransaction().begin(); Query q =
	 * em.createQuery(Commands.selectAllTopics); topics = q.getResultList(); if
	 * (topics.size() == 0) { System.out.println("There's no topic on Topics");
	 * } } catch (Exception e) { System.err.println(e.getMessage()); } finally {
	 * em.close(); } return topics; }
	 * 
	 * public List<Post> selectAllPosts() { List<Post> posts = null;
	 * EntityManager em = null; try { em = emf.createEntityManager();
	 * em.getTransaction().begin(); Query q =
	 * em.createQuery(Commands.selectAllPosts); posts = q.getResultList(); if
	 * (posts.size() == 0) { System.out.println("There's no post on Post"); } }
	 * catch (Exception e) { System.err.println(e.getMessage()); } finally {
	 * em.close(); } return posts; }
	 * 
	 * public List<Topic> selectAllTopicsOnBoard(int idBoard) { List<Topic>
	 * topics = null; EntityManager em = null; try { em =
	 * emf.createEntityManager(); em.getTransaction().begin(); Query q =
	 * em.createQuery(Commands.selectAllTopicsOnBoard);
	 * q.setParameter(Commands.idBoard, idBoard); topics = q.getResultList(); if
	 * (topics.size() == 0) { System.out.println("There's no topic on Topic"); }
	 * } catch (Exception e) { System.err.println(e.getMessage()); } finally {
	 * em.close(); } return topics; }
	 * 
	 * public List<Post> selectAllPostsOnTopic(int idTopic) { List<Post> posts =
	 * null; EntityManager em = null; try { em = emf.createEntityManager();
	 * em.getTransaction().begin(); Query q =
	 * em.createQuery(Commands.selectAllPostsOnTopic);
	 * q.setParameter(Commands.idTopic, idTopic); posts = q.getResultList(); if
	 * (posts.size() == 0) { System.out.println("There's no post on Post"); } }
	 * catch (Exception e) { System.out.println(e.getMessage()); } finally {
	 * em.close(); } return posts; }
	 * 
	 * public Board selectBoard(int idBoard) { Board board = null; EntityManager
	 * em = null; try { em = emf.createEntityManager();
	 * em.getTransaction().begin(); board = em.find(Board.class, idBoard); if
	 * (board == null) { System.out.println("There's no board on Board"); } }
	 * catch (Exception e) { System.err.println(e.getMessage()); } finally {
	 * em.close(); } return board; }
	 * 
	 * public Topic selectTopic(int idTopic) { Topic topic = null; EntityManager
	 * em = null; try { em = emf.createEntityManager();
	 * em.getTransaction().begin(); topic = em.find(Topic.class, idTopic); if
	 * (topic == null) { System.out.println("There's no topic on Topic"); } }
	 * catch (Exception e) { System.err.println(e.getMessage()); } finally {
	 * em.close(); } return topic; }
	 * 
	 * public Post selectPost(int idPost) { Post post = null; EntityManager em =
	 * null; try { em = emf.createEntityManager(); em.getTransaction().begin();
	 * post = em.find(Post.class, idPost); if (post == null) {
	 * System.out.println("There's no post on Post"); } } catch (Exception e) {
	 * System.err.println(e.getMessage()); } finally { em.close(); } return
	 * post; }
	 */
}
