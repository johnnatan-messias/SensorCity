package services;

import interfaces.UsersEJBRemote;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import kernel.Users;

@Path("/user")
public class UserService {
	@EJB
	UsersEJBRemote userEJB;

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public void create(Users user) {
		System.out.println("createUser");
		userEJB.createUsers(user);
	}

	@GET
	@Path("/get")
	@Consumes(MediaType.APPLICATION_XML)
	public Users read(@QueryParam("id") long id) {
		System.out.println("readUser");
		return userEJB.findUsersById(id);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public void update(Users user) {
		System.out.println("updateUser");
		userEJB.updateUsers(user);
	}

	@DELETE
	@Path("/del")
	public void delete(@QueryParam("id") long id) {
		System.out.println("deleteUser");
		Users user = userEJB.findUsersById(id);
		if (user != null) {
			userEJB.deleteUsers(user);
		}
	}

	@GET
	@Path("/get/users")
	@Consumes(MediaType.APPLICATION_XML)
	public List<Users> findUsers() {
		System.out.println("findUsers");
		return userEJB.findUsers();
	}

	@GET
	@Path("/get/bydocument")
	@Consumes(MediaType.APPLICATION_XML)
	public Users findUsersByDocument(@QueryParam("document") String document) {
		System.out.println("findUsersByDocument");
		return userEJB.findUsersByDocument(document);
	}
}
