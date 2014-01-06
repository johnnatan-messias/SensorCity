package database;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


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

	/*
	public int insertBoard(String nameBoard) {
		Board board = null;
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			board = new Board();
			board.setNameBoard(nameBoard);
			em.persist(board);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			em.close();
		}
		return board.getIdBoard();
	}

	public Topic insertTopic(Board board, String nameTopic) {
		Topic topic = null;
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			topic = new Topic();
			topic.setName(nameTopic);
			topic.setDate(DateUtil.getLocalDate());
			board.getTopics().add(topic);
			topic.setBoard(board);
			em.persist(topic);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			em.close();
		}
		return topic;
	}

	public Post insertPost(Topic topic, String author, String message) {
		Post post = null;
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			post = new Post();
			post.setAuthor(author);
			post.setMessage(message);
			post.setPosted(DateUtil.getLocalDate());
			topic.getPosts().add(post);
			post.setTopic(topic);
			em.persist(post);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			em.close();
		}
		return post;
	}

	public void updateBoard(int id, String name) {
		Board board = null;
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			board = em.find(Board.class, id);
			if (board == null) {
				throw new NotFoundException("The Board " + id
						+ " was not found!");
			}
			board.setNameBoard(name);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			em.close();
		}
	}

	public void updateTopic(int id, String name) {
		Topic topic = null;
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			topic = em.find(Topic.class, id);
			if (topic == null) {
				throw new NotFoundException("The Topic " + id
						+ " was not found!");
			}
			topic.setName(name);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			em.close();
		}
	}

	public void updatePost(int id, String message) {
		Post post = null;
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			post = em.find(Post.class, id);
			if (post == null) {
				throw new NotFoundException("The Post " + id
						+ " was not found!");
			}
			post.setMessage(message);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			em.close();
		}
	}

	public void deleteBoard(int id) {
		Board board = null;
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			board = em.find(Board.class, id);
			if (board == null) {
				throw new NotFoundException("The Board " + id
						+ " was not found!");
			}
			em.remove(board);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			em.close();
		}
	}

	public void deleteTopic(int id) {
		Topic topic = null;
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			topic = em.find(Topic.class, id);
			if (topic == null) {
				throw new NotFoundException("The Topic " + id
						+ " was not found!");
			}
			em.remove(topic);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			em.close();
		}
	}

	public void deletePost(int id) {
		Post post = null;
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			post = em.find(Post.class, id);
			if (post == null) {
				throw new NotFoundException("The Post " + id
						+ " was not found!");
			}
			em.remove(post);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			em.close();
		}
	}

	public List<Board> selectAllBoards() {
		List<Board> boards = null;
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Query q = em.createQuery(Commands.selectAllBoards);
			boards = q.getResultList();
			if (boards.size() == 0) {
				System.out.println("There's not board on Board");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			em.close();
		}
		return boards;
	}

	public List<Topic> selectAllTopics() {
		List<Topic> topics = null;
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Query q = em.createQuery(Commands.selectAllTopics);
			topics = q.getResultList();
			if (topics.size() == 0) {
				System.out.println("There's no topic on Topics");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			em.close();
		}
		return topics;
	}

	public List<Post> selectAllPosts() {
		List<Post> posts = null;
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Query q = em.createQuery(Commands.selectAllPosts);
			posts = q.getResultList();
			if (posts.size() == 0) {
				System.out.println("There's no post on Post");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			em.close();
		}
		return posts;
	}

	public List<Topic> selectAllTopicsOnBoard(int idBoard) {
		List<Topic> topics = null;
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Query q = em.createQuery(Commands.selectAllTopicsOnBoard);
			q.setParameter(Commands.idBoard, idBoard);
			topics = q.getResultList();
			if (topics.size() == 0) {
				System.out.println("There's no topic on Topic");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			em.close();
		}
		return topics;
	}

	public List<Post> selectAllPostsOnTopic(int idTopic) {
		List<Post> posts = null;
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Query q = em.createQuery(Commands.selectAllPostsOnTopic);
			q.setParameter(Commands.idTopic, idTopic);
			posts = q.getResultList();
			if (posts.size() == 0) {
				System.out.println("There's no post on Post");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}
		return posts;
	}

	public Board selectBoard(int idBoard) {
		Board board = null;
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			board = em.find(Board.class, idBoard);
			if (board == null) {
				System.out.println("There's no board on Board");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			em.close();
		}
		return board;
	}

	public Topic selectTopic(int idTopic) {
		Topic topic = null;
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			topic = em.find(Topic.class, idTopic);
			if (topic == null) {
				System.out.println("There's no topic on Topic");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			em.close();
		}
		return topic;
	}

	public Post selectPost(int idPost) {
		Post post = null;
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			post = em.find(Post.class, idPost);
			if (post == null) {
				System.out.println("There's no post on Post");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			em.close();
		}
		return post;
	}
*/
}
