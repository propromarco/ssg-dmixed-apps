package de.clubbiertest.client.mvp.presenter;

import com.google.msc.framework.client.mvp.ASidebarPresenter;
import com.google.msc.framework.client.mvp.Slot;

import de.clubbiertest.client.ClubbiertestContext;
import de.clubbiertest.client.mvp.view.SidebarView;

public class CBTSidebarPresenter extends ASidebarPresenter<SidebarView, ClubbiertestContext> {

    public CBTSidebarPresenter(final SidebarView view, final ClubbiertestContext context) {
        super(view, context);
    }

    @Override
    protected void onBind() {
        super.onBind();
        final ClubbiertestContext context = getContext();
        final SidebarView view = getView();
        final Slot kontinentSlot = view.getKontinentSlot();
        final CBTKontinentPresenter kontinentPresenter = context.createKontinentPresenter();
        setInSlot(kontinentSlot, kontinentPresenter);
        final Slot landSlot = view.getLandSlot();
        final CBTLandPresenter landPresenter = context.createLandPresenter();
        setInSlot(landSlot, landPresenter);
        final Slot sorteSlot = view.getSorteSlot();
        final CBTSortePresenter sortePresenter = context.createSortePresenter();
        setInSlot(sorteSlot, sortePresenter);
    }

}
