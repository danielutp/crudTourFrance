package com.co.sofka.service.interfaces;


import com.co.sofka.domain.Country;
import com.co.sofka.domain.Cyclist;
import com.co.sofka.domain.Team;

import java.util.Set;

public interface ICountry {

    public Set<Country> getCountries();
    public Set<Team> getTeamCountry(String code);
    public Set<Cyclist> getCyclistsCodeCountry(String code);
    public Country createCountry(Country country);

    public Country updateCountry(Long id, Country country);

    public Country deteleCountry(Long id);



}
