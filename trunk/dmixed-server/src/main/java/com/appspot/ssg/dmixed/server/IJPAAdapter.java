package com.appspot.ssg.dmixed.server;

import java.util.List;

import com.appspot.ssg.dmixed.server.jpa.JPAMitbringsel;
import com.appspot.ssg.dmixed.server.jpa.JPATermin;
import com.appspot.ssg.dmixed.server.jpa.JPATerminMitbringsel;
import com.appspot.ssg.dmixed.server.jpa.JPATerminTeilnehmer;
import com.appspot.ssg.dmixed.server.jpa.JPAUser;
import com.appspot.ssg.dmixed.shared.ETeilnahmeStatus;

public interface IJPAAdapter {

    JPAUser findUser(String vorname, String email);

    JPAUser findUser(Long userId);

    List<JPATermin> getTermine();

    JPATermin getTermin(Long terminId);

    JPATerminMitbringsel getTerminMitbringsel(Long terminId, Long mitbringId);

    void userOnTermin(JPAUser user, JPATermin termin, ETeilnahmeStatus teilnahme);

    void onUserToTerminMitbringen(JPAUser user, JPATermin termin, JPATerminMitbringsel terminMitbringsel, Boolean mitbringen);

    List<JPAUser> getUsers();

    void newUser(JPAUser jpaUser);

    void delUser(JPAUser jpaUser);

    JPATermin createTermin(Boolean heimspiel);

    void saveTermin(JPATermin jpaTermin);

    List<JPATerminTeilnehmer> getTeilnehmer(JPATermin termin);

    List<JPATerminMitbringsel> getMitbringsel(JPATermin termin);

    JPAMitbringsel getMitbringsel(JPATerminMitbringsel jpaTerminMitbringsel);

    JPAUser getUser(JPATerminMitbringsel jpaTerminMitbringsel);

}
