package main;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id; // primary key
	private String document; // unique
	private String fstname;
	private String sndname;
	private String profession;
	private int age;
	private String email;
	private String facebook;
	private int phone;

	@ManyToOne
	protected Address address;
	
	@OneToMany(mappedBy = "owner")
	protected List<Comment> comments; // 1 User just can have N Comments. 1 Comment
									// can be of 1 Users.

	public Users() {
	}
	
	
	public Users(int id, String document, String fstname, String sndname,
			String profession, int age, String email, String facebook,
			int phone, Address address) {
		this.id = id;
		this.document = document;
		this.fstname = fstname;
		this.sndname = sndname;
		this.profession = profession;
		this.age = age;
		this.email = email;
		this.facebook = facebook;
		this.phone = phone;
		this.address = address;
	}
	

	public Users(int id, String document, String fstname, String sndname,
			String profession, int age, String email, String facebook,
			int phone, Address address, List<Comment> comments) {
		this.id = id;
		this.document = document;
		this.fstname = fstname;
		this.sndname = sndname;
		this.profession = profession;
		this.age = age;
		this.email = email;
		this.facebook = facebook;
		this.phone = phone;
		this.address = address;
		this.comments = comments;
	}

	public int getId() {
		return id;
	}

	public String getDocument() {
		return document;
	}

	public String getFstname() {
		return fstname;
	}

	public String getSndname() {
		return sndname;
	}

	public String getProfession() {
		return profession;
	}

	public int getAge() {
		return age;
	}

	public String getEmail() {
		return email;
	}

	public String getFacebook() {
		return facebook;
	}

	public int getPhone() {
		return phone;
	}

	public Address getAddress() {
		return address;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public void setFstname(String fstname) {
		this.fstname = fstname;
	}

	public void setSndname(String sndname) {
		this.sndname = sndname;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

}
