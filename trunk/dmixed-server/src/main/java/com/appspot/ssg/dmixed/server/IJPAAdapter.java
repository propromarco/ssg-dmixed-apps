package com.appspot.ssg.dmixed.server;

import java.util.List;

import com.appspot.ssg.dmixed.server.jpa.JPATermin;
import com.appspot.ssg.dmixed.server.jpa.JPATerminMitbringsel;
import com.appspot.ssg.dmixed.server.jpa.JPAUser;

public interface IJPAAdapter {

    JPAUser findUser(String username, String password);

    JPAUser findUser(Long userId);

    List<JPATermin> getTermine();

    JPATermin getTermin(Long terminId);

    JPATerminMitbringsel getTerminMitbringsel(Long terminId, Long mitbringId);

    void userOnTermin(JPAUser user, JPATermin termin, Boolean teilnahme);

    void onUserToTerminMitbringen(JPAUser user, JPATermin termin, JPATerminMitbringsel terminMitbringsel, Boolean mitbringen);

}
