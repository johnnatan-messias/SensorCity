package services;

import interfaces.AddressEJBRemote;

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

import kernel.Address;
import kernel.Users;
import Sensors.Sensor;

@Path("/address")
@Produces(MediaType.APPLICATION_XML)
public class AddressService {
	@EJB
	AddressEJBRemote addressEJB;

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public void create(Address address) {
		System.out.println("createAddress");
		addressEJB.createAddress(address);
	}

	@GET
	@Path("/get")
	@Consumes(MediaType.APPLICATION_XML)
	public Address read(@QueryParam("id") long id) {
		System.out.println("readAddress");
		return addressEJB.findAddressById(id);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public void update(Address address) {
		System.out.println("updateAddress");
		addressEJB.updateAddress(address);
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
	public List<Address> findAddresses() {
		System.out.println("findAddresses");
		return addressEJB.findAddress();
	}

	@GET
	@Path("g/et/bystreet")
	@Consumes(MediaType.APPLICATION_XML)
	public List<Address> findAddressByStreet(@QueryParam("street") String street) {
		System.out.println("findAddressByStreet");
		return addressEJB.findAddressByStreet(street);
	}

	@GET
	@Path("/get/users")
	@Consumes(MediaType.APPLICATION_XML)
	public List<Users> findUsersByAddress(@QueryParam("id") long id) {
		System.out.println("findUsersByAddress");
		return addressEJB.findUsersByAddress(id);
	}

	@GET
	@Path("/get/sensors")
	@Consumes(MediaType.APPLICATION_XML)
	public List<Sensor> findSensorByAddress(@QueryParam("id") long id) {
		System.out.println("findSensorByAddress");
		return addressEJB.findSensorByAddress(id);
	}
}
