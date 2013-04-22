package com.appspot.ssg.dmixed.server.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.appspot.ssg.dmixed.server.IJPAAdapter;

public class JPAAdapter implements IJPAAdapter {
    private final EntityManagerFactory _entityManagerFactory;

    public JPAAdapter() {
	_entityManagerFactory = EMFService.get();
    }

    @Override
    public JPAUser findUser(final String vorname, final String email) {
	final EntityManager entityManager = _entityManagerFactory.createEntityManager();
	final Query query = entityManager.createNamedQuery(JPAUser.FINDUSER);
	query.setParameter("vorname", vorname);
	query.setParameter("email", email);
	try {
	    final JPAUser singleResult = (JPAUser) query.getSingleResult();
	    // Match
	    return singleResult;
	} catch (final NoResultException e) {
	    // No Match
	    return null;
	} finally {
	    entityManager.close();
	}
    }

    @Override
    public JPAUser findUser(final Long userId) {
	final EntityManager entityManager = _entityManagerFactory.createEntityManager();
	try {
	    return entityManager.find(JPAUser.class, userId);
	} catch (final NoResultException e) {
	    // No Match
	    return null;
	} finally {
	    entityManager.close();
	}
    }

    @Override
    public List<JPATermin> getTermine() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public JPATermin getTermin(final Long terminId) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public JPATerminMitbringsel getTerminMitbringsel(final Long terminId, final Long mitbringId) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void userOnTermin(final JPAUser user, final JPATermin termin, final Boolean teilnahme) {
	// TODO Auto-generated method stub

    }

    @Override
    public void onUserToTerminMitbringen(final JPAUser user, final JPATermin termin, final JPATerminMitbringsel terminMitbringsel,
	    final Boolean mitbringen) {
	// TODO Auto-generated method stub

    }

    @Override
    public List<JPAUser> getUsers() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<JPAMitbringsel> getMitbringsel() {
	// TODO Auto-generated method stub
	return null;
    }

}
