package data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AtmPressureData {

	private long id;
	private long value;

	public AtmPressureData() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

}
