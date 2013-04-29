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
    private final List<JPATerminMitbringsel> terminMitbringsels = new ArrayList<JPATerminMitbringsel>();

    private FakeAdapter() {
	users.add(createUser(1l, "Nuria", "Schwarz", Date.valueOf("2006-02-24"), true, "123@456.com"));
	users.add(createUser(2l, "Kiara", "Schwarz", Date.valueOf("2003-02-04"), true, "123@456.com"));
	mitbringsel.add(createMitbringsel(1l, "Kaffee"));
	mitbringsel.add(createMitbringsel(2l, "Kuchen"));
	final List<JPATerminMitbringsel> t = createTerminMitbringsel(mitbringsel, null);
	terminMitbringsels.addAll(t);
	termine.add(createTermin(1l, Date.valueOf("2013-04-25"), "neuer Termin 1", "Das ist die Beschreibung von Termin 1", false, t));
	termine.add(createTermin(2l, Date.valueOf("2013-04-30"), "neuer Termin 2", "Das ist die Beschreibung von Termin 2", true, t));
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
	final List<JPATerminMitbringsel> mitbringsel = getMitbringsel(termin);
	for (final JPATerminMitbringsel jpaTerminMitbringsel : mitbringsel) {
	    if (jpaTerminMitbringsel.getMitbringsel().equals(mitbringId))
		return jpaTerminMitbringsel;
	}
	return null;
    }

    @Override
    public void userOnTermin(final JPAUser user, final JPATermin termin, final Boolean teilnahme) {
	final List<JPATerminTeilnehmer> teilnehmer = getTeilnehmer(termin);
	JPATerminTeilnehmer tt = findTeilnehmer(teilnehmer, user);
	if (tt == null && teilnahme) {
	    tt = new JPATerminTeilnehmer();
	    tt.setId(1l);
	    tt.setTermin(termin.getTerminId());
	    tt.setUser(user.getId());
	    teilnehmer.add(tt);
	} else if (tt != null && !teilnahme) {
	    teilnehmer.remove(tt);
	}
    }

    private JPATerminTeilnehmer findTeilnehmer(final List<JPATerminTeilnehmer> teilnehmer, final JPAUser user) {
	for (final JPATerminTeilnehmer terminTeilnehmer : teilnehmer) {
	    if (terminTeilnehmer.getUser() == user.getId())
		return terminTeilnehmer;
	}
	return null;
    }

    @Override
    public void onUserToTerminMitbringen(final JPAUser user, final JPATermin termin, final JPATerminMitbringsel terminMitbringsel,
	    final Boolean mitbringen) {
	if (mitbringen)
	    terminMitbringsel.setUser(user.getId());
	else
	    terminMitbringsel.setUser(null);
    }

    @Override
    public List<JPAUser> getUsers() {
	return users;
    }

    static JPAUser createUser(final Long id, final String vorname, final String name, final java.util.Date birthday, final boolean admin,
	    final String email) {
	final JPAUser user = new JPAUser();
	user.setId(id);
	user.setVorname(vorname);
	user.setName(name);
	user.setBirthday(birthday.getTime());
	user.setAdmin(admin);
	user.setEmail(email);
	return user;
    }

    static JPATermin createTermin(final Long terminId, final java.util.Date termineDatum, final String terminKurzbeschreibung,
	    final String terminBeschreibung, final boolean heimspiel, final List<JPATerminMitbringsel> terminMitbringsel) {
	final JPATermin termin = new JPATermin();
	termin.setTerminId(terminId);
	termin.setTermineDatum(termineDatum.getTime());
	termin.setHeimspiel(heimspiel);
	termin.setTerminKurzbeschreibung(terminKurzbeschreibung);
	termin.setTerminBeschreibung(terminBeschreibung);
	if (heimspiel) {
	    // for (final JPATerminMitbringsel t : terminMitbringsel) {
	    // t.setTermin(terminId);
	    // }
	    // termin.setMitbringsel(terminMitbringsel);
	    // for (final JPATerminMitbringsel jpaTerminMitbringsel :
	    // terminMitbringsel) {
	    // jpaTerminMitbringsel.setTermin(termin);
	    // }
	}
	return termin;
    }

    static List<JPATerminMitbringsel> createTerminMitbringsel(final List<JPAMitbringsel> mitbringsel, final JPATermin termin) {
	final List<JPATerminMitbringsel> list = new ArrayList<JPATerminMitbringsel>();
	long i = 1;
	for (final JPAMitbringsel jpaMitbringsel : mitbringsel) {
	    final JPATerminMitbringsel m = new JPATerminMitbringsel();
	    m.setMitbringselId(i);
	    m.setMitbringsel(jpaMitbringsel.getMitbringselId());
	    if (termin != null)
		m.setTermin(termin.getTerminId());
	    list.add(m);
	    i++;
	}
	return list;
    }

    static JPAMitbringsel createMitbringsel(final Long mitbringselId, final String bezeichnung) {
	final JPAMitbringsel m = new JPAMitbringsel();
	m.setMitbringselId(mitbringselId);
	m.setBezeichnung(bezeichnung);
	return m;
    }

    @Override
    public void newUser(final JPAUser jpaUser) {
	this.users.add(jpaUser);
    }

    @Override
    public void delUser(final JPAUser jpaUser) {
	this.users.remove(jpaUser);
    }

    @Override
    public JPATermin createTermin(final Boolean heimspiel) {
	final List<JPATerminMitbringsel> t = createTerminMitbringsel(mitbringsel, null);
	return createTermin((long) termine.size(), new Date(System.currentTimeMillis()), "", "", heimspiel, t);
    }

    @Override
    public void saveTermin(final JPATermin jpaTermin) {
	this.termine.add(jpaTermin);
    }

    @Override
    public List<JPATerminTeilnehmer> getTeilnehmer(final JPATermin termin) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<JPATerminMitbringsel> getMitbringsel(final JPATermin termin) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public JPAMitbringsel getMitbringsel(final JPATerminMitbringsel jpaTerminMitbringsel) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public JPAUser getUser(final JPATerminMitbringsel jpaTerminMitbringsel) {
	// TODO Auto-generated method stub
	return null;
    }

}
