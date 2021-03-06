package com.appspot.ssg.dmixed.server.jpa;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.appspot.ssg.dmixed.server.IJPAAdapter;
import com.appspot.ssg.dmixed.server.beans.TerminCreate;
import com.appspot.ssg.dmixed.shared.ETeilnahmeStatus;

public class FakeAdapter implements IJPAAdapter {

    private final List<JPAUser> users = new ArrayList<JPAUser>();
    private final List<JPAKind> kinder = new ArrayList<JPAKind>();
    private final List<JPATermin> termine = new ArrayList<JPATermin>();
    private final List<JPAMitbringsel> mitbringsel = new ArrayList<JPAMitbringsel>();
    private final List<JPATerminMitbringsel> terminMitbringsels = new ArrayList<JPATerminMitbringsel>();
    private final List<JPALiga> liegen = new ArrayList<JPALiga>();

    public FakeAdapter() {
	final JPALiga liga = new JPALiga("DMixed");
	liga.setId(1l);
	liegen.add(liga);
	final JPAUser u1 = createUser(3000l, "Schwarz", true, "123@456.com");
	final JPAKind k1 = new JPAKind("Nuria", Date.valueOf("2006-02-24"));
	k1.setLiga(1l);
	k1.setFamilie(u1.getId());
	kinder.add(k1);
	users.add(u1);
	final JPAKind k2 = new JPAKind("Kiara", Date.valueOf("2003-02-04"));
	k2.setFamilie(u1.getId());
	k2.setLiga(1l);
	kinder.add(k2);
	mitbringsel.add(createMitbringsel(1l, "Kaffee"));
	mitbringsel.add(createMitbringsel(2l, "Kuchen"));
	final List<JPATerminMitbringsel> t = createTerminMitbringsel(mitbringsel, null);
	terminMitbringsels.addAll(t);
	termine.add(createTermin(1l, Date.valueOf("2013-04-25"), "neuer Termin 1", "Das ist die Beschreibung von Termin 1", false));
	termine.add(createTermin(2l, Date.valueOf("2013-04-30"), "neuer Termin 2", "Das ist die Beschreibung von Termin 2", true));
    }

    @Override
    public JPAUser findUser(final String name, final String email) {
	for (final JPAUser user : users) {
	    if (user.getName().equals(name) && user.getEmail().equals(email))
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
    public List<JPATermin> getTermine(final JPAUser user) {
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
    public void userOnTermin(final JPATermin termin, final JPAKind kind, final ETeilnahmeStatus teilnahme) {
	final List<JPATerminTeilnehmer> teilnehmer = getTeilnehmer(termin);
	JPATerminTeilnehmer tt = findTeilnehmer(teilnehmer, kind);
	if (tt == null && !teilnahme.equals(ETeilnahmeStatus.NichtEntschieden)) {
	    tt = new JPATerminTeilnehmer();
	    tt.setId(1l);
	    tt.setTermin(termin.getTerminId());
	    tt.setUser(kind.getId());
	    tt.setStatus(teilnahme);
	    teilnehmer.add(tt);
	} else if (tt != null && teilnahme.equals(ETeilnahmeStatus.NichtEntschieden)) {
	    teilnehmer.remove(tt);
	}
    }

    private JPATerminTeilnehmer findTeilnehmer(final List<JPATerminTeilnehmer> teilnehmer, final JPAKind user) {
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

    static JPAUser createUser(final Long id, final String name, final boolean admin, final String email) {
	final JPAUser user = new JPAUser();
	user.setId(id);
	user.setName(name);
	user.setAdmin(admin);
	user.setEmail(email);
	return user;
    }

    static JPATermin createTermin(final Long terminId, final java.util.Date termineDatum, final String terminKurzbeschreibung,
	    final String terminBeschreibung, final boolean heimspiel) {
	final JPATermin termin = new JPATermin();
	termin.setTerminId(terminId);
	termin.setTermineDatum(termineDatum.getTime());
	termin.setHeimspiel(heimspiel);
	termin.setTerminKurzbeschreibung(terminKurzbeschreibung);
	termin.setTerminBeschreibung(terminBeschreibung);
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
    public List<JPATerminTeilnehmer> getTeilnehmer(final JPATermin termin) {
	final List<JPATerminTeilnehmer> list = new ArrayList<JPATerminTeilnehmer>();
	for (final JPAUser user : users) {
	    final JPATerminTeilnehmer t = new JPATerminTeilnehmer();
	    t.setUser(user.getId());
	    t.setTermin(termin.getTerminId());
	    t.setStatus(ETeilnahmeStatus.NichtEntschieden);
	    list.add(t);
	}
	return list;
    }

    @Override
    public List<JPATerminMitbringsel> getMitbringsel(final JPATermin termin) {
	final List<JPATerminMitbringsel> list = new ArrayList<JPATerminMitbringsel>();
	for (final JPAMitbringsel mit : mitbringsel) {
	    final JPATerminMitbringsel t = new JPATerminMitbringsel();
	    t.setMitbringsel(mit.getMitbringselId());
	    t.setMitbringselId(1l);
	    t.setTermin(termin.getTerminId());
	    list.add(t);
	}
	return list;
    }

    @Override
    public JPAMitbringsel getMitbringsel(final JPATerminMitbringsel jpaTerminMitbringsel) {
	final Long mitbringsel2 = jpaTerminMitbringsel.getMitbringsel();
	for (final JPAMitbringsel mit : mitbringsel) {
	    if (mit.getMitbringselId().equals(mitbringsel2))
		return mit;
	}
	return null;
    }

    @Override
    public JPAUser getUser(final JPATerminMitbringsel jpaTerminMitbringsel) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<JPAKind> getKinder(final JPAUser user) {
	return kinder;
    }

    @Override
    public JPALiga getLiga(final Long liga) {
	// TODO Auto-generated method stub
	final JPALiga l = new JPALiga();
	l.setId(1l);
	l.setBezeichnung("D-MIXED");
	return l;
    }

    @Override
    public List<JPAKind> getKinder(final JPATermin termin) {
	return kinder;
    }

    @Override
    public JPAUser getUser(final JPAKind jpaKind) {
	return users.get(0);
    }

    @Override
    public List<JPAMitbringsel> getMitbringsel() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public JPATermin createTermin(final TerminCreate terminCreate) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<JPALiga> getLigen() {
	return liegen;
    }

    @Override
    public JPAKind getKinder(final Long kindId) {
	// TODO Auto-generated method stub
	return null;
    }

}
