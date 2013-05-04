package com.appspot.ssg.dmixed.client.activities;

import java.util.List;

import com.appspot.ssg.dmixed.client.ClientFactory;
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
    private final Long userId;

    public TermineActivity(final ClientFactory clientFactory, final Long userId) {
	_clientFactory = clientFactory;
	this.userId = userId;
    }

    @Override
    public void start(final AcceptsOneWidget panel, final EventBus eventBus) {
	final TermineView termineView = _clientFactory.getTermineView();
	final IDMixedUsecase service = _clientFactory.getService();
	panel.setWidget(termineView);
	termineView.setProgress(true);
	final IAsync<ITermine> answer = new IAsync<ITermine>() {

	    @Override
	    public void onSuccess(final ITermine t) {
		if (t != null) {
		    loadTermine(t);
		    addHandlerRegistration(termineView.getCellSelectedHandler().addCellSelectedHandler(new CellSelectedHandler() {
			
			@Override
			public void onCellSelected(final CellSelectedEvent event) {
			    final int index = event.getIndex();
			    final List<ITermin> all = t.getAll();
			    final ITermin iTermin = all.get(index);
			    final Long terminId = iTermin.getTerminId();
			    _clientFactory.getPlaceController().goTo(new TerminPlace(userId, terminId));
			}
		    }));
		} else {
		    // TODO Error oder Nicht erlaubt
		}
		termineView.setProgress(false);
	    }

	    @Override
	    public void onError(final Throwable exception) {
		termineView.showError(exception);
	    }
	};
	service.getTermine(userId, answer);

    }

    protected void loadTermine(final ITermine termine) {
	final TermineView termineView = _clientFactory.getTermineView();
	termineView.updateList(termine.getAll());
    }

}
