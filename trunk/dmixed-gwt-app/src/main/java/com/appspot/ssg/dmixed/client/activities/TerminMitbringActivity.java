package com.appspot.ssg.dmixed.client.activities;

import java.util.Date;
import java.util.List;

import com.appspot.ssg.dmixed.client.ClientFactory;
import com.appspot.ssg.dmixed.client.activities.TerminMitbringActivity.TerminView.IListCreator;
import com.appspot.ssg.dmixed.client.activities.TerminMitbringActivity.TerminView.IListItem;
import com.appspot.ssg.dmixed.client.model.MitbringData;
import com.appspot.ssg.dmixed.client.model.TerminTeilnehmer;
import com.appspot.ssg.dmixed.shared.IAsync;
import com.appspot.ssg.dmixed.shared.IDMixedUsecase;
import com.appspot.ssg.dmixed.shared.ITerminDetails;
import com.appspot.ssg.dmixed.shared.ITerminMitbringsel;
import com.appspot.ssg.dmixed.shared.ITerminTeilnehmer;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.HasValue;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;

public class TerminMitbringActivity extends MGWTAbstractActivity {

    public interface TerminView extends IDMixedView {

	public interface IListItem extends HasValue<Boolean>, HasTapHandlers {
	    void setMitbringer(String string);
	}

	public interface IListCreator<T> {
	    IListItem create(T t);

	    void onFinish(boolean hasItems);
	}

	IListCreator<ITerminMitbringsel> fillMitbringsel();
    }

    private final ClientFactory _clientFactory;
    private final Long terminId;
    private final Long userId;

    public TerminMitbringActivity(final ClientFactory clientFactory, final Long userId, final Long terminId) {
	_clientFactory = clientFactory;
	this.userId = userId;
	this.terminId = terminId;
    }

    @Override
    public void start(final AcceptsOneWidget panel, final EventBus eventBus) {
	final TerminView terminView = _clientFactory.getTerminMitbringView();
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
		    final IListCreator<ITerminMitbringsel> mitbringselCreator = terminView.fillMitbringsel();
		    final List<ITerminMitbringsel> mitbringsel = termin.getMitbringsel();
		    if (mitbringsel != null) {
			for (final ITerminMitbringsel terminMitbringsel : mitbringsel) {
			    final IListItem item = mitbringselCreator.create(terminMitbringsel);
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

    private boolean checkMitbringsel(final IListItem item, final ITerminMitbringsel terminMitbringsel) {
	final ITerminTeilnehmer mitbringer = terminMitbringsel.getMitbringer();
	final IDMixedUsecase service = _clientFactory.getService();
	if (mitbringer == null) {
	    // Es bringt noch keiner mit
	    final TerminTeilnehmer ich = new TerminTeilnehmer();
	    ich.setId(userId);
//	    ich.setVorname(user.getVorname());
//	    ich.setName(user.getName());
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
