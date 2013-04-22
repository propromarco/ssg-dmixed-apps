package com.appspot.ssg.dmixed.server.jpa;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.appspot.ssg.dmixed.server.IJPAAdapter;

public class FakeAdapter implements IJPAAdapter {

    private static FakeAdapter instance;
    private final List<JPAUser> users = new ArrayList<JPAUser>();
    private final List<JPATermin> termine = new ArrayList<JPATermin>();
    private final List<JPAMitbringsel> mitbringsel = new ArrayList<JPAMitbringsel>();

    private FakeAdapter() {
	users.add(createUser(1l, "Nuria", "Schwarz", Date.valueOf("2006-02-24"), true, "123@456.com"));
	users.add(createUser(2l, "Kiara", "Schwarz", Date.valueOf("2003-02-04"), true, "123@456.com"));
	mitbringsel.add(createMitbringsel(1l, "Kaffee"));
	mitbringsel.add(createMitbringsel(2l, "Kuchen"));
	termine.add(createTermin(1l, Date.valueOf("2013-04-25"), "neuer Termin 1", "Das ist die Beschreibung von Termin 1", false));
	termine.add(createTermin(2l, Date.valueOf("2013-04-30"), "neuer Termin 2", "Das ist die Beschreibung von Termin 2", true));
    }

    public static FakeAdapter getInstance() {
	if (instance == null)
	    instance = new FakeAdapter();
	return instance;
    }

    @Override
    public JPAUser findUser(final String vorname, final String email) {
	for (final JPAUser user : users) {
	    if (user.getVorname().equals(vorname) && user.getEmail().equals(email))
		return user;
	}
	return null;
    }

    @Override
    public JPAUser findUser(final Long userId) {
	for (final JPAUser user : users) {
	    if (user.getId().equals(userId))
		return user;
	}
	return null;
    }

    @Override
    public List<JPATermin> getTermine() {
	return termine;
    }

    @Override
    public JPATermin getTermin(final Long terminId) {
	for (final JPATermin termin : termine) {
	    if (termin.getTerminId().equals(terminId))
		return termin;
	}
	return null;
    }

    @Override
    public JPATerminMitbringsel getTerminMitbringsel(final Long terminId, final Long mitbringId) {
	final JPATermin termin = getTermin(terminId);
	final List<JPATerminMitbringsel> mitbringsel = termin.getMitbringsel();
	for (final JPATerminMitbringsel jpaTerminMitbringsel : mitbringsel) {
	    if (jpaTerminMitbringsel.getMitbringsel().getMitbringselId() == mitbringId)
		return jpaTerminMitbringsel;
	}
	return null;
    }

    @Override
    public void userOnTermin(final JPAUser user, final JPATermin termin, final Boolean teilnahme) {
	final List<JPATerminTeilnehmer> teilnehmer = termin.getTeilnehmer();
	JPATerminTeilnehmer tt = findTeilnehmer(teilnehmer, user);
	if (tt == null && teilnahme) {
	    tt = new JPATerminTeilnehmer();
	    tt.setId(1l);
	    tt.setTermin(termin);
	    tt.setUser(user);
	    teilnehmer.add(tt);
	} else if (tt != null && !teilnahme) {
	    teilnehmer.remove(tt);
	}
    }

    private JPATerminTeilnehmer findTeilnehmer(final List<JPATerminTeilnehmer> teilnehmer, final JPAUser user) {
	for (final JPATerminTeilnehmer terminTeilnehmer : teilnehmer) {
	    if (terminTeilnehmer.getUser() == user)
		return terminTeilnehmer;
	}
	return null;
    }

    @Override
    public void onUserToTerminMitbringen(final JPAUser user, final JPATermin termin, final JPATerminMitbringsel terminMitbringsel,
	    final Boolean mitbringen) {
	if (mitbringen)
	    terminMitbringsel.setUser(user);
	else
	    terminMitbringsel.setUser(null);
    }

    @Override
    public List<JPAUser> getUsers() {
	return users;
    }

    @Override
    public List<JPAMitbringsel> getMitbringsel() {
	return mitbringsel;
    }

    private JPAUser createUser(final Long id, final String vorname, final String name, final java.util.Date birthday, final boolean admin,
	    final String email) {
	final JPAUser user = new JPAUser();
	user.setId(id);
	user.setVorname(vorname);
	user.setName(name);
	user.setBirthday(birthday);
	user.setAdmin(admin);
	user.setEmail(email);
	return user;
    }

    private JPATermin createTermin(final Long terminId, final java.util.Date termineDatum, final String terminKurzbeschreibung,
	    final String terminBeschreibung, final boolean heimspiel) {
	final JPATermin termin = new JPATermin();
	termin.setTerminId(terminId);
	termin.setTermineDatum(termineDatum);
	termin.setHeimspiel(heimspiel);
	termin.setTerminKurzbeschreibung(terminKurzbeschreibung);
	termin.setTerminBeschreibung(terminBeschreibung);
	if (heimspiel)
	    termin.setMitbringsel(createTerminMitbringsel());
	return termin;
    }

    private List<JPATerminMitbringsel> createTerminMitbringsel() {
	final List<JPATerminMitbringsel> list = new ArrayList<JPATerminMitbringsel>();
	long i = 1;
	for (final JPAMitbringsel jpaMitbringsel : mitbringsel) {
	    final JPATerminMitbringsel m = new JPATerminMitbringsel();
	    m.setMitbringselId(i);
	    m.setMitbringsel(jpaMitbringsel);
	    list.add(m);
	    i++;
	}
	return list;
    }

    private JPAMitbringsel createMitbringsel(final long mitbringselId, final String bezeichnung) {
	final JPAMitbringsel m = new JPAMitbringsel();
	m.setMitbringselId(mitbringselId);
	m.setBezeichnung(bezeichnung);
	return m;
    }

}
