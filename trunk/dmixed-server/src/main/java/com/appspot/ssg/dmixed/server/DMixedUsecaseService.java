package com.appspot.ssg.dmixed.server;

import java.util.ArrayList;
import java.util.Date;
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
import com.appspot.ssg.dmixed.server.beans.TerminMitbringsel;
import com.appspot.ssg.dmixed.server.beans.Termine;
import com.appspot.ssg.dmixed.server.beans.UserData;
import com.appspot.ssg.dmixed.shared.ITerminMitbringsel;

@Path("dmixed")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DMixedUsecaseService {

    @POST
    public UserData login(LoginData data) {
        // TODO Auto-generated method stub
        return new UserData(1l, "Marco", "Schwarz", java.sql.Date.valueOf("1968-06-03"));
    }

    @GET
    @Path("termine/{userid}")
    public Termine termine(@PathParam("userid") Long userId) {
        // TODO Auto-generated method stub
        Termine termine = new Termine();
//        termine.getAll().add(new Termin(5l, new Date(), "Testme", false));
        termine.getAll().add(new Termin(6l, new Date(), "Testme", false));
        return termine;
    }

    @GET
    @Path("termin/{userid}/{terminId}")
    public TerminDetails termin(@PathParam("userid") Long userId, @PathParam("terminId") Long terminId) {
        // TODO Auto-generated method stub
        TerminDetails terminDetails = new TerminDetails(1l, new Date(), "kurz", "lang");
        terminDetails.setHeimspiel(true);
        List<ITerminMitbringsel> mitbringsel = new ArrayList<ITerminMitbringsel>();
        mitbringsel.add(new TerminMitbringsel(12l, "k.a."));
        mitbringsel.add(new TerminMitbringsel(13l, "k.a."));
        terminDetails.setMitbringsel(mitbringsel);
        return terminDetails;
    }

    @GET
    @Path("teilname/{userid}/{terminid}/{teilname}")
    public TerminDetails teilname(@PathParam("userid") Long userId, @PathParam("terminid") Long terminId, @PathParam("teilname") Boolean teilnahme) {
        // TODO Auto-generated method stub
        return new TerminDetails();
    }

    @GET
    @Path("mitringen/{userid}/{terminid}/{mitbringid}/{mitbringen}")
    public TerminDetails mitringen(@PathParam("userid") Long userId, @PathParam("terminid") Long terminId, @PathParam("mitbringid") Long mitbringId,
            @PathParam("mitbringen") Boolean mitbringen) {
        // TODO Auto-generated method stub
        return new TerminDetails();
    }

}
