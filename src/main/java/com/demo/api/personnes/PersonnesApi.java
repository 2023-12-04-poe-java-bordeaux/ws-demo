package com.demo.api.personnes;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

@Path("/personnes")
public class PersonnesApi {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Personne> getPersonnes(){
        ArrayList<Personne> resultat = new ArrayList<>();
        resultat.add(new Personne("JC", "Dominguez"));
        resultat.add(new Personne("Alain", "Dupont"));
        return resultat;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addPersonne(Personne newPersonne){
        System.out.println(newPersonne);
    }
}
