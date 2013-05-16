package com.appspot.ssg.dmixed.client.util;

import com.appspot.ssg.dmixed.client.activities.TerminActivity.TerminView.IListItem;
import com.appspot.ssg.dmixed.client.model.MitbringData;
import com.appspot.ssg.dmixed.client.model.TeilnahmeData;
import com.appspot.ssg.dmixed.client.model.TerminTeilnehmer;
import com.appspot.ssg.dmixed.shared.ETeilnahmeStatus;
import com.appspot.ssg.dmixed.shared.IAsync;
import com.appspot.ssg.dmixed.shared.IDMixedUsecase;
import com.appspot.ssg.dmixed.shared.ITerminMitbringsel;
import com.appspot.ssg.dmixed.shared.ITerminTeilnehmer;

public class CheckUtil {
    public static boolean checkTeilnehmer(final IDMixedUsecase service, final Long userId, final ITerminTeilnehmer terminTeilnehmer,
	    final Long terminId, final ETeilnahmeStatus status) {
	if (!terminTeilnehmer.isChangeAllowed())
	    return false;
	terminTeilnehmer.setTeilnahme(status);
	final TeilnahmeData teilnahmeData = new TeilnahmeData();
	teilnahmeData.setId(userId);
	teilnahmeData.setTerminId(terminId);
	teilnahmeData.setKindId(terminTeilnehmer.getId());
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

    public static boolean checkMitbringsel(final IDMixedUsecase service, final Long userId, final Long terminId, final IListItem<Boolean> item,
	    final ITerminMitbringsel terminMitbringsel) {
	final ITerminTeilnehmer mitbringer = terminMitbringsel.getMitbringer();
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
