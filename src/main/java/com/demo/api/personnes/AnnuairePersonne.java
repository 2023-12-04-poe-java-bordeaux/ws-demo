package com.demo.api.personnes;

import java.util.HashMap;
import java.util.List;

public class AnnuairePersonne {

    private int idCount = 0;
    private HashMap<Integer, Personne> personnes = new HashMap<>();

    public void addPersonne(Personne newPersonne){
        // idCount = idCount + 1
        personnes.put(idCount++, newPersonne);
    }

    public List<Personne> getList(){
        return personnes.values().stream().toList();
    }

    public Personne getPersonne(int id){
        Personne p = personnes.get(id);
        return p;
    }
}