package interfaces;

import java.util.List;

import javax.ejb.Remote;

import Sensors.Sensor;
import kernel.Address;
import kernel.Users;

@Remote
public interface AddressEJBRemote {
	List<Address> findAddress();
	Address findAddressById(int id);
	List<Address> findAddressByStreet(String street);
	Address createAddress(Address address);
	void deleteAddress(Address address);
	Address updateAddress(Address address);
	List<Users> findUsersByAddress(int id);
	List<Sensor> findSensorByAddress(int id);
}
