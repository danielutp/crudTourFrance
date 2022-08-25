package com.co.sofka.service.interfaces;

import com.co.sofka.domain.Cyclist;

import java.util.Set;

public interface ICyclist {


    public Set<Cyclist> getCyclists();

    public Cyclist createCyclist(Cyclist cyclist);

    public Cyclist updateCyclist(Long id, Cyclist cyclist);

    public Cyclist deteleCyclist(Long id);

}
