package de.marco.test.jaxb;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FormularI {

	private String title;
	private PlannedObject object;
	private String nameDesOrtes;

	public void setTitle(final String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setObject(final PlannedObject object) {
		this.object = object;
	}

	public PlannedObject getObject() {
		return object;
	}

	public void setNameDesOrtes(String nameDesOrtes) {
		this.nameDesOrtes = nameDesOrtes;
	}

	public String getNameDesOrtes() {
		return nameDesOrtes;
	}

}
