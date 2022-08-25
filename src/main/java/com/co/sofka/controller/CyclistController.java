package com.co.sofka.controller;

import com.co.sofka.domain.Cyclist;
import com.co.sofka.domain.Team;
import com.co.sofka.service.CyclistService;
import com.co.sofka.utility.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class CyclistController {
    @Autowired
    private CyclistService cyclistService;

    private Response response = new Response();

    private HttpStatus httpStatus = HttpStatus.OK;


    @GetMapping(path = "/cyclists")
    public ResponseEntity<Response> findAllCyclists() {
        response.restart();
        response.message = "Los ciclistas registrados son: ";
        response.data = cyclistService.getCyclists();
        httpStatus = HttpStatus.OK;
        return new ResponseEntity(response, httpStatus);
    }

    @PostMapping(path = "/cyclist")
    public ResponseEntity<Response> createCyclist(@RequestBody Cyclist cyclist) {
        response.data = cyclistService.createCyclist(cyclist);
        httpStatus = HttpStatus.CREATED;
        return new ResponseEntity(response, httpStatus);
    }

    @PutMapping(path = "/cyclist/{id}")
    public ResponseEntity<Response> updateCyclist(
            @RequestBody Cyclist cyclist,
            @PathVariable(value = "id") Long id) {
        response.restart();
        response.data = cyclistService.updateCyclist(id, cyclist);
        httpStatus = HttpStatus.OK;
        return new ResponseEntity(response, httpStatus);
    }

    @DeleteMapping(path = "/cyclist/{id}")
    public ResponseEntity<Response> deleteCyclist(@PathVariable(value = "id") Long id) {
        response.restart();
        response.data = cyclistService.deteleCyclist(id);
        if (response.data == null) {
            response.message = "El ciclista no existe";
            httpStatus = HttpStatus.NOT_FOUND;
        } else {
            response.message = "El ciclista fue removido exitosamente";
            httpStatus = HttpStatus.OK;
        }
        return new ResponseEntity(response, httpStatus);
    }
}
