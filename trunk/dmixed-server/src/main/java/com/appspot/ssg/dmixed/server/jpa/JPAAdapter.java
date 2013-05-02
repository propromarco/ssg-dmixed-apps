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
	final JPAUser nuria = FakeAdapter.createUser(null, "Nuria", "Schwarz", Date.valueOf("2006-02-24"), true, "123@456.com");
	final JPAUser kiara = FakeAdapter.createUser(null, "Kiara", "Schwarz", Date.valueOf("2003-02-04"), true, "123@456.com");
	final JPAMitbringsel kaffee = FakeAdapter.createMitbringsel(null, "Kaffee");
	final JPAMitbringsel kuchen = FakeAdapter.createMitbringsel(null, "Kuchen");
	final List<JPAMitbringsel> mitbringsel = new ArrayList<JPAMitbringsel>();
	mitbringsel.add(kaffee);
	mitbringsel.add(kuchen);
	final JPATermin termin1 = FakeAdapter.createTermin(null, Date.valueOf("2013-05-05"), "Bla", "Viel Bla Bla", false, null);
	final JPATermin termin2 = FakeAdapter.createTermin(null, Date.valueOf("2013-05-06"), "Bla", "Viel Bla Bla", true, null);
	final EntityManager em = emf.createEntityManager();
	try {
	    em.getTransaction().begin();
	    em.persist(nuria);
	    em.getTransaction().commit();
	    em.getTransaction().begin();
	    em.persist(kiara);
	    em.getTransaction().commit();
	    em.getTransaction().begin();
	    em.persist(kaffee);
	    em.getTransaction().commit();
	    em.getTransaction().begin();
	    em.persist(kuchen);
	    em.getTransaction().commit();
	    // for (final JPATerminMitbringsel jpaTerminMitbringsel : t) {
	    // em.getTransaction().begin();
	    // em.persist(jpaTerminMitbringsel);
	    // em.getTransaction().commit();
	    // }
	    em.getTransaction().begin();
	    em.persist(termin1);
	    em.getTransaction().commit();
	    em.getTransaction().begin();
	    em.persist(termin2);
	    em.getTransaction().commit();
	    final List<JPATerminMitbringsel> terminMitbringselFuerTermin2 = FakeAdapter.createTerminMitbringsel(mitbringsel, termin2);
	    for (final JPATerminMitbringsel i : terminMitbringselFuerTermin2) {
		em.getTransaction().begin();
		em.persist(i);
		em.getTransaction().commit();
	    }
	} catch (final Exception e) {
	    log.fine(e.getMessage());
	} finally {
	    em.close();
	}
    }

    public static JPAAdapter getInstance() {
	if (INSTANCE == null)
	    INSTANCE = new JPAAdapter();
	return INSTANCE;
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
	query.setParameter("vorname", vorname);
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
	// TODO Auto-generated method stub

    }

    @Override
    public void delUser(final JPAUser jpaUser) {
	// TODO Auto-generated method stub

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

}
