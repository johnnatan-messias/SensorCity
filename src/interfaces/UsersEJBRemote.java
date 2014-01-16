package interfaces;

import java.util.List;

import javax.ejb.Remote;

import kernel.Users;

@Remote
public interface UsersEJBRemote {
	List<Users> findUsers();
	Users findUsersById(long id);
	Users findUsersByDocument(String document);
	Users createUsers(Users user);
	void deleteUsers(Users user);
	Users updateUsers(Users user);
}
