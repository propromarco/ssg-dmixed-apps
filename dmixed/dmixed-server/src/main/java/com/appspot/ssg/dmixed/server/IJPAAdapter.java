package com.appspot.ssg.dmixed.server;

import java.util.List;

import com.appspot.ssg.dmixed.server.beans.TerminCreate;
import com.appspot.ssg.dmixed.server.jpa.JPAKind;
import com.appspot.ssg.dmixed.server.jpa.JPALiga;
import com.appspot.ssg.dmixed.server.jpa.JPAMitbringsel;
import com.appspot.ssg.dmixed.server.jpa.JPATermin;
import com.appspot.ssg.dmixed.server.jpa.JPATerminMitbringsel;
import com.appspot.ssg.dmixed.server.jpa.JPATerminTeilnehmer;
import com.appspot.ssg.dmixed.server.jpa.JPAUser;
import com.appspot.ssg.dmixed.shared.ETeilnahmeStatus;

public interface IJPAAdapter {

    JPAUser findUser(String vorname, String email);

    JPAUser findUser(Long userId);

    List<JPATermin> getTermine(JPAUser user);

    JPATermin getTermin(Long terminId);

    JPATerminMitbringsel getTerminMitbringsel(Long terminId, Long mitbringId);

    void userOnTermin(JPATermin termin, JPAKind kind, ETeilnahmeStatus teilnahme);

    void onUserToTerminMitbringen(JPAUser user, JPATermin termin, JPATerminMitbringsel terminMitbringsel, Boolean mitbringen);

    List<JPAUser> getUsers();

    void newUser(JPAUser jpaUser);

    void delUser(JPAUser jpaUser);

    List<JPATerminTeilnehmer> getTeilnehmer(JPATermin termin);

    List<JPATerminMitbringsel> getMitbringsel(JPATermin termin);

    List<JPAMitbringsel> getMitbringsel();

    JPAMitbringsel getMitbringsel(JPATerminMitbringsel jpaTerminMitbringsel);

    JPAUser getUser(JPATerminMitbringsel jpaTerminMitbringsel);

    List<JPAKind> getKinder(JPAUser user);

    JPALiga getLiga(Long liga);

    List<JPAKind> getKinder(JPATermin termin);

    JPAUser getUser(JPAKind jpaKind);

    JPATermin createTermin(TerminCreate terminCreate);

    List<JPALiga> getLigen();

    JPAKind getKinder(Long kindId);

}
