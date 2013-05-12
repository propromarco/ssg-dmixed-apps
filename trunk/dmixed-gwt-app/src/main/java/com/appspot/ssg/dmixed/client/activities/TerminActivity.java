package com.appspot.ssg.dmixed.client.activities;

import java.util.Date;
import java.util.List;

import com.appspot.ssg.dmixed.client.ClientFactory;
import com.appspot.ssg.dmixed.client.activities.TerminActivity.TerminView.IListCreator;
import com.appspot.ssg.dmixed.client.activities.TerminActivity.TerminView.IListItem;
import com.appspot.ssg.dmixed.client.model.MitbringData;
import com.appspot.ssg.dmixed.client.model.TeilnahmeData;
import com.appspot.ssg.dmixed.client.model.TerminTeilnehmer;
import com.appspot.ssg.dmixed.shared.ETeilnahmeStatus;
import com.appspot.ssg.dmixed.shared.IAsync;
import com.appspot.ssg.dmixed.shared.IDMixedUsecase;
import com.appspot.ssg.dmixed.shared.ILiga;
import com.appspot.ssg.dmixed.shared.ITerminDetails;
import com.appspot.ssg.dmixed.shared.ITerminMitbringsel;
import com.appspot.ssg.dmixed.shared.ITerminTeilnehmer;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.HasValue;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;

public class TerminActivity extends MGWTAbstractActivity {

    public interface TerminView extends IDMixedView {

	public interface IListItem<T> extends HasValue<T>, HasTapHandlers {
	    void setMitbringer(String string);

	    void setEnabled(boolean enabled);
	}

	public interface IListCreator<T, B> {
	    IListItem<B> create(T t);

	    void onFinish(boolean hasItems);
	}

	void setTerminBeschreibung(String terminBeschreibung);

	IListCreator<ITerminTeilnehmer, ETeilnahmeStatus> fillTeilnehmer();

	IListCreator<ITerminMitbringsel, Boolean> fillMitbringsel();
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
		    final ILiga liga = termin.getLiga();
		    final String bezeichnung = liga.getBezeichnung();
		    final DateTimeFormat formatter = DateTimeFormat.getFormat("dd.MM.yyyy");
		    final String d = formatter.format(termineDatum);
		    final String title = bezeichnung + " - " + d;
		    terminView.setHeaderText(title);
		    final String terminBeschreibung = termin.getTerminBeschreibung();
		    terminView.setTerminBeschreibung(terminBeschreibung);
		    // Teilnehmer
		    final List<ITerminTeilnehmer> teilnehmer = termin.getTeilnehmer();
		    final IListCreator<ITerminTeilnehmer, ETeilnahmeStatus> teilnehmerCreator = terminView.fillTeilnehmer();
		    for (final ITerminTeilnehmer terminTeilnehmer : teilnehmer) {
			final IListItem<ETeilnahmeStatus> item = teilnehmerCreator.create(terminTeilnehmer);
			if (!terminTeilnehmer.isChangeAllowed()) {
			    item.setEnabled(false);
			}
			addHandlerRegistration(item.addValueChangeHandler(new ValueChangeHandler<ETeilnahmeStatus>() {
			    @Override
			    public void onValueChange(final ValueChangeEvent<ETeilnahmeStatus> event) {
				final ETeilnahmeStatus newValue = event.getValue();
				if (checkTeilnehmer(terminTeilnehmer, termin.getId(), newValue))
				    item.setValue(newValue);
			    }
			}));
		    }
		    teilnehmerCreator.onFinish(teilnehmer.size() > 0);
		    // Mitbringen
		    final IListCreator<ITerminMitbringsel, Boolean> mitbringselCreator = terminView.fillMitbringsel();
		    final List<ITerminMitbringsel> mitbringsel = termin.getMitbringsel();
		    if (mitbringsel != null) {
			for (final ITerminMitbringsel terminMitbringsel : mitbringsel) {
			    final IListItem<Boolean> item = mitbringselCreator.create(terminMitbringsel);
			    addHandlerRegistration(item.addTapHandler(new TapHandler() {
				@Override
				public void onTap(final TapEvent event) {
				    final boolean checked = checkMitbringsel(item, terminMitbringsel);
				    item.setValue(checked);
				}

			    }));
			}
		    }
		    mitbringselCreator.onFinish(mitbringsel != null && mitbringsel.size() > 0);
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

    private boolean checkTeilnehmer(final ITerminTeilnehmer terminTeilnehmer, final Long terminId, final ETeilnahmeStatus status) {
	if (!terminTeilnehmer.isChangeAllowed())
	    return false;
	terminTeilnehmer.setTeilnahme(status);
	final IDMixedUsecase service = _clientFactory.getService();
	final TeilnahmeData teilnahmeData = new TeilnahmeData();
	teilnahmeData.setId(userId);
	teilnahmeData.setTerminId(terminId);
	teilnahmeData.setTeilnahme(status);
	final IAsync<Void> answer = new IAsync<Void>() {
	    @Override
	    public void onSuccess(final Void t) {
	    }

	    @Override
	    public void onError(final Throwable exception) {
		exception.printStackTrace();
	    }
	};
	service.onTeilnahme(teilnahmeData, answer);
	// Fire newValue to server
	return true;
    }

    private boolean checkMitbringsel(final IListItem<Boolean> item, final ITerminMitbringsel terminMitbringsel) {
	final ITerminTeilnehmer mitbringer = terminMitbringsel.getMitbringer();
	final IDMixedUsecase service = _clientFactory.getService();
	if (mitbringer == null) {
	    // Es bringt noch keiner mit
	    final TerminTeilnehmer ich = new TerminTeilnehmer();
	    ich.setId(userId);
	    // ich.setVorname(user.getVorname());
	    // ich.setName(user.getName());
	    terminMitbringsel.setMitbringer(ich);
	    final MitbringData mitbringData = new MitbringData();
	    mitbringData.setMitbringselId(terminMitbringsel.getId());
	    mitbringData.setTerminId(terminId);
	    mitbringData.setId(userId);
	    mitbringData.setMitbringen(true);
	    final IAsync<Void> answer = new IAsync<Void>() {
		@Override
		public void onSuccess(final Void t) {
		    item.setMitbringer("*");
		}

		@Override
		public void onError(final Throwable exception) {
		    exception.printStackTrace();
		}
	    };
	    service.onMitbringen(mitbringData, answer);
	    // Fire ich brings mit
	    return true;
	} else {
	    // Es bringt schon einer mit
	    final Long id = mitbringer.getId();
	    if (id.equals(userId)) {
		// Ich war eingetragen
		terminMitbringsel.setMitbringer(null);
		final MitbringData mitbringData = new MitbringData();
		mitbringData.setMitbringselId(terminMitbringsel.getId());
		mitbringData.setTerminId(terminId);
		mitbringData.setId(userId);
		mitbringData.setMitbringen(false);
		final IAsync<Void> answer = new IAsync<Void>() {
		    @Override
		    public void onSuccess(final Void t) {
			item.setMitbringer(null);
		    }

		    @Override
		    public void onError(final Throwable exception) {
			exception.printStackTrace();
		    }
		};
		service.onMitbringen(mitbringData, answer);
		// Fire ich brings nicht mehr mit
		return false;
	    } else {
		// Ich darf das nicht
		return true;
	    }
	}
    }
}
