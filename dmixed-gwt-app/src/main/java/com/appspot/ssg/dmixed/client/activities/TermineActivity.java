package com.appspot.ssg.dmixed.client.activities;

import java.util.Date;
import java.util.List;

import com.appspot.ssg.dmixed.client.ClientFactory;
import com.appspot.ssg.dmixed.client.model.TerminCreate;
import com.appspot.ssg.dmixed.client.places.TerminPlace;
import com.appspot.ssg.dmixed.shared.IAsync;
import com.appspot.ssg.dmixed.shared.IDMixedUsecase;
import com.appspot.ssg.dmixed.shared.ILiga;
import com.appspot.ssg.dmixed.shared.ILigen;
import com.appspot.ssg.dmixed.shared.ITermin;
import com.appspot.ssg.dmixed.shared.ITerminDetails;
import com.appspot.ssg.dmixed.shared.ITermine;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;
import com.googlecode.mgwt.ui.client.widget.Button;
import com.googlecode.mgwt.ui.client.widget.MCheckBox;
import com.googlecode.mgwt.ui.client.widget.MDateBox;
import com.googlecode.mgwt.ui.client.widget.MListBox;
import com.googlecode.mgwt.ui.client.widget.MTextBox;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedEvent;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedHandler;
import com.googlecode.mgwt.ui.client.widget.celllist.HasCellSelectedHandler;

public class TermineActivity extends MGWTAbstractActivity {

    public interface TermineView extends IDMixedView {
	public HasCellSelectedHandler getCellSelectedHandler();

	public MDateBox getTerminDatum();

	public MTextBox getKurzbeschreibung();

	public MCheckBox getHeimspiel();

	public MListBox getLiga();

	public Button getNewTerminButton();

	void updateList(List<ITermin> termine);
    }

    private final ClientFactory _clientFactory;
    private final Long userId;
    protected final boolean admin;

    public TermineActivity(final ClientFactory clientFactory, final Long userId, final boolean admin) {
	_clientFactory = clientFactory;
	this.userId = userId;
	this.admin = admin;
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
			    final Long terminId = iTermin.getId();
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
	final IAsync<ILigen> answer2 = new IAsync<ILigen>() {

	    @Override
	    public void onSuccess(final ILigen t) {
		if (t != null) {
		    final List<ILiga> ligen = t.getAll();
		    initNewTermin(termineView, ligen);
		}
	    }

	    @Override
	    public void onError(final Throwable exception) {
		termineView.showError(exception);
	    }
	};
	service.getLigen(userId, answer2);
	addHandlerRegistration(termineView.getNewTerminButton().addTapHandler(new TapHandler() {

	    @Override
	    public void onTap(final TapEvent event) {
		final Date termindatum = termineView.getTerminDatum().getValue();
		final String kurzbeschreibung = termineView.getKurzbeschreibung().getValue();
		final Long liga = Long.valueOf(termineView.getLiga().getValue(termineView.getLiga().getSelectedIndex()));
		final Boolean heimSpiel = termineView.getHeimspiel().getValue();
		final TerminCreate termineCreate = new TerminCreate(termindatum, kurzbeschreibung, liga, heimSpiel);
		final IAsync<ITerminDetails> myAnswer = new IAsync<ITerminDetails>() {
		    @Override
		    public void onSuccess(final ITerminDetails t) {
			// TODO Auto-generated method stub
		    }

		    @Override
		    public void onError(final Throwable exception) {
			termineView.showError(exception);
		    }
		};
		service.createTermin(userId, termineCreate, myAnswer);
	    }
	}));
    }

    protected void initNewTermin(final TermineView termineView, final List<ILiga> ligen) {
	final MListBox liga = termineView.getLiga();
	liga.clear();
	for (final ILiga iLiga : ligen) {
	    liga.addItem(iLiga.getBezeichnung(), iLiga.getId().toString());
	}
    }

    protected void loadTermine(final ITermine termine) {
	final TermineView termineView = _clientFactory.getTermineView();
	termineView.updateList(termine.getAll());
    }

}
