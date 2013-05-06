package com.appspot.ssg.dmixed.server.jpa;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.appspot.ssg.dmixed.server.IJPAAdapter;
import com.appspot.ssg.dmixed.shared.ETeilnahmeStatus;

public class JPAAdapter implements IJPAAdapter {

    private final Logger log = Logger.getLogger(getClass().getName());
    private static JPAAdapter INSTANCE = null;

    private final EntityManagerFactory emf;

    private JPAAdapter() {
	emf = EMFService.get();
	final EntityManager em = emf.createEntityManager();
	try {
	    final JPALiga liga = createLiga(em, "D-Mixed");
	    final JPAUser u1 = createUser(em, "Hansen", false, "carola.hansen78@googlemail.com");
	    final JPAKind k1 = new JPAKind("Annika", Date.valueOf("2006-08-18"));
	    JPAUser.addKind(em, u1, k1);
	    JPALiga.addKind(em, liga, k1);
	    final JPAKind k2 = new JPAKind("Moritz", Date.valueOf("2006-08-18"));
	    JPAUser.addKind(em, u1, k2);
	    JPALiga.addKind(em, liga, k2);
	    final JPAUser u2 = createUser(em, "Sottong", false, "Fussmann@gmx.de");
	    final JPAKind k3 = new JPAKind("Paula", Date.valueOf("2006-01-14"));
	    JPAUser.addKind(em, u2, k3);
	    JPALiga.addKind(em, liga, k3);
	    final JPAKind k4 = new JPAKind("Lotta", Date.valueOf("2009-01-27"));
	    JPAUser.addKind(em, u2, k4);
	    JPALiga.addKind(em, liga, k4);
	    final JPAUser u3 = createUser(em, "Schwarz", true, "silvana.schwarz@web.de");
	    final JPAKind k5 = new JPAKind("Nuria", Date.valueOf("2006-02-24"));
	    JPAUser.addKind(em, u3, k5);
	    JPALiga.addKind(em, liga, k5);
	    final JPAUser u4 = createUser(em, "Freund", false, "dfreund@arcor.de");
	    final JPAKind k6 = new JPAKind("Moritz", Date.valueOf("2006-01-12"));
	    JPAUser.addKind(em, u4, k6);
	    JPALiga.addKind(em, liga, k6);
	    final JPAKind k7 = new JPAKind("Janek", Date.valueOf("2007-01-02"));
	    JPAUser.addKind(em, u4, k7);
	    JPALiga.addKind(em, liga, k7);
	    final JPAUser u5 = createUser(em, "Scholz", false, "dr.scholz-bonn@gmx.net");
	    final JPAKind k8 = new JPAKind("Leo", Date.valueOf("2007-07-31"));
	    JPAUser.addKind(em, u5, k8);
	    JPALiga.addKind(em, liga, k8);
	    final JPAUser u6 = createUser(em, "Kulowig", false, "uschi.doering@gmx.de");
	    final JPAKind k9 = new JPAKind("Johanna", Date.valueOf("2005-08-31"));
	    JPAUser.addKind(em, u6, k9);
	    JPALiga.addKind(em, liga, k9);

	    final JPAMitbringsel kaffee = createMitbringsel(em, "Kaffee");
	    final JPAMitbringsel kuchen = createMitbringsel(em, "Kuchen");
	    final List<JPAMitbringsel> mitbringsel = new ArrayList<JPAMitbringsel>();
	    mitbringsel.add(kaffee);
	    mitbringsel.add(kuchen);
	    final JPATermin t1 = createTermin(em, Date.valueOf("2013-05-05"), "Bla", "Viel Bla Bla", false);
	    JPALiga.addTermin(em, liga, t1);
	    final JPATermin t2 = createTermin(em, Date.valueOf("2013-05-06"), "Bla", "Viel Bla Bla", true);
	    createMitbringsel(em, t2, mitbringsel);
	    JPALiga.addTermin(em, liga, t2);
	} catch (final Exception e) {
	    log.fine(e.getMessage());
	} finally {
	    em.close();
	}
    }

    private JPALiga createLiga(final EntityManager em, final String bezeichnung) {
	final JPALiga liga = new JPALiga(bezeichnung);
	em.getTransaction().begin();
	em.persist(liga);
	em.getTransaction().commit();
	return liga;
    }

    public static JPAAdapter getInstance() {
	if (INSTANCE == null)
	    INSTANCE = new JPAAdapter();
	return INSTANCE;
    }

    private JPAUser createUser(final EntityManager em, final String name, final boolean admin, final String email) {
	final JPAUser user = FakeAdapter.createUser(null, name, admin, email);
	em.getTransaction().begin();
	em.persist(user);
	em.getTransaction().commit();
	return user;
    }

    private JPAMitbringsel createMitbringsel(final EntityManager em, final String bezeichnung) {
	final JPAMitbringsel mitbringsel = FakeAdapter.createMitbringsel(null, bezeichnung);
	em.getTransaction().begin();
	em.persist(mitbringsel);
	em.getTransaction().commit();
	return mitbringsel;
    }

    private JPATermin createTermin(final EntityManager em, final java.util.Date terminDatum, final String kurz, final String beschreibung,
	    final boolean heimspiel) {
	final JPATermin termin = FakeAdapter.createTermin(null, terminDatum, kurz, beschreibung, heimspiel);
	em.getTransaction().begin();
	em.persist(termin);
	em.getTransaction().commit();
	return termin;
    }

    private List<JPATerminMitbringsel> createMitbringsel(final EntityManager em, final JPATermin termin, final List<JPAMitbringsel> mitbringsel) {
	final List<JPATerminMitbringsel> list = FakeAdapter.createTerminMitbringsel(mitbringsel, termin);
	for (final JPATerminMitbringsel item : list) {
	    em.getTransaction().begin();
	    em.persist(item);
	    em.getTransaction().commit();
	}
	return list;
    }

    @Override
    public JPAUser findUser(final String vorname, final String email) {
	final EntityManager em = emf.createEntityManager();
	// final CriteriaBuilder cb =
	// _entityManagerFactory.getCriteriaBuilder();
	// final CriteriaQuery<JPAUser> q = cb.createQuery(JPAUser.class);
	// final Root<JPAUser> from = q.from(JPAUser.class);
	// final Predicate equalVorname = cb.equal(from.get("vorname"),
	// vorname);
	// q.where(equalVorname);
	// final TypedQuery<JPAUser> query = em.createQuery(q);
	final Query query = em.createNamedQuery(JPAUser.FINDUSER);
	query.setParameter("name", vorname);
	query.setParameter("email", email);
	try {
	    final JPAUser user = (JPAUser) query.getSingleResult();
	    // Match
	    return user;
	} catch (final NoResultException e) {
	    // No Match
	    return null;
	} finally {
	    em.close();
	}
    }

    @Override
    public JPAUser findUser(final Long userId) {
	final EntityManager em = emf.createEntityManager();
	try {
	    return em.find(JPAUser.class, userId);
	} catch (final NoResultException e) {
	    // No Match
	    return null;
	} finally {
	    em.close();
	}
    }

    @Override
    public List<JPATermin> getTermine() {
	final EntityManager em = emf.createEntityManager();
	try {
	    final Query query = em.createNamedQuery(JPATermin.ALLE_TERMINE);
	    @SuppressWarnings("unchecked")
	    final List<JPATermin> termine = query.getResultList();
	    // Match
	    return termine;
	} catch (final NoResultException e) {
	    // No Match
	    return null;
	} finally {
	    em.close();
	}
    }

    @Override
    public JPATermin getTermin(final Long terminId) {
	final EntityManager em = emf.createEntityManager();
	try {
	    final JPATermin termin = em.find(JPATermin.class, terminId);
	    // Match
	    return termin;
	} catch (final NoResultException e) {
	    // No Match
	    return null;
	} finally {
	    em.close();
	}
    }

    @Override
    public JPATerminMitbringsel getTerminMitbringsel(final Long terminId, final Long mitbringId) {
	final EntityManager em = emf.createEntityManager();
	try {
	    final JPATerminMitbringsel terminMitbringsel = em.find(JPATerminMitbringsel.class, mitbringId);
	    // Match
	    return terminMitbringsel;
	} catch (final NoResultException e) {
	    // No Match
	    return null;
	} finally {
	    em.close();
	}
    }

    @Override
    public void userOnTermin(final JPAUser user, final JPATermin termin, final ETeilnahmeStatus teilnahme) {
	final EntityManager em = emf.createEntityManager();
	try {
	    final Query query = em.createNamedQuery(JPATerminTeilnehmer.EIN_TEILNEHMER_EINES_TERMINS);
	    query.setParameter("termin", termin.getTerminId());
	    query.setParameter("user", user.getId());
	    final JPATerminTeilnehmer terminTeilnehmer = (JPATerminTeilnehmer) query.getSingleResult();
	    terminTeilnehmer.setStatus(teilnahme);
	    em.persist(terminTeilnehmer);
	} catch (final NoResultException e) {
	    // No Match
	    final JPATerminTeilnehmer terminTeilnehmer = new JPATerminTeilnehmer(termin.getTerminId(), user.getId());
	    terminTeilnehmer.setStatus(teilnahme);
	    em.persist(terminTeilnehmer);
	} finally {
	    em.close();
	}
    }

    @Override
    public void onUserToTerminMitbringen(final JPAUser user, final JPATermin termin, final JPATerminMitbringsel terminMitbringsel,
	    final Boolean mitbringen) {
	final EntityManager em = emf.createEntityManager();
	try {
	    if (mitbringen)
		terminMitbringsel.setUser(user.getId());
	    else
		terminMitbringsel.setUser(null);
	    em.merge(terminMitbringsel);
	} finally {
	    em.close();
	}
    }

    @Override
    public List<JPAUser> getUsers() {
	final EntityManager em = emf.createEntityManager();
	try {
	    final Query query = em.createNamedQuery(JPAUser.ALLE_USER);
	    @SuppressWarnings("unchecked")
	    final List<JPAUser> users = query.getResultList();
	    // Match
	    return users;
	} catch (final NoResultException e) {
	    // No Match
	    return null;
	} finally {
	    em.close();
	}
    }

    @Override
    public void newUser(final JPAUser jpaUser) {
	final EntityManager em = emf.createEntityManager();
	try {
	    em.persist(jpaUser);
	} finally {
	    em.close();
	}
    }

    @Override
    public void delUser(final JPAUser jpaUser) {
	final EntityManager em = emf.createEntityManager();
	try {
	    em.remove(jpaUser);
	} finally {
	    em.close();
	}
    }

    @Override
    public JPATermin createTermin(final Boolean heimspiel) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void saveTermin(final JPATermin jpaTermin) {
	// TODO Auto-generated method stub

    }

    @Override
    public List<JPATerminTeilnehmer> getTeilnehmer(final JPATermin termin) {
	final EntityManager em = emf.createEntityManager();
	final Query query = em.createNamedQuery(JPATerminTeilnehmer.TEILNEHMER_EINES_TERMINS);
	query.setParameter("termin", termin.getTerminId());
	try {
	    @SuppressWarnings("unchecked")
	    final List<JPATerminTeilnehmer> teilnehmers = query.getResultList();
	    // Match
	    return teilnehmers;
	} finally {
	    em.close();
	}
    }

    @Override
    public List<JPATerminMitbringsel> getMitbringsel(final JPATermin termin) {
	final EntityManager em = emf.createEntityManager();
	final Query query = em.createNamedQuery(JPATerminMitbringsel.MITBRINGSEL_EINES_TERMINS);
	query.setParameter("termin", termin.getTerminId());
	try {
	    @SuppressWarnings("unchecked")
	    final List<JPATerminMitbringsel> mitbringsels = query.getResultList();
	    // Match
	    return mitbringsels;
	} finally {
	    em.close();
	}
    }

    @Override
    public JPAMitbringsel getMitbringsel(final JPATerminMitbringsel terminMitbringsel) {
	final EntityManager em = emf.createEntityManager();
	try {
	    final Long mitbringsel = terminMitbringsel.getMitbringsel();
	    final JPAMitbringsel jpaMitbringsel = em.find(JPAMitbringsel.class, mitbringsel);
	    // Match
	    return jpaMitbringsel;
	} catch (final NoResultException e) {
	    // No Match
	    return null;
	} finally {
	    em.close();
	}
    }

    @Override
    public JPAUser getUser(final JPATerminMitbringsel terminMitbringsel) {
	final EntityManager em = emf.createEntityManager();
	try {
	    final Long user = terminMitbringsel.getUser();
	    if (user == null)
		return null;
	    final JPAUser jpaUser = em.find(JPAUser.class, user);
	    // Match
	    return jpaUser;
	} catch (final NoResultException e) {
	    // No Match
	    return null;
	} finally {
	    em.close();
	}
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<JPAKind> getKinder(final JPAUser user) {
	final EntityManager em = emf.createEntityManager();
	try {
	    final Query namedQuery = em.createNamedQuery(JPAKind.KINDER_DER_ELTERN);
	    namedQuery.setParameter("familie", user.getId());
	    final List<JPAKind> list = namedQuery.getResultList();
	    return list;
	} finally {
	    em.close();
	}
    }

    @Override
    public JPALiga getLiga(final Long liga) {
	final EntityManager em = emf.createEntityManager();
	try {
	    final JPALiga jpaLiga = em.find(JPALiga.class, liga);
	    // Match
	    return jpaLiga;
	} catch (final NoResultException e) {
	    // No Match
	    return null;
	} finally {
	    em.close();
	}
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<JPAKind> getKinder(final JPATermin termin) {
	final EntityManager em = emf.createEntityManager();
	try {
	    final Query namedQuery = em.createNamedQuery(JPAKind.KINDER_DER_LIGA);
	    namedQuery.setParameter("liga", termin.getLiga());
	    final List<JPAKind> list = namedQuery.getResultList();
	    return list;
	} finally {
	    em.close();
	}
    }

    @Override
    public JPAUser getUser(final JPAKind jpaKind) {
	final EntityManager em = emf.createEntityManager();
	try {
	    final JPAUser jpaUser = em.find(JPAUser.class, jpaKind.getFamilie());
	    // Match
	    return jpaUser;
	} catch (final NoResultException e) {
	    // No Match
	    return null;
	} finally {
	    em.close();
	}
    }

}
