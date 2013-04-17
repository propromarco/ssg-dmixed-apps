package com.appspot.ssg.dmixed.server;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.appspot.ssg.dmixed.server.beans.LoginData;
import com.appspot.ssg.dmixed.server.beans.Termin;
import com.appspot.ssg.dmixed.server.beans.TerminDetails;
import com.appspot.ssg.dmixed.server.beans.Termine;
import com.appspot.ssg.dmixed.server.beans.UserData;
import com.appspot.ssg.dmixed.server.jpa.FakeAdapter;
import com.appspot.ssg.dmixed.server.jpa.JPATermin;
import com.appspot.ssg.dmixed.server.jpa.JPATerminMitbringsel;
import com.appspot.ssg.dmixed.server.jpa.JPAUser;
import com.appspot.ssg.dmixed.shared.ITerminMitbringsel;
import com.appspot.ssg.dmixed.shared.ITerminTeilnehmer;

@Path("dmixed")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DMixedUsecaseService {

    private final IJPAAdapter adapter;

    public DMixedUsecaseService() {
        adapter = new FakeAdapter();
    }

    @POST
    public UserData login(final LoginData data) {
        final String vorname = data.getVorname();
        final String email = data.getEmail();
        final JPAUser user = adapter.findUser(vorname, email);
        if (user == null) {
            return null;
        }
        else {
            final UserData userData = new UserData();
            userData.setAdmin(user.isAdmin());
            userData.setBirthday(user.getBirthday());
            userData.setId(user.getId());
            userData.setName(user.getName());
            userData.setVorname(user.getName());
            return userData;
        }
    }

    @GET
    @Path("termine/{userid}")
    public Termine termine(@PathParam("userid") final Long userId) {
        final JPAUser user = adapter.findUser(userId);
        if (user == null)
            return null;
        final List<JPATermin> jpaTermine = adapter.getTermine();
        final Termine termine = new Termine();
        for (final JPATermin jpaTermin : jpaTermine) {
            final Termin termin = new Termin();
            termin.setTerminId(jpaTermin.getTerminId());
            termin.setTermineDatum(jpaTermin.getTermineDatum());
            termin.setTerminKurzbeschreibung(jpaTermin.getTerminKurzbeschreibung());
            termine.getAll().add(termin);
        }
        return termine;
    }

    @GET
    @Path("termin/{userid}/{terminId}")
    public TerminDetails termin(@PathParam("userid") final Long userId, @PathParam("terminId") final Long terminId) {
        final JPAUser user = adapter.findUser(userId);
        if (user == null)
            return null;
        final JPATermin termin = adapter.getTermin(terminId);
        final TerminDetails terminDetails = copyToDetails(termin);
        return terminDetails;
    }

    @GET
    @Path("teilname/{userid}/{terminid}/{teilname}")
    public TerminDetails teilname(@PathParam("userid") final Long userId, @PathParam("terminid") final Long terminId,
            @PathParam("teilname") final Boolean teilnahme) {
        final JPAUser user = adapter.findUser(userId);
        if (user == null)
            return null;
        final JPATermin termin = adapter.getTermin(terminId);
        adapter.userOnTermin(user, termin, teilnahme);
        final TerminDetails terminDetails = copyToDetails(termin);
        return terminDetails;
    }

    @GET
    @Path("mitringen/{userid}/{terminid}/{mitbringid}/{mitbringen}")
    public TerminDetails mitringen(@PathParam("userid") final Long userId, @PathParam("terminid") final Long terminId,
            @PathParam("mitbringid") final Long mitbringId, @PathParam("mitbringen") final Boolean mitbringen) {
        final JPAUser user = adapter.findUser(userId);
        if (user == null)
            return null;
        final JPATermin termin = adapter.getTermin(terminId);
        final JPATerminMitbringsel terminMitbringsel = adapter.getTerminMitbringsel(terminId, mitbringId);
        adapter.onUserToTerminMitbringen(user, termin, terminMitbringsel, mitbringen);
        final TerminDetails terminDetails = copyToDetails(termin);
        return terminDetails;
    }

    private TerminDetails copyToDetails(final JPATermin termin) {
        final TerminDetails terminDetails = new TerminDetails();
        terminDetails.setHeimspiel(termin.isHeimspiel());
        terminDetails.setMitbringsel(createMitbringsel(termin));
        terminDetails.setTeilnehmer(createTeilnehmer(termin));
        terminDetails.setTerminBeschreibung(termin.getTerminBeschreibung());
        terminDetails.setTermineDatum(termin.getTermineDatum());
        terminDetails.setTerminId(termin.getTerminId());
        terminDetails.setTerminKurzbeschreibung(termin.getTerminKurzbeschreibung());
        return terminDetails;
    }

    private List<ITerminTeilnehmer> createTeilnehmer(final JPATermin termin) {
        // TODO Auto-generated method stub
        return null;
    }

    private List<ITerminMitbringsel> createMitbringsel(final JPATermin termin) {
        // TODO Auto-generated method stub
        return null;
    }

}
