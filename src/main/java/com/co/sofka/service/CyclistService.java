package com.co.sofka.service;

import com.co.sofka.domain.Cyclist;
import com.co.sofka.repository.CyclistRepository;
import com.co.sofka.service.interfaces.ICyclist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Service
public class CyclistService implements ICyclist {

    @Autowired
    private CyclistRepository cyclistRepository;

    @Override
    public Set<Cyclist> getCyclists() {
        Set<Cyclist> cyclist = new HashSet<>();
        cyclistRepository.findAll().forEach(cyclist::add);
        return cyclist;
    }

    @Override
    public Cyclist createCyclist(Cyclist cyclist) {
        return cyclistRepository.save(cyclist);
    }

    @Override
    public Cyclist updateCyclist(Long id, Cyclist cyclist) {
        cyclist.setId(id);
        return cyclistRepository.save(cyclist);
    }

    @Override
    public Cyclist deteleCyclist(Long id) {
        var cyclist = cyclistRepository.findById(id);
        if (cyclist.isPresent()) {
            cyclistRepository.delete(cyclist.get());
            return cyclist.get();
        } else {
            return null;
        }
    }
}
