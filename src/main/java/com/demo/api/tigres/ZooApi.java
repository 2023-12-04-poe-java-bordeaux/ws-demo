package com.demo.api.tigres;

import com.demo.api.personnes.AnnuairePersonne;
import com.demo.api.personnes.Personne;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/tigres")
public class ZooApi {

    private static Zoo zoo = new Zoo();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tigre> getAll(){
        return zoo.getAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void add(Tigre t){
        zoo.add(t);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Tigre getById(@PathParam("id") Integer id){
        return zoo.getById(id);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Integer id){
        zoo.delete(id);
    }

    @PUT
    @Path("/{id}")
    public void update(Tigre t, @PathParam("id") Integer id){
        zoo.update(id, t);
    }

    @PATCH
    @Path("/{id}")
    public void patch(Tigre t, @PathParam("id") Integer id){
        zoo.patch(id, t);
    }
}
