package de.clubbiertest.client.mvp.presenter;

import com.google.msc.framework.client.mvp.APresenter;

import de.clubbiertest.client.ClubbiertestContext;
import de.clubbiertest.client.mvp.CBTModel;
import de.clubbiertest.client.mvp.CBTModel.ICallback;
import de.clubbiertest.client.mvp.view.CBTLandView;
import de.clubbiertest.liste.shared.ListeItems;

public class CBTLandPresenter extends APresenter<CBTLandView, ClubbiertestContext> {

	private ListeItems lastLand = null;

	public CBTLandPresenter(final CBTLandView view, final ClubbiertestContext context) {
		super(view, context);
	}

	@Override
	protected void onUpdate() {
		super.onUpdate();
		final CBTModel model = getContext().getModel();
		final String activeLand = model.getActiveLand();
		if (activeLand != null) {
			final ICallback<ListeItems> cb = new ICallback<ListeItems>() {
				@Override
				public void onSuccess(final ListeItems data) {
					lastLand = data;
				}
			};
			if (lastLand == null) {
				model.loadLand(activeLand, cb);
			} else if (lastLand.getId().equals(activeLand)) {
				model.loadLand(activeLand, cb);
			}
		}
	}

}
