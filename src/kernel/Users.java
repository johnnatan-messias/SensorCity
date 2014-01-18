package kernel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import data.UsersData;

@Entity
public class Users implements Serializable {
	@Transient
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id; // primary key
	@Column(unique = true, nullable = false)
	private String document; // unique
	@Column(nullable = false)
	private String fstname;
	@Column(nullable = false)
	private String sndname;
	private String profession;
	@Column(nullable = false)
	private long age;
	@Column(nullable = false)
	private String email;
	private String facebook;
	private long phone;

	@ManyToOne
	protected Address address;

	public Users() {
	}

	public long getId() {
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

	public long getAge() {
		return age;
	}

	public String getEmail() {
		return email;
	}

	public String getFacebook() {
		return facebook;
	}

	public long getPhone() {
		return phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setId(long id) {
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

	public void setAge(long age) {
		this.age = age;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public UsersData toUserData() {
		UsersData u = new UsersData();
		u.setAddress(this.getAddress().toAddressData());
		u.setAge(this.getAge());
		u.setDocument(this.getDocument());
		u.setEmail(this.getEmail());
		u.setFacebook(this.getFacebook());
		u.setFstname(this.getFstname());
		u.setSndname(this.getSndname());
		u.setId(this.getId());
		u.setPhone(this.getPhone());
		u.setProfession(this.getProfession());
		return u;
	}

}
