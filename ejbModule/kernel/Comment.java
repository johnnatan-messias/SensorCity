package kernel;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id; // Primary key
	@Column(nullable = false)
	private String title;
	private String message;
	
	private Date datePosted;
	
	@ManyToOne
	private Users owner;

	public Comment() {
	}

	public Comment(int id, String title, String message, Date datePosted,
			Users owner) {
		this.id = id;
		this.title = title;
		this.message = message;
		this.datePosted = datePosted;
		this.owner = owner;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getMessage() {
		return message;
	}

	public Date getDatePosted() {
		return datePosted;
	}

	public Users getowner() {
		return owner;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setDatePosted(Date datePosted) {
		this.datePosted = datePosted;
	}

	public void setOwner(Users Owner) {
		this.owner = Owner;
	}

}
