package com.appspot.ssg.android.data;

import java.util.ArrayList;
import java.util.List;

import com.appspot.ssg.dmixed.shared.ITermin;
import com.appspot.ssg.dmixed.shared.ITermine;

public class Termine implements ITermine {

	private static final long serialVersionUID = 6372713290171017820L;
	private List<Termin> all;

	@Override
	public List<ITermin> getAll() {
		return all != null ? new ArrayList<ITermin>(all) : new ArrayList<ITermin>();
	}

	public void setAll(List<Termin> all) {
		this.all = all;
	}

}
