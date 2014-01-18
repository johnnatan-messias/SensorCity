package stateless;

import interfaces.UsersEJBRemote;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import kernel.UsersEntity;
import database.Commands;

@Stateless
@LocalBean
public class UsersEJB implements UsersEJBRemote {

	@PersistenceContext(unitName = "SensorCity", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;

	@Override
	public List<UsersEntity> findUsers() {
		Query query = em.createQuery(Commands.findUsers);
		return query.getResultList();
	}

	@Override
	public UsersEntity findUsersById(long id) {
		return em.find(UsersEntity.class, id);
	}

	@Override
	public UsersEntity findUsersByDocument(String document) {
		Query query = em.createQuery(Commands.findUsersByDocument);
		query.setParameter(Commands.value, document);
		return (UsersEntity) query.getSingleResult();
	}

	@Override
	public UsersEntity createUsers(UsersEntity user) {
		em.persist(user);
		return user;
	}

	@Override
	public void deleteUsers(UsersEntity user) {
		em.remove(em.merge(user));
	}

	@Override
	public UsersEntity updateUsers(UsersEntity user) {
		return em.merge(user);
	}

}
