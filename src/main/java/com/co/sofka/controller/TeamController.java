package com.co.sofka.controller;

import com.co.sofka.domain.Team;
import com.co.sofka.service.TeamService;
import com.co.sofka.utility.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class TeamController {

    @Autowired
    private TeamService teamService;

    private Response response = new Response();

    private HttpStatus httpStatus = HttpStatus.OK;


    @GetMapping(path = "/teams")
    public ResponseEntity<Response> findAllTeams() {
        response.restart();
        response.message = "Los equipo registrados son: ";
        response.data = teamService.getTeams();
        httpStatus = HttpStatus.OK;
        return new ResponseEntity(response, httpStatus);
    }

    @GetMapping(path = "/team/cyclist/{id}")
    public ResponseEntity<Response> findCyclistCode(@PathVariable(value = "id") String id) {
        response.restart();
        response.message = "Los ciclistas registrados por este codigo son: ";
        response.data = teamService.getCyclistsCode(id);
        httpStatus = HttpStatus.OK;
        return new ResponseEntity(response, httpStatus);
    }

    @PostMapping(path = "/team")
    public ResponseEntity<Response> createTeam(@RequestBody Team team) {
        response.data = teamService.createTeam(team);
        httpStatus = HttpStatus.CREATED;
        return new ResponseEntity(response, httpStatus);
    }

    @PutMapping(path = "/team/{id}")
    public ResponseEntity<Response> updateTeam(
            @RequestBody Team team,
            @PathVariable(value = "id") Long id) {
        response.restart();
        response.data = teamService.updateTeam(id, team);
        httpStatus = HttpStatus.OK;
        return new ResponseEntity(response, httpStatus);
    }

    @DeleteMapping(path = "/team/{id}")
    public ResponseEntity<Response> deleteTeam(@PathVariable(value = "id") Long id) {
        response.restart();
        response.data = teamService.deteleTeam(id);
        if (response.data == null) {
            response.message = "El equipo no existe";
            httpStatus = HttpStatus.NOT_FOUND;
        } else {
            response.message = "El equipo fue removido exitosamente";
            httpStatus = HttpStatus.OK;
        }
        return new ResponseEntity(response, httpStatus);
    }
}