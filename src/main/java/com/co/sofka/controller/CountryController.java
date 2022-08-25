package com.co.sofka.controller;

import com.co.sofka.domain.Country;
import com.co.sofka.service.CountryService;
import com.co.sofka.utility.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    private Response response = new Response();

    private HttpStatus httpStatus = HttpStatus.OK;


    @GetMapping(path = "/countries")
    public ResponseEntity<Response> findAllCountries() {
        response.restart();
            response.message = "La lista de paises es : ";
            response.data = countryService.getCountries();
            httpStatus = HttpStatus.OK;
        return new ResponseEntity(response, httpStatus);
    }

    @GetMapping(path = "/cyclist/country/{id}")
    public ResponseEntity<Response> findCyclistCode(@PathVariable(value = "id") String id) {
        response.restart();
        response.message = "Los ciclistas registrados por este codigo son: ";
        response.data = countryService.getCyclistsCodeCountry(id);
        httpStatus = HttpStatus.OK;
        return new ResponseEntity(response, httpStatus);
    }

    @GetMapping(path = "/team/country/{id}")
    public ResponseEntity<Response> findTeamCountryCode(@PathVariable(value = "id") String id) {
        response.restart();
        response.message = "Los equipos registrados por este codigo son: ";
        response.data = countryService.getTeamCountry(id);
        httpStatus = HttpStatus.OK;
        return new ResponseEntity(response, httpStatus);
    }

    @PostMapping(path = "/country")
    public ResponseEntity<Response> createCountry(@RequestBody Country country) {
            response.data = countryService.createCountry(country);
            httpStatus = HttpStatus.CREATED;
        return new ResponseEntity(response, httpStatus);
    }

    @PutMapping(path = "/country/{id}")
    public ResponseEntity<Response> updateCountry(
            @RequestBody Country country,
            @PathVariable(value="id") Long id ) {
        response.restart();
            response.data = countryService.updateCountry(id, country);
            httpStatus = HttpStatus.OK;
        return new ResponseEntity(response, httpStatus);
    }

    @DeleteMapping(path = "/country/{id}")
    public ResponseEntity<Response> deleteCountry(@PathVariable(value="id") Long id) {
        response.restart();
            response.data = countryService.deteleCountry(id);
            if (response.data == null) {
                response.message = "El pais no existe";
                httpStatus = HttpStatus.NOT_FOUND;
            } else {
                response.message = "El pais fue removido exitosamente";
                httpStatus = HttpStatus.OK;
            }
        return new ResponseEntity(response, httpStatus);
    }

}