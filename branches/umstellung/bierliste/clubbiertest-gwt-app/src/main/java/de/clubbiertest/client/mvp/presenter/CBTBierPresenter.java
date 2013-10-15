package de.clubbiertest.client.mvp.presenter;

import com.google.msc.framework.client.mvp.APresenter;

import de.clubbiertest.client.CBTContext;
import de.clubbiertest.client.mvp.CBTModel;
import de.clubbiertest.client.mvp.CBTModel.ICallback;
import de.clubbiertest.client.mvp.view.CBTBierView;
import de.clubbiertest.liste.shared.Bier;

public class CBTBierPresenter extends APresenter<CBTBierView, CBTContext> {

    public CBTBierPresenter(final CBTBierView view, final CBTContext context) {
        super(view, context);
    }

    @Override
    protected void onUpdate() {
        super.onUpdate();
        final CBTModel model = getContext().getModel();
        final String activeBier = model.getActiveBier();
        if (activeBier != null) {
            final ICallback<Bier> cb = new ICallback<Bier>() {

                @Override
                public void onSuccess(final Bier data) {
                    System.out.println(data);
                }
            };
            model.loadBier(activeBier, cb);
        }
    }

}
