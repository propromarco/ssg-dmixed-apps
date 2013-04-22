package com.appspot.ssg.android.data;

import java.util.List;

import com.appspot.ssg.dmixed.shared.ITermin;
import com.appspot.ssg.dmixed.shared.ITermine;

public class Termine implements ITermine {

	private static final long serialVersionUID = 6372713290171017820L;
	private List<ITermin> all;

	@Override
	public List<ITermin> getAll() {
		return all;
	}

	public void setAll(List<ITermin> all) {
		this.all = all;
	}

}
