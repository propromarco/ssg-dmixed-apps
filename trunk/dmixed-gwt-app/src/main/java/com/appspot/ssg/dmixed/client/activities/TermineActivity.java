package com.appspot.ssg.dmixed.client.activities;

import java.util.List;

import com.appspot.ssg.dmixed.client.ClientFactory;
import com.appspot.ssg.dmixed.client.DMixedModel;
import com.appspot.ssg.dmixed.client.places.TerminPlace;
import com.appspot.ssg.dmixed.shared.IAsync;
import com.appspot.ssg.dmixed.shared.IDMixedUsecase;
import com.appspot.ssg.dmixed.shared.ITermin;
import com.appspot.ssg.dmixed.shared.ITermine;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedEvent;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedHandler;
import com.googlecode.mgwt.ui.client.widget.celllist.HasCellSelectedHandler;

public class TermineActivity extends MGWTAbstractActivity {

    public interface TermineView extends IDMixedView {
        public HasCellSelectedHandler getCellSelectedHandler();

        void updateList(List<ITermin> termine);
    }

    private final ClientFactory _clientFactory;

    public TermineActivity(final ClientFactory clientFactory) {
        _clientFactory = clientFactory;
    }

    @Override
    public void start(final AcceptsOneWidget panel, final EventBus eventBus) {
        final TermineView termineView = _clientFactory.getTermineView();
        final IDMixedUsecase service = _clientFactory.getService();
        final DMixedModel model = _clientFactory.getModel();
        panel.setWidget(termineView);
        if (model.getTermine() == null) {
            final Long userId = model.getUser().getId();
            termineView.setProgress(true);
            final IAsync<ITermine> answer = new IAsync<ITermine>() {

                @Override
                public void onSuccess(final ITermine t) {
                    if (t != null) {
                        model.setTermine(t);
                        loadTermine();
                    }
                    else {
                        // TODO Error oder Nicht erlaubt
                    }
                    termineView.setProgress(false);
                }
            };
            service.getTermine(userId, answer);
        }
        else {
            loadTermine();
        }
        addHandlerRegistration(termineView.getCellSelectedHandler().addCellSelectedHandler(new CellSelectedHandler() {

            @Override
            public void onCellSelected(final CellSelectedEvent event) {
                final int index = event.getIndex();
                final ITermine termine = model.getTermine();
                final List<ITermin> all = termine.getAll();
                final ITermin iTermin = all.get(index);
                _clientFactory.getPlaceController().goTo(new TerminPlace(iTermin.getTerminId()));
            }
        }));

    }

    protected void loadTermine() {
        final TermineView termineView = _clientFactory.getTermineView();
        final DMixedModel model = _clientFactory.getModel();
        final ITermine termine = model.getTermine();
        termineView.updateList(termine.getAll());
    }

}
