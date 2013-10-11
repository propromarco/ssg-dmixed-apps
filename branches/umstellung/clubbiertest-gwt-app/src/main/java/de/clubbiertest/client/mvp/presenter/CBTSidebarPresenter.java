package de.clubbiertest.client.mvp.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.msc.framework.client.mvp.ASidebarPresenter;
import com.google.msc.framework.client.mvp.ASidebarView.SidebarEntry;

import de.clubbiertest.client.ClubbiertestContext;
import de.clubbiertest.client.mvp.view.CBTSidebarView;
import de.clubbiertest.client.mvp.view.CBTSidebarView.Stacks;

public class CBTSidebarPresenter extends ASidebarPresenter<CBTSidebarView, ClubbiertestContext> {

    public CBTSidebarPresenter(final CBTSidebarView view, final ClubbiertestContext context) {
        super(view, context);
    }

    @Override
    protected void onBind() {
        super.onBind();
        final ClubbiertestContext context = getContext();
        final CBTSidebarView view = getView();
        final SidebarEntry kontinentEntry = view.createSlot(Stacks.KONTINENT);
        final CBTKontinentePresenter kontinentPresenter = context.createKontinentPresenter();
        setInSlot(kontinentEntry.getSlot(), kontinentPresenter);
        addHandler(kontinentEntry.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                view.selectStack(Stacks.KONTINENT);
            }
        }));
        final SidebarEntry landEntry = view.createSlot(Stacks.LAND);
        final CBTLaenderPresenter landPresenter = context.createLandPresenter();
        setInSlot(landEntry.getSlot(), landPresenter);
        addHandler(landEntry.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                view.selectStack(Stacks.LAND);
            }
        }));
        final SidebarEntry sorteEntry = view.createSlot(Stacks.SORTE);
        final CBTSortenPresenter sortePresenter = context.createSortePresenter();
        setInSlot(sorteEntry.getSlot(), sortePresenter);
        addHandler(sorteEntry.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                view.selectStack(Stacks.SORTE);
            }
        }));
        view.selectStack(Stacks.KONTINENT);
    }

}
