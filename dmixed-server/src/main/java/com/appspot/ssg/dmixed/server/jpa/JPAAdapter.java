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
    public JPAUser findUser(String username, String password) {
        EntityManager entityManager = _entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery(JPAUser.FINDUSER);
        query.setParameter("username", username);
        query.setParameter("password", password);
        try {
            JPAUser singleResult = (JPAUser) query.getSingleResult();
            // Match
            return singleResult;
        }
        catch (NoResultException e) {
            // No Match
            return null;
        }
        finally {
            entityManager.close();
        }
    }

    @Override
    public JPAUser findUser(Long userId) {
        EntityManager entityManager = _entityManagerFactory.createEntityManager();
        try {
            return entityManager.find(JPAUser.class, userId);
        }
        catch (NoResultException e) {
            // No Match
            return null;
        }
        finally {
            entityManager.close();
        }
    }

    @Override
    public List<JPATermin> getTermine() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public JPATermin getTermin(Long terminId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public JPATerminMitbringsel getTerminMitbringsel(Long terminId, Long mitbringId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void userOnTermin(JPAUser user, JPATermin termin, Boolean teilnahme) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserToTerminMitbringen(JPAUser user, JPATermin termin, JPATerminMitbringsel terminMitbringsel, Boolean mitbringen) {
        // TODO Auto-generated method stub

    }

}
