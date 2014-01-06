package Sensors;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AtmPressure {
	@Id
	private int id;
	private long value;

	public AtmPressure() {
	}

	public AtmPressure(int id, long value) {
		this.id = id;
		this.value = value;
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
