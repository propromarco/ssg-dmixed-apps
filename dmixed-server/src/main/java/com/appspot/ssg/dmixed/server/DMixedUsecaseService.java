package com.appspot.ssg.dmixed.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
import com.appspot.ssg.dmixed.server.beans.Users;
import com.appspot.ssg.dmixed.server.jpa.FakeAdapter;
import com.appspot.ssg.dmixed.server.jpa.JPAMitbringsel;
import com.appspot.ssg.dmixed.server.jpa.JPATermin;
import com.appspot.ssg.dmixed.server.jpa.JPATerminMitbringsel;
import com.appspot.ssg.dmixed.server.jpa.JPATerminTeilnehmer;
import com.appspot.ssg.dmixed.server.jpa.JPAUser;
import com.appspot.ssg.dmixed.shared.ETeilnahmeStatus;
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
	} else {
	    final UserData userData = new UserData();
	    userData.setAdmin(user.isAdmin());
	    userData.setBirthday(new Date(user.getBirthday()));
	    userData.setId(user.getId());
	    userData.setName(user.getName());
	    userData.setVorname(user.getVorname());
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
	    termin.setTermineDatum(new Date(jpaTermin.getTermineDatum()));
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
    @Path("mitbringen")
    public void onMitringen(final MitbringData mitbringData) {
	final JPAUser user = adapter.findUser(mitbringData.getUserId());
	if (user == null)
	    return;
	final JPATermin termin = adapter.getTermin(mitbringData.getTerminId());
	final JPATerminMitbringsel terminMitbringsel = adapter.getTerminMitbringsel(mitbringData.getTerminId(), mitbringData.getMitbringselId());
	adapter.onUserToTerminMitbringen(user, termin, terminMitbringsel, mitbringData.getMitbringen());
    }

    @GET
    @Path("users/{userid}")
    public Users getUsers(@PathParam("userId") final Long userId) {
	final JPAUser user = adapter.findUser(userId);
	if (user == null || !user.isAdmin())
	    return null;
	final List<JPAUser> users = adapter.getUsers();
	final Users newUsers = new Users();
	for (final JPAUser jpaUser : users) {
	    final UserData userData = new UserData();
	    userData.setId(jpaUser.getId());
	    userData.setAdmin(jpaUser.isAdmin());
	    userData.setBirthday(new Date(jpaUser.getBirthday()));
	    userData.setVorname(jpaUser.getVorname());
	    userData.setName(jpaUser.getName());
	    newUsers.getAll().add(userData);
	}
	return newUsers;
    }

    @PUT
    @Path("user/{userid}")
    public void newUser(@PathParam("userId") final Long userId, final UserData userData) {
	final JPAUser user = adapter.findUser(userId);
	if (user == null || !user.isAdmin())
	    return;
	final JPAUser jpaUser = createFrom(userData);
	this.adapter.newUser(jpaUser);
    }

    @DELETE
    @Path("user/{userid}")
    public void deleteUser(@PathParam("userId") final Long userId, final UserData userData) {
	final JPAUser user = adapter.findUser(userId);
	if (user == null || !user.isAdmin())
	    return;
	final JPAUser jpaUser = createFrom(userData);
	this.adapter.delUser(jpaUser);
    }

    @GET
    @Path("terminadmin/{userid}/{heimspiel}")
    public TerminDetails createTermin(@PathParam("userId") final Long userId, @PathParam("heimspiel") final Boolean heimspiel) {
	final JPAUser user = adapter.findUser(userId);
	if (user == null || !user.isAdmin())
	    return null;
	final JPATermin jpaTermin = adapter.createTermin(heimspiel);
	final TerminDetails terminDetails = copyFrom(jpaTermin);
	return terminDetails;
    }

    @PUT
    @Path("terminadmin/{userid}")
    public void saveTermin(@PathParam("userId") final Long userId, final TerminDetails terminDetails) {
	final JPAUser user = adapter.findUser(userId);
	if (user == null || !user.isAdmin())
	    return;
	final JPATermin jpaTermin = copyFrom(terminDetails);
	adapter.saveTermin(jpaTermin);
    }

    private JPATermin copyFrom(final TerminDetails terminDetails) {
	// TODO Auto-generated method stub
	return null;
    }

    private TerminDetails copyFrom(final JPATermin jpaTermin) {
	// TODO Auto-generated method stub
	return null;
    }

    private JPAUser createFrom(final UserData userData) {
	final JPAUser jpaUser = new JPAUser();
	jpaUser.setId(userData.getId());
	jpaUser.setAdmin(userData.isAdmin());
	jpaUser.setBirthday(userData.getBirthday().getTime());
	jpaUser.setVorname(userData.getVorname());
	jpaUser.setName(userData.getName());
	jpaUser.setEmail(userData.getEmail());
	return jpaUser;
    }

    private TerminDetails copyToDetails(final JPATermin termin) {
	final TerminDetails terminDetails = new TerminDetails();
	terminDetails.setHeimspiel(termin.isHeimspiel());
	terminDetails.setMitbringsel(createMitbringsel(termin));
	terminDetails.setTeilnehmer(createTeilnehmer(termin));
	terminDetails.setTerminBeschreibung(termin.getTerminBeschreibung());
	terminDetails.setTermineDatum(new Date(termin.getTermineDatum()));
	terminDetails.setTerminId(termin.getTerminId());
	terminDetails.setTerminKurzbeschreibung(termin.getTerminKurzbeschreibung());
	return terminDetails;
    }

    private List<ITerminTeilnehmer> createTeilnehmer(final JPATermin termin) {
	final List<ITerminTeilnehmer> list = new ArrayList<ITerminTeilnehmer>();
	final List<JPAUser> users = this.adapter.getUsers();
	for (final JPAUser jpaUser : users) {
	    final TerminTeilnehmer terminTeilnehmer = new TerminTeilnehmer();
	    terminTeilnehmer.setId(jpaUser.getId());
	    terminTeilnehmer.setVorname(jpaUser.getVorname());
	    terminTeilnehmer.setName(jpaUser.getName());
	    terminTeilnehmer.setTeilnahme(ETeilnahmeStatus.NichtEntschieden);
	    final List<JPATerminTeilnehmer> teilnehmer = adapter.getTeilnehmer(termin);
	    for (final JPATerminTeilnehmer jpaTerminTeilnehmer : teilnehmer) {
		if (jpaTerminTeilnehmer.getUser() == jpaUser.getId())
		    terminTeilnehmer.setTeilnahme(jpaTerminTeilnehmer.getStatus());
	    }
	    list.add(terminTeilnehmer);
	}
	return list;
    }

    private List<ITerminMitbringsel> createMitbringsel(final JPATermin termin) {
	final List<ITerminMitbringsel> list = new ArrayList<ITerminMitbringsel>();
	final List<JPATerminMitbringsel> mitbringsel = adapter.getMitbringsel(termin);
	for (final JPATerminMitbringsel jpaTerminMitbringsel : mitbringsel) {
	    final TerminMitbringsel m = new TerminMitbringsel();
	    m.setId(jpaTerminMitbringsel.getMitbringselId());
	    final JPAMitbringsel jpaMitbringsel = adapter.getMitbringsel(jpaTerminMitbringsel);
	    m.setBeschreibung(jpaMitbringsel.getBezeichnung());
	    m.setMitbringer(createMitbringer(adapter.getUser(jpaTerminMitbringsel)));
	    list.add(m);
	}
	return list;
    }

    private ITerminTeilnehmer createMitbringer(final JPAUser user) {
	if (user == null)
	    return null;
	final TerminTeilnehmer t = new TerminTeilnehmer();
	t.setId(user.getId());
	t.setVorname(user.getVorname());
	t.setName(user.getName());
	return t;
    }

}
