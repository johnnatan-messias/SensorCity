package interfaces;

import java.util.List;

import javax.ejb.Remote;

import Sensors.Sensor;
import kernel.Address;
import kernel.Users;

@Remote
public interface AddressEJBRemote {
	List<Address> findAddress();
	Address findAddressById(long id);
	List<Address> findAddressByStreet(String street);
	Address createAddress(Address address);
	void deleteAddress(Address address);
	Address updateAddress(Address address);
	List<Users> findUsersByAddress(long id);
	List<Sensor> findSensorByAddress(long id);
}
