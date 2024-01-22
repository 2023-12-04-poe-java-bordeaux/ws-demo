package com.demo.api.personnes;

import java.util.HashMap;
import java.util.List;

public class AnnuairePersonne {

    private int idCount = 0;
    private HashMap<Integer, Personne> personnes = new HashMap<>();

    public void addPersonne(Personne newPersonne){
        idCount++;// idCount = idCount + 1
        newPersonne.setId(idCount);
        personnes.put(idCount, newPersonne);
    }

    public List<Personne> getList(){
        return personnes.values().stream().toList();
    }

    public Personne getPersonne(int id){
        Personne p = personnes.get(id);
        return p;
    }

    public void deletePersonne(Integer id) {
        personnes.remove(id);
    }

    public void updatePersonne(Integer id, Personne personne) {
        personnes.replace(id, personne);
    }
}
