/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import service.UserFacadeREST;
/**
 * REST Web Service
 *
 * @author phihung
 */
@Path("/user")
public class UsersResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UsersResource
     */
    public UsersResource() {
    }

    /**
     * Retrieves representation of an instance of user.UsersResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        UserFacadeREST uf = new UserFacadeREST();
        Gson gs = new Gson();
        
        return gs.toJson(uf.findAll());
    }

    /**
     * Sub-resource locator method for {name}
     */
    @Path("{name}")
    public UserResource getUserResource(@PathParam("name") String name) {
        return UserResource.getInstance(name);
    }
}
