package com.appspot.ssg.dmixed.server;

import static com.appspot.ssg.dmixed.shared.DMixedUrlCreator.MITBRINGEN_URL;
import static com.appspot.ssg.dmixed.shared.DMixedUrlCreator.NORMAL_CLIENT_URL;
import static com.appspot.ssg.dmixed.shared.DMixedUrlCreator.TEILNAHME_URL;
import static com.appspot.ssg.dmixed.shared.DMixedUrlCreator.TERMINADMIN_URL;
import static com.appspot.ssg.dmixed.shared.DMixedUrlCreator.TERMINE_URL;
import static com.appspot.ssg.dmixed.shared.DMixedUrlCreator.TERMIN_URL;
import static com.appspot.ssg.dmixed.shared.DMixedUrlCreator.USERS_URL;
import static com.appspot.ssg.dmixed.shared.DMixedUrlCreator.USER_URL;

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

import com.appspot.ssg.dmixed.server.beans.Kind;
import com.appspot.ssg.dmixed.server.beans.Liga;
import com.appspot.ssg.dmixed.server.beans.LoginData;
import com.appspot.ssg.dmixed.server.beans.MitbringData;
import com.appspot.ssg.dmixed.server.beans.TeilnahmeData;
import com.appspot.ssg.dmixed.server.beans.Termin;
import com.appspot.ssg.dmixed.server.beans.TerminCreate;
import com.appspot.ssg.dmixed.server.beans.TerminDetails;
import com.appspot.ssg.dmixed.server.beans.TerminMitbringsel;
import com.appspot.ssg.dmixed.server.beans.TerminTeilnehmer;
import com.appspot.ssg.dmixed.server.beans.Termine;
import com.appspot.ssg.dmixed.server.beans.UserData;
import com.appspot.ssg.dmixed.server.beans.Users;
import com.appspot.ssg.dmixed.server.jpa.JPAAdapter;
import com.appspot.ssg.dmixed.server.jpa.JPAKind;
import com.appspot.ssg.dmixed.server.jpa.JPALiga;
import com.appspot.ssg.dmixed.server.jpa.JPAMitbringsel;
import com.appspot.ssg.dmixed.server.jpa.JPATermin;
import com.appspot.ssg.dmixed.server.jpa.JPATerminMitbringsel;
import com.appspot.ssg.dmixed.server.jpa.JPATerminTeilnehmer;
import com.appspot.ssg.dmixed.server.jpa.JPAUser;
import com.appspot.ssg.dmixed.shared.ETeilnahmeStatus;
import com.appspot.ssg.dmixed.shared.ILiga;
import com.appspot.ssg.dmixed.shared.ITerminMitbringsel;
import com.appspot.ssg.dmixed.shared.ITerminTeilnehmer;

@Path(NORMAL_CLIENT_URL)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DMixedUsecaseService {

    private final IJPAAdapter adapter;

    public DMixedUsecaseService() {
	adapter = JPAAdapter.getInstance();
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
	    userData.setId(user.getId());
	    userData.setName(user.getName());
	    final List<JPAKind> kinder = adapter.getKinder(user);
	    for (final JPAKind jpaKind : kinder) {
		final Kind kind = createFrom(jpaKind);
		userData.getKinder().add(kind);
	    }
	    return userData;
	}
    }

    @GET
    @Path(TERMINE_URL + "/{userid}")
    public Termine getTermine(@PathParam("userid") final Long userId) {
	final JPAUser user = adapter.findUser(userId);
	if (user == null)
	    return null;
	final List<JPATermin> jpaTermine = adapter.getTermine(user);
	final Termine termine = new Termine();
	for (final JPATermin jpaTermin : jpaTermine) {
	    final Termin termin = new Termin();
	    termin.setId(jpaTermin.getTerminId());
	    termin.setTermineDatum(new Date(jpaTermin.getTermineDatum()));
	    termin.setTerminKurzbeschreibung(jpaTermin.getTerminKurzbeschreibung());
	    termin.setLiga(createFrom(adapter.getLiga(jpaTermin.getLiga())));
	    termine.getAll().add(termin);
	}
	return termine;
    }

    @GET
    @Path(TERMIN_URL + "/{userid}/{terminId}")
    public TerminDetails getTermin(@PathParam("userid") final Long userId, @PathParam("terminId") final Long terminId) {
	final JPAUser user = adapter.findUser(userId);
	if (user == null)
	    return null;
	final JPATermin termin = adapter.getTermin(terminId);
	final TerminDetails terminDetails = copyToDetails(user, termin, false);
	return terminDetails;
    }

    @PUT
    @Path(TEILNAHME_URL)
    public void onTeilnahme(final TeilnahmeData teilnahmeData) {
	final JPAUser user = adapter.findUser(teilnahmeData.getId());
	if (user == null)
	    return;
	final JPATermin termin = adapter.getTermin(teilnahmeData.getTerminId());
	adapter.userOnTermin(user, termin, teilnahmeData.getTeilnahme());
    }

    @PUT
    @Path(MITBRINGEN_URL)
    public void onMitringen(final MitbringData mitbringData) {
	final JPAUser user = adapter.findUser(mitbringData.getId());
	if (user == null)
	    return;
	final JPATermin termin = adapter.getTermin(mitbringData.getTerminId());
	final JPATerminMitbringsel terminMitbringsel = adapter.getTerminMitbringsel(mitbringData.getTerminId(), mitbringData.getMitbringselId());
	adapter.onUserToTerminMitbringen(user, termin, terminMitbringsel, mitbringData.getMitbringen());
    }

    @GET
    @Path(USERS_URL + "/{userid}")
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
	    userData.setName(jpaUser.getName());
	    newUsers.getAll().add(userData);
	}
	return newUsers;
    }

    @PUT
    @Path(USER_URL + "/{userid}")
    public void newUser(@PathParam("userId") final Long userId, final UserData userData) {
	final JPAUser user = adapter.findUser(userId);
	if (user == null || !user.isAdmin())
	    return;
	final JPAUser jpaUser = createFrom(userData);
	this.adapter.newUser(jpaUser);
    }

    @DELETE
    @Path(USER_URL + "/{userid}")
    public void deleteUser(@PathParam("userId") final Long userId, final UserData userData) {
	final JPAUser user = adapter.findUser(userId);
	if (user == null || !user.isAdmin())
	    return;
	final JPAUser jpaUser = createFrom(userData);
	this.adapter.delUser(jpaUser);
    }

    @POST
    @Path(TERMINADMIN_URL + "/{userid}")
    public TerminDetails createTermin(@PathParam("userId") final Long userId, final TerminCreate terminCreate) {
	final JPAUser user = adapter.findUser(userId);
	if (user == null || !user.isAdmin())
	    return null;
	final JPATermin jpaTermin = adapter.createTermin(terminCreate);
	final TerminDetails terminDetails = copyToDetails(user, jpaTermin, true);
	return terminDetails;
    }

    @PUT
    @Path(TERMINADMIN_URL + "/{userid}")
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

    private Kind createFrom(final JPAKind jpaKind) {
	final Kind kind = new Kind();
	kind.setId(jpaKind.getId());
	kind.setVorname(jpaKind.getVorname());
	kind.setBirthday(new Date(jpaKind.getBirthday()));
	kind.setLiga(createFrom(adapter.getLiga(jpaKind.getLiga())));
	return kind;
    }

    private ILiga createFrom(final JPALiga jpaLiga) {
	final Liga liga = new Liga();
	liga.setId(jpaLiga.getId());
	liga.setBezeichnung(jpaLiga.getBezeichnung());
	return liga;
    }

    private JPAUser createFrom(final UserData userData) {
	final JPAUser jpaUser = new JPAUser();
	jpaUser.setId(userData.getId());
	jpaUser.setAdmin(userData.isAdmin());
	jpaUser.setName(userData.getName());
	jpaUser.setEmail(userData.getEmail());
	return jpaUser;
    }

    private TerminDetails copyToDetails(final JPAUser user, final JPATermin termin, final boolean onCreate) {
	final TerminDetails terminDetails = new TerminDetails();
	final boolean heimspiel = termin.isHeimspiel();
	terminDetails.setHeimspiel(heimspiel);
	if (heimspiel)
	    terminDetails.setMitbringsel(createMitbringsel(termin, onCreate));
	terminDetails.setLiga(createLiga(termin));
	terminDetails.setTeilnehmer(createTeilnehmer(user, termin));
	terminDetails.setTerminBeschreibung(termin.getTerminBeschreibung());
	terminDetails.setTermineDatum(new Date(termin.getTermineDatum()));
	terminDetails.setId(termin.getTerminId());
	terminDetails.setTerminKurzbeschreibung(termin.getTerminKurzbeschreibung());
	return terminDetails;
    }

    private ILiga createLiga(final JPATermin termin) {
	final Liga liga = new Liga();
	final JPALiga jpaLiga = adapter.getLiga(termin.getLiga());
	liga.setId(jpaLiga.getId());
	liga.setBezeichnung(jpaLiga.getBezeichnung());
	return liga;
    }

    private List<ITerminTeilnehmer> createTeilnehmer(final JPAUser user, final JPATermin termin) {
	final List<ITerminTeilnehmer> list = new ArrayList<ITerminTeilnehmer>();
	final List<JPAKind> kinder = this.adapter.getKinder(termin);
	for (final JPAKind jpaKind : kinder) {
	    final TerminTeilnehmer terminTeilnehmer = new TerminTeilnehmer();
	    terminTeilnehmer.setId(jpaKind.getId());
	    terminTeilnehmer.setVorname(jpaKind.getVorname());
	    final JPAUser jpaUser = adapter.getUser(jpaKind);
	    final boolean changeAllowed = jpaUser.getId().equals(user.getId());
	    terminTeilnehmer.setChangeAllowed(changeAllowed);
	    terminTeilnehmer.setName(jpaUser.getName());
	    terminTeilnehmer.setTeilnahme(ETeilnahmeStatus.NichtEntschieden);
	    final List<JPATerminTeilnehmer> teilnehmer = adapter.getTeilnehmer(termin);
	    for (final JPATerminTeilnehmer jpaTerminTeilnehmer : teilnehmer) {
		if (jpaTerminTeilnehmer.getUser().equals(jpaKind.getId()))
		    terminTeilnehmer.setTeilnahme(jpaTerminTeilnehmer.getStatus());
	    }
	    list.add(terminTeilnehmer);
	}
	return list;
    }

    private List<ITerminMitbringsel> createMitbringsel(final JPATermin termin, final boolean onCreate) {
	final List<ITerminMitbringsel> list = new ArrayList<ITerminMitbringsel>();
	if (onCreate) {
	    final List<JPAMitbringsel> mitbringsel = adapter.getMitbringsel();
	    for (final JPAMitbringsel jpaMitbringsel : mitbringsel) {
		final TerminMitbringsel m = new TerminMitbringsel();
		m.setId(jpaMitbringsel.getMitbringselId());
		m.setBeschreibung(jpaMitbringsel.getBezeichnung());
		list.add(m);

	    }
	} else {
	    final List<JPATerminMitbringsel> mitbringsel = adapter.getMitbringsel(termin);
	    for (final JPATerminMitbringsel jpaTerminMitbringsel : mitbringsel) {
		final TerminMitbringsel m = new TerminMitbringsel();
		m.setId(jpaTerminMitbringsel.getMitbringselId());
		final JPAMitbringsel jpaMitbringsel = adapter.getMitbringsel(jpaTerminMitbringsel);
		m.setBeschreibung(jpaMitbringsel.getBezeichnung());
		m.setMitbringer(createMitbringer(adapter.getUser(jpaTerminMitbringsel)));
		list.add(m);
	    }
	}
	return list;
    }

    private ITerminTeilnehmer createMitbringer(final JPAUser user) {
	if (user == null)
	    return null;
	final TerminTeilnehmer t = new TerminTeilnehmer();
	t.setId(user.getId());
	t.setName(user.getName());
	return t;
    }

}
