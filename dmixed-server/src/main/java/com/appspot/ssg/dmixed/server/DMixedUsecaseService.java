package com.appspot.ssg.dmixed.server;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.appspot.ssg.dmixed.server.beans.LoginData;
import com.appspot.ssg.dmixed.server.beans.TerminDetails;
import com.appspot.ssg.dmixed.server.beans.Termine;
import com.appspot.ssg.dmixed.server.beans.UserData;

@Path("dmixed")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class DMixedUsecaseService {

    @POST
    public UserData login(LoginData data) {
        // TODO Auto-generated method stub
        return null;
    }

    @GET
    @Path("termine/{userid}")
    public Termine termine(@PathParam("userid") Long userId) {
        // TODO Auto-generated method stub
        return new Termine();
    }

    @GET
    @Path("termin/{userid}/{terminId}")
    public TerminDetails termin(@PathParam("userid") Long userId, @PathParam("terminId") Long terminId) {
        // TODO Auto-generated method stub
        return new TerminDetails();
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
