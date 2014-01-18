package services;

import interfaces.AddressEJBRemote;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import Sensors.SensorEntity;
import kernel.AddressEntity;
import kernel.UsersEntity;
import data.Address;
import data.Sensor;
import data.Users;

@Path("/address")
@Produces(MediaType.APPLICATION_XML)
public class AddressService {
	@EJB
	AddressEJBRemote addressEJB;

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public void create(Address address) {
		System.out.println("createAddress");
		addressEJB.createAddress(address.toAddress());
	}

	@GET
	@Path("/get")
	@Consumes(MediaType.APPLICATION_XML)
	public Address read(@QueryParam("id") long id) {
		System.out.println("readAddress");
		return addressEJB.findAddressById(id).toAddressData();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public void update(Address address) {
		System.out.println("updateAddress");
		addressEJB.updateAddress(address.toAddress());
	}

	@DELETE
	@Path("/del")
	public void delete(@QueryParam("id") long id) {
		System.out.println("deleteAddress");
		AddressEntity address = addressEJB.findAddressById(id);
		if (address != null) {
			addressEJB.deleteAddress(address);
		}
	}

	@GET
	@Path("/get/addresses")
	@Consumes(MediaType.APPLICATION_XML)
	public List<Address> findAddresses() {
		System.out.println("findAddresses");
		List<AddressEntity> addresses = addressEJB.findAddress();
		List<Address> lAddresses = new ArrayList<Address>();
		for (AddressEntity address : addresses) {
			lAddresses.add(address.toAddressData());
		}
		return lAddresses;
	}

	@GET
	@Path("get/bystreet")
	@Consumes(MediaType.APPLICATION_XML)
	public List<Address> findAddressByStreet(
			@QueryParam("street") String street) {
		System.out.println("findAddressByStreet");
		List<AddressEntity> addresses = addressEJB.findAddressByStreet(street);
		List<Address> lAddresses = new ArrayList<Address>();
		for (AddressEntity address : addresses) {
			lAddresses.add(address.toAddressData());
		}
		return lAddresses;
	}

	@GET
	@Path("/get/users")
	@Consumes(MediaType.APPLICATION_XML)
	public List<Users> findUsersByAddress(@QueryParam("id") long id) {
		System.out.println("findUsersByAddress");
		List<UsersEntity> users = addressEJB.findUsersByAddress(id);
		List<Users> lUsers = new ArrayList<Users>();
		for (UsersEntity user : users) {
			lUsers.add(user.toUserData());
		}
		return lUsers;
	}

	@GET
	@Path("/get/sensors")
	@Consumes(MediaType.APPLICATION_XML)
	public List<Sensor> findSensorByAddress(@QueryParam("id") long id) {
		System.out.println("findSensorByAddress");
		List<SensorEntity> sensors = addressEJB.findSensorByAddress(id);
		List<Sensor> lSensors = new ArrayList<Sensor>();
		for (SensorEntity sensor : sensors) {
			lSensors.add(sensor.toSensorData());
		}
		return lSensors;
	}
}
