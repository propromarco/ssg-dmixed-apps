package com.appspot.ssg.dmixed.server.jpa;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.appspot.ssg.dmixed.server.IJPAAdapter;

public class FakeAdapter implements IJPAAdapter {

    @Override
    public JPAUser findUser(String username, String password) {
        JPAUser user = new JPAUser();
        user.setId(1l);
        user.setVorname("Nuria");
        user.setName("Schwarz");
        user.setBirthday(Date.valueOf("2006-02-24"));
        user.setAdmin(true);
        return user;
    }

    @Override
    public JPAUser findUser(Long userId) {
        JPAUser user = new JPAUser();
        user.setId(1l);
        user.setVorname("Nuria");
        user.setName("Schwarz");
        user.setBirthday(Date.valueOf("2006-02-24"));
        user.setAdmin(true);
        return user;
    }

    @Override
    public List<JPATermin> getTermine() {
        List<JPATermin> list = new ArrayList<JPATermin>();
        list.add(createTermin(1l));
        list.add(createTermin(2l));
        return list;
    }

    private JPATermin createTermin(Long terminId) {
        JPATermin termin = new JPATermin();
        termin.setTerminId(terminId);
        termin.setTermineDatum(new java.util.Date());
        termin.setTerminKurzbeschreibung("Bla");
        return termin;
    }

    @Override
    public JPATermin getTermin(Long terminId) {
        JPATermin terminDetails = new JPATermin(1l, new java.util.Date(), "kurz", "lang");
        terminDetails.setHeimspiel(true);
        List<JPATerminMitbringsel> mitbringsel = new ArrayList<JPATerminMitbringsel>();
        mitbringsel.add(new JPATerminMitbringsel(12l));
        mitbringsel.add(new JPATerminMitbringsel(13l));
        terminDetails.setMitbringsel(mitbringsel);
        return terminDetails;
    }

    @Override
    public JPATerminMitbringsel getTerminMitbringsel(Long terminId, Long mitbringId) {
        return new JPATerminMitbringsel(12l);
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
