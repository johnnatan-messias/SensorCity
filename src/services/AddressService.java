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

import Sensors.Sensor;
import kernel.Address;
import kernel.Users;
import data.AddressData;
import data.SensorData;
import data.UsersData;

@Path("/address")
@Produces(MediaType.APPLICATION_XML)
public class AddressService {
	@EJB
	AddressEJBRemote addressEJB;

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public void create(AddressData address) {
		System.out.println("createAddress");
		addressEJB.createAddress(address.toAddress());
	}

	@GET
	@Path("/get")
	@Consumes(MediaType.APPLICATION_XML)
	public AddressData read(@QueryParam("id") long id) {
		System.out.println("readAddress");
		return addressEJB.findAddressById(id).toAddressData();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public void update(AddressData address) {
		System.out.println("updateAddress");
		addressEJB.updateAddress(address.toAddress());
	}

	@DELETE
	@Path("/del")
	public void delete(@QueryParam("id") long id) {
		System.out.println("deleteAddress");
		Address address = addressEJB.findAddressById(id);
		if (address != null) {
			addressEJB.deleteAddress(address);
		}
	}

	@GET
	@Path("/get/addresses")
	@Consumes(MediaType.APPLICATION_XML)
	public List<AddressData> findAddresses() {
		System.out.println("findAddresses");
		List<Address> addresses = addressEJB.findAddress();
		List<AddressData> lAddresses = new ArrayList<AddressData>();
		for (Address address : addresses) {
			lAddresses.add(address.toAddressData());
		}
		return lAddresses;
	}

	@GET
	@Path("get/bystreet")
	@Consumes(MediaType.APPLICATION_XML)
	public List<AddressData> findAddressByStreet(
			@QueryParam("street") String street) {
		System.out.println("findAddressByStreet");
		List<Address> addresses = addressEJB.findAddressByStreet(street);
		List<AddressData> lAddresses = new ArrayList<AddressData>();
		for (Address address : addresses) {
			lAddresses.add(address.toAddressData());
		}
		return lAddresses;
	}

	@GET
	@Path("/get/users")
	@Consumes(MediaType.APPLICATION_XML)
	public List<UsersData> findUsersByAddress(@QueryParam("id") long id) {
		System.out.println("findUsersByAddress");
		List<Users> users = addressEJB.findUsersByAddress(id);
		List<UsersData> lUsers = new ArrayList<UsersData>();
		for (Users user : users) {
			lUsers.add(user.toUserData());
		}
		return lUsers;
	}

	@GET
	@Path("/get/sensors")
	@Consumes(MediaType.APPLICATION_XML)
	public List<SensorData> findSensorByAddress(@QueryParam("id") long id) {
		System.out.println("findSensorByAddress");
		List<Sensor> sensors = addressEJB.findSensorByAddress(id);
		List<SensorData> lSensors = new ArrayList<SensorData>();
		for (Sensor sensor : sensors) {
			lSensors.add(sensor.toSensorData());
		}
		return lSensors;
	}
}
