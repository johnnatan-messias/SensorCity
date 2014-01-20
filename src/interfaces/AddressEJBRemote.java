package interfaces;

import java.util.List;

import javax.ejb.Remote;

import kernel.AddressEntity;
import Sensors.SensorEntity;

@Remote
public interface AddressEJBRemote {
	List<AddressEntity> findAddress();
	AddressEntity findAddressById(long id);
	List<AddressEntity> findAddressByStreet(String street);
	AddressEntity createAddress(AddressEntity address);
	void deleteAddress(AddressEntity address);
	AddressEntity updateAddress(AddressEntity address);
	List<SensorEntity> findSensorByAddress(long id);
}
