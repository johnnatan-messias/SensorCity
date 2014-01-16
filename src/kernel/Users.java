package kernel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Users implements Serializable {
	@Transient
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id; // primary key
	@Column(unique = true, nullable = false)
	private String document; // unique
	@Column(nullable = false)
	private String fstname;
	@Column(nullable = false)
	private String sndname;
	private String profession;
	@Column(nullable = false)
	private int age;
	@Column(nullable = false)
	private String email;
	private String facebook;
	private int phone;

	@ManyToOne
	protected Address address;

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

}