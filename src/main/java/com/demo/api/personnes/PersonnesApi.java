package com.demo.api.personnes;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/personnes")
public class PersonnesApi {

    private static AnnuairePersonne annuaire = new AnnuairePersonne();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Personne> getPersonnes(){
        //ArrayList<Personne> resultat = new ArrayList<>();
        //resultat.add(new Personne("JC", "Dominguez"));
        //resultat.add(new Personne("Alain", "Dupont"));
        //return resultat;

        return annuaire.getList();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPersonne(Personne newPersonne){
        System.out.println(newPersonne);

        if(newPersonne.getNom().isBlank()) {
            // BAD REQUEST
           return Response
                   .status(Response.Status.BAD_REQUEST)
                   .entity("Le nom ne peut etre vide").build();
        }

        // OK
        annuaire.addPersonne(newPersonne);
        return Response.status(Response.Status.CREATED).entity(newPersonne).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonne(@PathParam("id") Integer id){
        Personne personne = annuaire.getPersonne(id);
        if(personne == null) {
            //  retourner 404
            return Response.status(404).entity("Id inexistant").build();
        }else{
            return Response.ok(personne).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public void deletePersonne(@PathParam("id") Integer id){
        annuaire.deletePersonne(id);
    }

    @PUT
    @Path("/{id}")
    public Response updatePersonne(Personne personne, @PathParam("id") Integer id){
        // BAD REQUEST
        if(!id.equals(personne.getId())){
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("id différents").build();
        }
        else { // NOT FOUND
            Personne p = annuaire.getPersonne(id);
            if(p == null) {
                //  retourner 404
                return Response
                        .status(Response.Status.NOT_FOUND)
                        .entity("Id inexistant").build();
        } else {

                // OK
                annuaire.updatePersonne(id, personne);
                return Response.ok().build();
            }
        }
    }

    @PATCH
    @Path("/{id}")
    public void patchPersonne(Personne personne, @PathParam("id") Integer id){
        annuaire.patchPersonne(id, personne);
    }
}
