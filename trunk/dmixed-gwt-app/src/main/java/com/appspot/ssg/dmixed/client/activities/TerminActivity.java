package com.appspot.ssg.dmixed.client.activities;

import java.util.Date;
import java.util.List;

import com.appspot.ssg.dmixed.client.ClientFactory;
import com.appspot.ssg.dmixed.client.activities.TerminActivity.TerminView.IListCreator;
import com.appspot.ssg.dmixed.client.activities.TerminActivity.TerminView.IListItem;
import com.appspot.ssg.dmixed.client.util.CheckUtil;
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
	    IListItem<B> create(T t, boolean loggedUser);
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
		    // final boolean heimspiel = termin.isHeimspiel();
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
			final IListItem<ETeilnahmeStatus> item = teilnehmerCreator.create(terminTeilnehmer, terminTeilnehmer.isChangeAllowed());
			if (!terminTeilnehmer.isChangeAllowed()) {
			    item.setEnabled(false);
			}
			addHandlerRegistration(item.addValueChangeHandler(new ValueChangeHandler<ETeilnahmeStatus>() {
			    @Override
			    public void onValueChange(final ValueChangeEvent<ETeilnahmeStatus> event) {
				final ETeilnahmeStatus newValue = event.getValue();
				if (CheckUtil.checkTeilnehmer(_clientFactory.getService(), userId, terminTeilnehmer, termin.getId(), newValue))
				    item.setValue(newValue);
			    }
			}));
		    }
		    // Mitbringen
		    final IListCreator<ITerminMitbringsel, Boolean> mitbringselCreator = terminView.fillMitbringsel();
		    final List<ITerminMitbringsel> mitbringsel = termin.getMitbringsel();
		    if (mitbringsel != null) {
			for (final ITerminMitbringsel terminMitbringsel : mitbringsel) {
			    final IListItem<Boolean> item = mitbringselCreator.create(terminMitbringsel, true);
			    addHandlerRegistration(item.addTapHandler(new TapHandler() {
				@Override
				public void onTap(final TapEvent event) {
				    final boolean checked = CheckUtil.checkMitbringsel(_clientFactory.getService(), userId, terminId, item,
					    terminMitbringsel);
				    item.setValue(checked);
				}

			    }));
			}
		    }
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