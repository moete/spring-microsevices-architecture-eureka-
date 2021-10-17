package com.recla.service;

import java.util.List;
import java.util.Optional;

public interface ReclaServiceInterface {
    public List <Recla> findAll();
    public  List<Recla> findBySubject(String subject);
    public Optional<Recla> findById(int ID);
    public Recla save(Recla recla);
    public  Recla update(Recla recla ,int id) ;
    public  void DeleteById(int id);

}
