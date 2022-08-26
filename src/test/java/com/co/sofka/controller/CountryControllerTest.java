package com.co.sofka.controller;

import com.co.sofka.domain.Country;
import com.co.sofka.repository.CountryRepository;
import com.co.sofka.service.CountryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.HashSet;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CountryControllerTest {
    @Mock
    private CountryRepository countryRepository;

    @InjectMocks
    private CountryService countryService;

    private Country country;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        country = new Country();
        country.setId(1L);
        country.setName("Colombia");
        country.setCode("COL");
        country.setCyclists(new HashSet<>());
        country.setTeams(new HashSet<>());
    }
    @Test
    void findAllCountries() {
            when(countryRepository.findAll()).thenReturn(Arrays.asList(country));
            assertNotNull(countryService.getCountries());
        }

    @Test
    void createCountry() {
        when(countryRepository.save(country)).thenReturn(country);
        assertNotNull(countryService.createCountry(country));
        verify(countryRepository,times(1)).save(country);
    }

    @Test
    void updateCountry() {
        when(countryRepository.save(country)).thenReturn(country);
        Long id = country.getId();
        assertNotNull(countryService.updateCountry(id,country));
        verify(countryRepository,times(1)).save(country);
    }


}
