package com.appspot.ssg.dmixed.server;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.appspot.ssg.dmixed.server.beans.LoginData;
import com.appspot.ssg.dmixed.server.beans.MitbringData;
import com.appspot.ssg.dmixed.server.beans.TeilnahmeData;
import com.appspot.ssg.dmixed.server.beans.Termin;
import com.appspot.ssg.dmixed.server.beans.TerminDetails;
import com.appspot.ssg.dmixed.server.beans.TerminMitbringsel;
import com.appspot.ssg.dmixed.server.beans.TerminTeilnehmer;
import com.appspot.ssg.dmixed.server.beans.Termine;
import com.appspot.ssg.dmixed.server.beans.UserData;
import com.appspot.ssg.dmixed.server.jpa.FakeAdapter;
import com.appspot.ssg.dmixed.server.jpa.JPATermin;
import com.appspot.ssg.dmixed.server.jpa.JPATerminMitbringsel;
import com.appspot.ssg.dmixed.server.jpa.JPATerminTeilnehmer;
import com.appspot.ssg.dmixed.server.jpa.JPAUser;
import com.appspot.ssg.dmixed.shared.ITerminMitbringsel;
import com.appspot.ssg.dmixed.shared.ITerminTeilnehmer;

@Path("dmixed")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DMixedUsecaseService {

    private final IJPAAdapter adapter;

    public DMixedUsecaseService() {
        adapter = FakeAdapter.getInstance();
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
    public Termine getTermine(@PathParam("userid") final Long userId) {
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
    public TerminDetails getTermin(@PathParam("userid") final Long userId, @PathParam("terminId") final Long terminId) {
        final JPAUser user = adapter.findUser(userId);
        if (user == null)
            return null;
        final JPATermin termin = adapter.getTermin(terminId);
        final TerminDetails terminDetails = copyToDetails(termin);
        return terminDetails;
    }

    @PUT
    @Path("teilnahme")
    public void onTeilnahme(final TeilnahmeData teilnahmeData) {
        final JPAUser user = adapter.findUser(teilnahmeData.getUserId());
        if (user == null)
            return;
        final JPATermin termin = adapter.getTermin(teilnahmeData.getTerminId());
        adapter.userOnTermin(user, termin, teilnahmeData.getTeilnahme());
    }

    @PUT
    @Path("mitringen")
    public void onMitringen(final MitbringData mitbringData) {
        final JPAUser user = adapter.findUser(mitbringData.getUserId());
        if (user == null)
            return;
        final JPATermin termin = adapter.getTermin(mitbringData.getTerminId());
        final JPATerminMitbringsel terminMitbringsel = adapter.getTerminMitbringsel(mitbringData.getTerminId(), mitbringData.getMitbringselId());
        adapter.onUserToTerminMitbringen(user, termin, terminMitbringsel, mitbringData.getMitbringen());
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
        final List<ITerminTeilnehmer> list = new ArrayList<ITerminTeilnehmer>();
        final List<JPAUser> users = this.adapter.getUsers();
        for (final JPAUser jpaUser : users) {
            final TerminTeilnehmer terminTeilnehmer = new TerminTeilnehmer();
            terminTeilnehmer.setVorname(jpaUser.getVorname());
            terminTeilnehmer.setName(jpaUser.getName());
            terminTeilnehmer.setTeilnahme(false);
            final List<JPATerminTeilnehmer> teilnehmer = termin.getTeilnehmer();
            for (final JPATerminTeilnehmer jpaTerminTeilnehmer : teilnehmer) {
                if (jpaTerminTeilnehmer.getId() == jpaUser.getId())
                    terminTeilnehmer.setTeilnahme(true);
            }
            list.add(terminTeilnehmer);
        }
        return list;
    }

    private List<ITerminMitbringsel> createMitbringsel(final JPATermin termin) {
        final List<ITerminMitbringsel> list = new ArrayList<ITerminMitbringsel>();
        final List<JPATerminMitbringsel> mitbringsel = termin.getMitbringsel();
        for (final JPATerminMitbringsel jpaTerminMitbringsel : mitbringsel) {
            final TerminMitbringsel m = new TerminMitbringsel();
            m.setId(jpaTerminMitbringsel.getMitbringselId());
            m.setBeschreibung(jpaTerminMitbringsel.getMitbringsel().getBezeichnung());
            m.setMitbringer(createMitbringer(jpaTerminMitbringsel.getUser()));
            list.add(m);
        }
        return list;
    }

    private ITerminTeilnehmer createMitbringer(final JPAUser user) {
        if (user == null)
            return null;
        final TerminTeilnehmer t = new TerminTeilnehmer();
        t.setVorname(user.getVorname());
        t.setName(user.getName());
        return t;
    }

}
