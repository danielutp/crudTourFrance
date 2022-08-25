package com.co.sofka.service;

import com.co.sofka.domain.Country;
import com.co.sofka.domain.Cyclist;
import com.co.sofka.domain.Team;
import com.co.sofka.repository.CountryRepository;
import com.co.sofka.service.interfaces.ICountry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Service
public class CountryService implements ICountry {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Set<Country> getCountries() {
        Set<Country> countries = new HashSet<>();
        countryRepository.findAll().forEach(countries::add);
        return countries;
    }

    @Override
    public Set<Team> getTeamCountry(String code) {
        Country country = countryRepository.findByCode(code);
        return country.getTeams();
    }

    @Override
    public Set<Cyclist> getCyclistsCodeCountry(String code) {
        Country country = countryRepository.findByCode(code);
        return country.getCyclists();
    }

    @Override
    public Country createCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Country updateCountry(Long id, Country country) {
        country.setId(id);
        return countryRepository.save(country);
    }

    @Override
    public Country deteleCountry(Long id) {
        var country = countryRepository.findById(id);
        if (country.isPresent()) {
            countryRepository.delete(country.get());
            return country.get();
        } else {
            return null;
        }
    }


}
