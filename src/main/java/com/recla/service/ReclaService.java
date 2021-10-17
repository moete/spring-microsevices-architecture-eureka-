package com.recla.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReclaService implements  ReclaServiceInterface {
    @Autowired
    ReclaReposiroty reclaReposiroty;

    @Override
    public List<Recla> findAll() {
        return reclaReposiroty.findAll();
    }

    @Override
    public List<Recla> findBySubject(String subject) {
        return reclaReposiroty.findReclaBySubject(subject);
    }

    @Override
    public Optional<Recla> findById(int ID) {
        return reclaReposiroty.findById(ID);
    }

    @Override
    public Recla save(Recla recla) {
        return reclaReposiroty.save(recla);
    }

    @Override
    public Recla update(Recla newrecla, int id) {
        Recla oldrecla = reclaReposiroty.findById(id).get();

            if(!oldrecla.getSubject().isEmpty()) {
                oldrecla.setMessage(newrecla.getMessage());
                oldrecla.setSubject(newrecla.getSubject());
                oldrecla.setUsername(newrecla.getUsername());
                return  reclaReposiroty.save(oldrecla);
            }
            return  oldrecla ;
    }

    @Override
    public void DeleteById(int id) {
        reclaReposiroty.deleteById(id);
    }
}
