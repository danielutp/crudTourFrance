package com.co.sofka.repository;

import com.co.sofka.domain.Country;
import com.co.sofka.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {
    Country findByCode(String code);
}