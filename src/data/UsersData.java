package data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlInverseReference;

@XmlRootElement
public class UsersData {

	private long id;

	private String document;

	private String fstname;

	private String sndname;
	private String profession;

	private long age;

	private String email;
	private String facebook;
	private long phone;

	protected AddressData address;

	public UsersData() {
	}

	@XmlAttribute(name = "id")
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

	@XmlInverseReference(mappedBy = "users")
	public AddressData getAddress() {
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

	public void setAddress(AddressData address) {
		this.address = address;
	}

}
