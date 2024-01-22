package com.demo.api.tigres;

import java.util.HashMap;
import java.util.List;

public class Zoo {

    private int idCount = 0;
    private HashMap<Integer, Tigre> tigres = new HashMap<>();

    public void add(Tigre tigre){
        idCount++;
        tigre.setId(idCount);
        tigres.put(idCount, tigre);
    }

    public List<Tigre> getAll(){
        return tigres.values().stream().toList();
    }

    public Tigre getById(Integer id){
        return tigres.get(id);
    }

    public void delete(Integer id){
        tigres.remove(id);
    }

    public void update(Integer id, Tigre tigre){
        tigres.replace(id, tigre);
    }

    public void patch(Integer id, Tigre tigreHttp){
        Tigre tigreToPatch = tigres.get(id);
        tigreToPatch.setNotNull(tigreHttp);
        tigres.replace(id, tigreToPatch);
    }
}
