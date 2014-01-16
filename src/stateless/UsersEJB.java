package stateless;

import interfaces.UsersEJBRemote;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import kernel.Users;
import database.Commands;

@Stateless
@LocalBean
@WebService
@Named
public class UsersEJB implements UsersEJBRemote {

	@PersistenceContext(unitName = "SensorCity")
	private EntityManager em;

	@Override
	public List<Users> findUsers() {
		Query query = em.createQuery(Commands.findUsers);
		return query.getResultList();
	}

	@Override
	public Users findUsersById(int id) {
		return em.find(Users.class, id);
	}

	@Override
	public Users findUsersByDocument(String document) {
		Query query = em.createQuery(Commands.findUsersByDocument);
		query.setParameter(Commands.value, document);
		return (Users) query.getSingleResult();
	}

	@Override
	public Users createUsers(Users user) {
		em.persist(user);
		return user;
	}

	@Override
	public void deleteUsers(Users user) {
		em.remove(em.merge(user));
	}

	@Override
	public Users updateUsers(Users user) {
		return em.merge(user);
	}

}