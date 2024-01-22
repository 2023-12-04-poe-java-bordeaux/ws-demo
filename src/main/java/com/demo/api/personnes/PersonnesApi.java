package com.demo.api.personnes;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

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
    public void addPersonne(Personne newPersonne){
        System.out.println(newPersonne);
        annuaire.addPersonne(newPersonne);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Personne getPersonne(@PathParam("id") Integer id){
        return annuaire.getPersonne(id);
    }

    @DELETE
    @Path("/{id}")
    public void deletePersonne(@PathParam("id") Integer id){
        annuaire.deletePersonne(id);
    }

    @PUT
    @Path("/{id}")
    public void updatePersonne(Personne personne, @PathParam("id") Integer id){
        annuaire.updatePersonne(id, personne);
    }
}
