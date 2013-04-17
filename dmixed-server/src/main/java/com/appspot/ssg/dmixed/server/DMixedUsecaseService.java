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
    public UserData login(LoginData data) {
        String username = data.getUsername();
        String password = data.getPassword();
        JPAUser user = adapter.findUser(username, password);
        if (user == null) {
            return null;
        }
        else {
            UserData userData = new UserData();
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
    public Termine termine(@PathParam("userid") Long userId) {
        JPAUser user = adapter.findUser(userId);
        if (user == null)
            return null;
        List<JPATermin> jpaTermine = adapter.getTermine();
        Termine termine = new Termine();
        for (JPATermin jpaTermin : jpaTermine) {
            Termin termin = new Termin();
            termin.setTerminId(jpaTermin.getTerminId());
            termin.setTermineDatum(jpaTermin.getTermineDatum());
            termin.setTerminKurzbeschreibung(jpaTermin.getTerminKurzbeschreibung());
            termine.getAll().add(termin);
        }
        return termine;
    }

    @GET
    @Path("termin/{userid}/{terminId}")
    public TerminDetails termin(@PathParam("userid") Long userId, @PathParam("terminId") Long terminId) {
        JPAUser user = adapter.findUser(userId);
        if (user == null)
            return null;
        JPATermin termin = adapter.getTermin(terminId);
        TerminDetails terminDetails = copyToDetails(termin);
        return terminDetails;
    }

    @GET
    @Path("teilname/{userid}/{terminid}/{teilname}")
    public TerminDetails teilname(@PathParam("userid") Long userId, @PathParam("terminid") Long terminId, @PathParam("teilname") Boolean teilnahme) {
        JPAUser user = adapter.findUser(userId);
        if (user == null)
            return null;
        JPATermin termin = adapter.getTermin(terminId);
        adapter.userOnTermin(user, termin, teilnahme);
        TerminDetails terminDetails = copyToDetails(termin);
        return terminDetails;
    }

    @GET
    @Path("mitringen/{userid}/{terminid}/{mitbringid}/{mitbringen}")
    public TerminDetails mitringen(@PathParam("userid") Long userId, @PathParam("terminid") Long terminId, @PathParam("mitbringid") Long mitbringId,
            @PathParam("mitbringen") Boolean mitbringen) {
        JPAUser user = adapter.findUser(userId);
        if (user == null)
            return null;
        JPATermin termin = adapter.getTermin(terminId);
        JPATerminMitbringsel terminMitbringsel = adapter.getTerminMitbringsel(terminId, mitbringId);
        adapter.onUserToTerminMitbringen(user, termin, terminMitbringsel, mitbringen);
        TerminDetails terminDetails = copyToDetails(termin);
        return terminDetails;
    }

    private TerminDetails copyToDetails(JPATermin termin) {
        TerminDetails terminDetails = new TerminDetails();
        terminDetails.setHeimspiel(termin.isHeimspiel());
        terminDetails.setMitbringsel(createMitbringsel(termin));
        terminDetails.setTeilnehmer(createTeilnehmer(termin));
        terminDetails.setTerminBeschreibung(termin.getTerminBeschreibung());
        terminDetails.setTermineDatum(termin.getTermineDatum());
        terminDetails.setTerminId(termin.getTerminId());
        terminDetails.setTerminKurzbeschreibung(termin.getTerminKurzbeschreibung());
        return terminDetails;
    }

    private List<ITerminTeilnehmer> createTeilnehmer(JPATermin termin) {
        // TODO Auto-generated method stub
        return null;
    }

    private List<ITerminMitbringsel> createMitbringsel(JPATermin termin) {
        // TODO Auto-generated method stub
        return null;
    }

}
