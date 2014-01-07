package interfaces;

import java.util.List;

import kernel.Comment;
import kernel.Users;

public interface UsersEJBRemote {
	List<Users> findUsers();
	Users findUsersById(int id);
	Users findUsersByDocument(String document);
	Users createUsers(Users user);
	Users deleteUsers(Users user);
	Users updateUsers(Users user);
	List<Comment> findCommentByUsers(int id);
}
