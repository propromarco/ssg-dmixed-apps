package com.appspot.ssg.dmixed.client.activities;

import java.util.Date;
import java.util.List;

import com.appspot.ssg.dmixed.client.ClientFactory;
import com.appspot.ssg.dmixed.client.activities.TerminTeilnahmeActivity.TerminView.IListCreator;
import com.appspot.ssg.dmixed.client.activities.TerminTeilnahmeActivity.TerminView.IListItem;
import com.appspot.ssg.dmixed.client.model.TeilnahmeData;
import com.appspot.ssg.dmixed.shared.ETeilnahmeStatus;
import com.appspot.ssg.dmixed.shared.IAsync;
import com.appspot.ssg.dmixed.shared.IDMixedUsecase;
import com.appspot.ssg.dmixed.shared.ITerminDetails;
import com.appspot.ssg.dmixed.shared.ITerminTeilnehmer;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.HasValue;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;

public class TerminTeilnahmeActivity extends MGWTAbstractActivity {

    public interface TerminView extends IDMixedView {

	public interface IListItem extends HasValue<ETeilnahmeStatus>, HasTapHandlers {
	    void setMitbringer(String string);

	    void setEnabled(boolean enabled);
	}

	public interface IListCreator<T> {
	    IListItem create(T t);

	    void onFinish(boolean hasItems);
	}

	IListCreator<ITerminTeilnehmer> fillTeilnehmer();

    }

    private final ClientFactory _clientFactory;
    private final Long terminId;
    private final Long userId;

    public TerminTeilnahmeActivity(final ClientFactory clientFactory, final Long userId, final Long terminId) {
	_clientFactory = clientFactory;
	this.userId = userId;
	this.terminId = terminId;
    }

    @Override
    public void start(final AcceptsOneWidget panel, final EventBus eventBus) {
	final TerminView terminView = _clientFactory.getTerminTeilnahmeView();
	final IDMixedUsecase service = _clientFactory.getService();
	panel.setWidget(terminView);
	final IAsync<ITerminDetails> answer = new IAsync<ITerminDetails>() {
	    @Override
	    public void onSuccess(final ITerminDetails termin) {
		if (termin != null) {
		    final Date termineDatum = termin.getTermineDatum();
		    final String terminKurzbeschreibung = termin.getTerminKurzbeschreibung();
		    final DateTimeFormat formatter = DateTimeFormat.getFormat("dd.MM.yyyy");
		    final String d = formatter.format(termineDatum);
		    final String title = terminKurzbeschreibung + " - " + d;
		    terminView.setHeaderText(title);
		    final List<ITerminTeilnehmer> teilnehmer = termin.getTeilnehmer();
		    final IListCreator<ITerminTeilnehmer> teilnehmerCreator = terminView.fillTeilnehmer();
		    for (final ITerminTeilnehmer terminTeilnehmer : teilnehmer) {
			final IListItem item = teilnehmerCreator.create(terminTeilnehmer);
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

}
