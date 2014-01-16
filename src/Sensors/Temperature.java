package Sensors;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Temperature implements Serializable {
	@Transient
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private long value;

	public Temperature() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

}
