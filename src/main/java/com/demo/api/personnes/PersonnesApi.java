package com.demo.api.personnes;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
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
}
