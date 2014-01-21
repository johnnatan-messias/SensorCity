package stateless;

import interfaces.AddressEJBRemote;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import kernel.AddressEntity;
import Sensors.SensorEntity;
import database.Commands;
//jax-rs
//Stateless to restfull http, websockets API
//carba
//Why we choose this design
@Stateless
@LocalBean
public class AddressEJB implements AddressEJBRemote {

	@PersistenceContext(unitName = "SensorCity", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;

	@Override
	public List<AddressEntity> findAddress() {
		Query query = em.createQuery(Commands.findAddress);
		return query.getResultList();
	}

	@Override
	public AddressEntity findAddressById(long id) {
		return em.find(AddressEntity.class, id);
	}

	@Override
	public List<AddressEntity> findAddressByStreet(String street) {
		Query query = em.createQuery(Commands.findAddressByStreet);
		query.setParameter(Commands.value, street);
		return query.getResultList();
	}

	@Override
	public AddressEntity createAddress(AddressEntity address) {
		em.persist(address);
		return address;
	}

	@Override
	public void deleteAddress(AddressEntity address) {
		em.remove(em.merge(address));
	}

	@Override
	public AddressEntity updateAddress(AddressEntity address) {
		return em.merge(address);
	}


	@Override
	public List<SensorEntity> findSensorByAddress(long id) {
		Query query = em.createQuery(Commands.findSensorByAddress);
		query.setParameter(Commands.id, id);
		return query.getResultList();
	}

}
