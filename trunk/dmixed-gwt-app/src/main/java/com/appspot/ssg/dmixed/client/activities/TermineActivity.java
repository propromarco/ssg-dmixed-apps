package com.appspot.ssg.dmixed.client.activities;

import java.util.Date;
import java.util.List;

import com.appspot.ssg.dmixed.client.ClientFactory;
import com.appspot.ssg.dmixed.client.activities.LoginActivity.WithTapHandlers;
import com.appspot.ssg.dmixed.client.model.TerminCreate;
import com.appspot.ssg.dmixed.client.places.TerminPlace;
import com.appspot.ssg.dmixed.client.views.components.HasCellSelectedHandler;
import com.appspot.ssg.dmixed.client.views.components.SelectionHandler;
import com.appspot.ssg.dmixed.client.views.SelectionEvent;
import com.appspot.ssg.dmixed.shared.IAsync;
import com.appspot.ssg.dmixed.shared.IDMixedUsecase;
import com.appspot.ssg.dmixed.shared.ILiga;
import com.appspot.ssg.dmixed.shared.ILigen;
import com.appspot.ssg.dmixed.shared.ITermin;
import com.appspot.ssg.dmixed.shared.ITerminDetails;
import com.appspot.ssg.dmixed.shared.ITermine;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;

public class TermineActivity extends AbstractActivity {

    public interface TermineView extends IDMixedView {
	HasCellSelectedHandler<ITermin> getCellSelectedHandler();

	DateBox getTerminDatum();

	TextArea getBeschreibung();

	TextBox getKurzbeschreibung();

	CheckBox getHeimspiel();

	ListBox getLiga();

	WithTapHandlers getNewTerminButton();

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
		    termineView.getCellSelectedHandler().addSelectionHandler(new SelectionHandler<ITermin>() {

			@Override
			public void onSelect(final SelectionEvent<ITermin> event) {
			    final ITermin termin = event.getSelected();
			    final Long terminId = termin.getId();
			    _clientFactory.getPlaceController().goTo(new TerminPlace(userId, terminId));
			}
		    });
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
	final WithTapHandlers newTerminButton = termineView.getNewTerminButton();
	newTerminButton.addClickHandler(new ClickHandler() {
	    @Override
	    public void onClick(final ClickEvent event) {
		newTerminButton.setProgress(true);
		final Date termindatum = termineView.getTerminDatum().getValue();
		final String kurzbeschreibung = termineView.getKurzbeschreibung().getValue();
		final Long liga = Long.valueOf(termineView.getLiga().getValue(termineView.getLiga().getSelectedIndex()));
		final Boolean heimSpiel = termineView.getHeimspiel().getValue();
		final String beschreibung = termineView.getBeschreibung().getValue();
		final TerminCreate termineCreate = new TerminCreate(termindatum, kurzbeschreibung, liga, heimSpiel, beschreibung);
		final IAsync<ITerminDetails> myAnswer = new IAsync<ITerminDetails>() {
		    @Override
		    public void onSuccess(final ITerminDetails t) {
			if (t != null) {
			    final Long terminId = t.getId();
			    _clientFactory.getPlaceController().goTo(new TerminPlace(userId, terminId));
			}
			newTerminButton.setProgress(false);
		    }

		    @Override
		    public void onError(final Throwable exception) {
			termineView.showError(exception);
			newTerminButton.setProgress(false);
		    }
		};
		service.createTermin(userId, termineCreate, myAnswer);
	    }
	});
    }

    protected void initNewTermin(final TermineView termineView, final List<ILiga> ligen) {
	final ListBox liga = termineView.getLiga();
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
