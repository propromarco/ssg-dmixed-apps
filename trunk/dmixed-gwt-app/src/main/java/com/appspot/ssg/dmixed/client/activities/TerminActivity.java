package com.appspot.ssg.dmixed.client.activities;

import java.util.Date;
import java.util.List;

import com.appspot.ssg.dmixed.client.ClientFactory;
import com.appspot.ssg.dmixed.client.DMixedModel;
import com.appspot.ssg.dmixed.client.activities.TerminActivity.TerminView.IListCreator;
import com.appspot.ssg.dmixed.client.activities.TerminActivity.TerminView.IListItem;
import com.appspot.ssg.dmixed.client.model.MitbringData;
import com.appspot.ssg.dmixed.client.model.TeilnahmeData;
import com.appspot.ssg.dmixed.client.model.TerminTeilnehmer;
import com.appspot.ssg.dmixed.shared.ETeilnahmeStatus;
import com.appspot.ssg.dmixed.shared.IAsync;
import com.appspot.ssg.dmixed.shared.IDMixedUsecase;
import com.appspot.ssg.dmixed.shared.ITerminDetails;
import com.appspot.ssg.dmixed.shared.ITerminMitbringsel;
import com.appspot.ssg.dmixed.shared.ITerminTeilnehmer;
import com.appspot.ssg.dmixed.shared.IUserData;
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
	}

	public interface IListCreator<T, P> {
	    IListItem<P> create(T t);

	    void onFinish(boolean hasItems);
	}

	void setTerminBeschreibung(String terminBeschreibung);

	IListCreator<ITerminTeilnehmer, ETeilnahmeStatus> fillTeilnehmer();

	IListCreator<ITerminMitbringsel, Boolean> fillMitbringsel();
    }

    private final ClientFactory _clientFactory;
    private final Long _terminId;

    public TerminActivity(final ClientFactory clientFactory, final Long terminId) {
	_clientFactory = clientFactory;
	_terminId = terminId;
    }

    @Override
    public void start(final AcceptsOneWidget panel, final EventBus eventBus) {
	final TerminView terminView = _clientFactory.getTerminView();
	final DMixedModel model = _clientFactory.getModel();
	final IDMixedUsecase service = _clientFactory.getService();
	panel.setWidget(terminView);
	final Long userId = model.getUser().getId();
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
		    final String terminBeschreibung = termin.getTerminBeschreibung();
		    terminView.setTerminBeschreibung(terminBeschreibung);
		    final List<ITerminTeilnehmer> teilnehmer = termin.getTeilnehmer();
		    final IListCreator<ITerminTeilnehmer, ETeilnahmeStatus> teilnehmerCreator = terminView.fillTeilnehmer();
		    for (final ITerminTeilnehmer terminTeilnehmer : teilnehmer) {
			final IListItem<ETeilnahmeStatus> item = teilnehmerCreator.create(terminTeilnehmer);
			addHandlerRegistration(item.addValueChangeHandler(new ValueChangeHandler<ETeilnahmeStatus>() {
			    @Override
			    public void onValueChange(final ValueChangeEvent<ETeilnahmeStatus> event) {
				final ETeilnahmeStatus newValue = event.getValue();
				if (checkTeilnehmer(terminTeilnehmer, termin.getTerminId(), newValue))
				    item.setValue(newValue);
			    }
			}));
			// TapHandler(new TapHandler() {
			// @Override
			// public void onTap(final TapEvent event) {
			// final boolean checked =
			// checkTeilnehmer(terminTeilnehmer,
			// termin.getTerminId());
			// item.setValue(checked);
			// }
			//
			// }));
		    }
		    teilnehmerCreator.onFinish(teilnehmer.size() > 0);
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
	service.getTermin(userId, _terminId, answer);
    }

    private boolean checkMitbringsel(final IListItem<Boolean> item, final ITerminMitbringsel terminMitbringsel) {
	final ITerminTeilnehmer mitbringer = terminMitbringsel.getMitbringer();
	final DMixedModel model = _clientFactory.getModel();
	final IDMixedUsecase service = _clientFactory.getService();
	final IUserData user = model.getUser();
	if (mitbringer == null) {
	    // Es bringt noch keiner mit
	    final TerminTeilnehmer ich = new TerminTeilnehmer();
	    ich.setId(user.getId());
	    ich.setVorname(user.getVorname());
	    ich.setName(user.getName());
	    terminMitbringsel.setMitbringer(ich);
	    final MitbringData mitbringData = new MitbringData();
	    mitbringData.setMitbringselId(terminMitbringsel.getId());
	    mitbringData.setTerminId(_terminId);
	    mitbringData.setUserId(user.getId());
	    mitbringData.setMitbringen(true);
	    final IAsync<Void> answer = new IAsync<Void>() {
		@Override
		public void onSuccess(final Void t) {
		    item.setMitbringer(user.getName());
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
	    final Long id2 = user.getId();
	    if (id.equals(id2)) {
		// Ich war eingetragen
		terminMitbringsel.setMitbringer(null);
		final MitbringData mitbringData = new MitbringData();
		mitbringData.setMitbringselId(terminMitbringsel.getId());
		mitbringData.setTerminId(_terminId);
		mitbringData.setUserId(user.getId());
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

    private boolean checkTeilnehmer(final ITerminTeilnehmer terminTeilnehmer, final Long terminId, final ETeilnahmeStatus status) {
	final Long id = terminTeilnehmer.getId();
	final Long id2 = _clientFactory.getModel().getUser().getId();
	if (!id.equals(id2))
	    return false;
	terminTeilnehmer.setTeilnahme(status);
	final IDMixedUsecase service = _clientFactory.getService();
	final TeilnahmeData teilnahmeData = new TeilnahmeData();
	teilnahmeData.setUserId(id2);
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
