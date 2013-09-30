package com.appspot.ssg.android.data;

import java.util.ArrayList;
import java.util.List;

import com.appspot.ssg.dmixed.shared.ILiga;
import com.appspot.ssg.dmixed.shared.ILigen;

public class Ligen implements ILigen {

	private static final long serialVersionUID = -213218223728559729L;

	private List<Liga> all;

	public void setAll(List<Liga> all) {
		this.all = all;
	}

	@Override
	public List<ILiga> getAll() {
		return new ArrayList<ILiga>(all);
	}

}
