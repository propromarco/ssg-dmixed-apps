package de.clubbiertest.client.mvp.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.msc.framework.client.mvp.ASidebarPresenter;
import com.google.msc.framework.client.mvp.ASidebarView.SidebarEntry;

import de.clubbiertest.client.CBTContext;
import de.clubbiertest.client.mvp.CBTModel;
import de.clubbiertest.client.mvp.view.CBTSidebarView;
import de.clubbiertest.client.mvp.view.CBTSidebarView.Stacks;

public class CBTSidebarPresenter extends ASidebarPresenter<CBTSidebarView, CBTContext> {

    public CBTSidebarPresenter(final CBTSidebarView view, final CBTContext context) {
        super(view, context);
    }

    @Override
    protected void onBind() {
        super.onBind();
        final CBTContext context = getContext();
        final CBTSidebarView view = getView();
        final SidebarEntry kontinentEntry = view.createSlot(Stacks.KONTINENTE);
        final CBTKontinentePresenter kontinentPresenter = context.createKontinentPresenter();
        setInSlot(kontinentEntry.getSlot(), kontinentPresenter);
        addHandler(kontinentEntry.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                view.selectStack(Stacks.KONTINENTE);
            }
        }));
        final SidebarEntry landEntry = view.createSlot(Stacks.LAENDER);
        final CBTLaenderPresenter landPresenter = context.createLandPresenter();
        setInSlot(landEntry.getSlot(), landPresenter);
        addHandler(landEntry.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                view.selectStack(Stacks.LAENDER);
            }
        }));
        final SidebarEntry sorteEntry = view.createSlot(Stacks.SORTEN);
        final CBTSortenPresenter sortePresenter = context.createSortePresenter();
        setInSlot(sorteEntry.getSlot(), sortePresenter);
        addHandler(sorteEntry.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                view.selectStack(Stacks.SORTEN);
            }
        }));
        view.selectStack(Stacks.KONTINENTE);
    }

    @Override
    protected void onUpdate() {
        super.onUpdate();
        final CBTModel model = getContext().getModel();
        final Stacks openSidebar = model.getOpenSidebar();
        getView().selectStack(openSidebar);
    }

}
