package com.appspot.ssg.dmixed.client.activities;

import java.util.Date;

import com.appspot.ssg.dmixed.client.ClientFactory;
import com.appspot.ssg.dmixed.client.places.TerminMitbringPlace;
import com.appspot.ssg.dmixed.client.places.TerminTeilnahmePlace;
import com.appspot.ssg.dmixed.shared.IAsync;
import com.appspot.ssg.dmixed.shared.IDMixedUsecase;
import com.appspot.ssg.dmixed.shared.ITerminDetails;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.HasVisibility;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;

public class TerminActivity extends MGWTAbstractActivity {

    public interface TerminView extends IDMixedView {

	public interface Navigate extends HasVisibility, HasTapHandlers {
	}

	void setTerminBeschreibung(String terminBeschreibung);

	Navigate getMitkommen();

	Navigate getMitbringen();

    }

    private final ClientFactory _clientFactory;
    private final Long userId;
    private final Long terminId;

    public TerminActivity(final ClientFactory clientFactory, final Long userId, final Long terminId) {
	_clientFactory = clientFactory;
	this.userId = userId;
	this.terminId = terminId;
    }

    @Override
    public void start(final AcceptsOneWidget panel, final EventBus eventBus) {
	final TerminView terminView = _clientFactory.getTerminView();
	final IDMixedUsecase service = _clientFactory.getService();
	panel.setWidget(terminView);
	final IAsync<ITerminDetails> answer = new IAsync<ITerminDetails>() {
	    @Override
	    public void onSuccess(final ITerminDetails termin) {
		if (termin != null) {
		    final boolean heimspiel = termin.isHeimspiel();
		    final Date termineDatum = termin.getTermineDatum();
		    final String terminKurzbeschreibung = termin.getTerminKurzbeschreibung();
		    final DateTimeFormat formatter = DateTimeFormat.getFormat("dd.MM.yyyy");
		    final String d = formatter.format(termineDatum);
		    final String title = terminKurzbeschreibung + " - " + d;
		    terminView.setHeaderText(title);
		    final String terminBeschreibung = termin.getTerminBeschreibung();
		    terminView.setTerminBeschreibung(terminBeschreibung);
		    addHandlerRegistration(terminView.getMitkommen().addTapHandler(new TapHandler() {
			@Override
			public void onTap(final TapEvent event) {
			    final Long terminId = termin.getId();
			    _clientFactory.getPlaceController().goTo(new TerminTeilnahmePlace(userId, terminId));
			}
		    }));
		    terminView.getMitbringen().setVisible(heimspiel);
		    addHandlerRegistration(terminView.getMitbringen().addTapHandler(new TapHandler() {
			@Override
			public void onTap(final TapEvent event) {
			    final Long terminId = termin.getId();
			    _clientFactory.getPlaceController().goTo(new TerminMitbringPlace(userId, terminId));
			}
		    }));
		} else {
		    // TODO Error oder nicht erlaubt
		}
	    }

	    @Override
	    public void onError(final Throwable exception) {
		terminView.showError(exception);
	    }
	};
	service.getTermin(userId, terminId, answer);
    }
}
