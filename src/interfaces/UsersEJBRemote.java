package interfaces;

import java.util.List;

import javax.ejb.Remote;

import kernel.UsersEntity;

@Remote
public interface UsersEJBRemote {
	List<UsersEntity> findUsers();
	UsersEntity findUsersById(long id);
	UsersEntity findUsersByDocument(String document);
	UsersEntity createUsers(UsersEntity user);
	void deleteUsers(UsersEntity user);
	UsersEntity updateUsers(UsersEntity user);
}
