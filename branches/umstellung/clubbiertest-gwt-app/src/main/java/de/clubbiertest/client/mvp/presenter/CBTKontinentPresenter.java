package de.clubbiertest.client.mvp.presenter;

import com.google.msc.framework.client.mvp.presenter.AbstractPresenter;
import com.google.msc.framework.client.mvp.presenter.IView;

import de.clubbiertest.client.mvp.presenter.CBTKontinentPresenter.IKontinentView;

public class CBTKontinentPresenter extends
		AbstractPresenter<IKontinentView, ICBTContext> {

	public interface IKontinentView extends IView {

	}

	public CBTKontinentPresenter(final IKontinentView view) {
		super(view);
	}

}
