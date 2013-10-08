package de.clubbiertest.client.mvp.presenter;

import com.google.msc.framework.client.mvp.AMainPresenter;
import com.google.msc.framework.client.mvp.Slot;

import de.clubbiertest.client.ClubbiertestContext;
import de.clubbiertest.client.mvp.view.CBTMainView;

public class CBTMainPresenter extends AMainPresenter<CBTMainView, ClubbiertestContext> {

    public CBTMainPresenter(final CBTMainView view, final ClubbiertestContext context) {
        super(view, context);
    }

    @Override
    protected void onBind() {
        super.onBind();
        final ClubbiertestContext context = getContext();
        final CBTMainView view = getView();
        final Slot sidebarSlot = view.getSidebarSlot();
        final CBTSidebarPresenter sidebarPresenter = context.createSidebarPresenter();
        setInSlot(sidebarSlot, sidebarPresenter);
        final Slot contentSlot = view.getContentSlot();
        final CBTWelcomePresenter welcomePresenter = context.createWelcomePresenter();
        setInSlot(contentSlot, welcomePresenter);
    }

}
