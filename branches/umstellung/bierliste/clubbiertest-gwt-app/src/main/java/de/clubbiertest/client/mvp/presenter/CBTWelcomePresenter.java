package de.clubbiertest.client.mvp.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.msc.framework.client.mvp.APresenter;

import de.clubbiertest.client.CBTContext;
import de.clubbiertest.client.mvp.events.CBTBestenlisteEvent;
import de.clubbiertest.client.mvp.events.CBTKontinenteEvent;
import de.clubbiertest.client.mvp.view.CBTWelcomeView;

public class CBTWelcomePresenter extends APresenter<CBTWelcomeView, CBTContext> {

    public CBTWelcomePresenter(final CBTWelcomeView view, final CBTContext context) {
        super(view, context);
    }

    @Override
    protected void onBind() {
        super.onBind();
        addHandler(getView().addBestenListeClickHandler(new ClickHandler() {

            @Override
            public void onClick(final ClickEvent event) {
                getContext().getEventBus().fireEvent(new CBTBestenlisteEvent());
            }
        }));
        addHandler(getView().addKontinenteClickHandler(new ClickHandler() {

            @Override
            public void onClick(final ClickEvent event) {
                getContext().getEventBus().fireEvent(new CBTKontinenteEvent());
            }
        }));
    }

}
