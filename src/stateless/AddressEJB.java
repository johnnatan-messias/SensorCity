package stateless;

import interfaces.AddressEJBRemote;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import kernel.Address;
import kernel.Users;
import Sensors.Sensor;
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
	public List<Address> findAddress() {
		Query query = em.createQuery(Commands.findAddress);
		return query.getResultList();
	}

	@Override
	public Address findAddressById(long id) {
		return em.find(Address.class, id);
	}

	@Override
	public List<Address> findAddressByStreet(String street) {
		Query query = em.createQuery(Commands.findAddressByStreet);
		query.setParameter(Commands.value, street);
		return query.getResultList();
	}

	@Override
	public Address createAddress(Address address) {
		em.persist(address);
		return address;
	}

	@Override
	public void deleteAddress(Address address) {
		em.remove(em.merge(address));
	}

	@Override
	public Address updateAddress(Address address) {
		return em.merge(address);
	}

	@Override
	public List<Users> findUsersByAddress(long id) {
		Query query = em.createQuery(Commands.findUsersByAddress);
		query.setParameter(Commands.id, id);
		return query.getResultList();
	}

	@Override
	public List<Sensor> findSensorByAddress(long id) {
		Query query = em.createQuery(Commands.findSensorByAddress);
		query.setParameter(Commands.id, id);
		return query.getResultList();
	}

}
