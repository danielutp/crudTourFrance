package com.co.sofka.service;

import com.co.sofka.domain.Cyclist;
import com.co.sofka.domain.Team;
import com.co.sofka.repository.TeamRepository;
import com.co.sofka.service.interfaces.ITeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class TeamService implements ITeam {
    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Set<Team> getTeams() {
        Set<Team> teams = new HashSet<>();
        teamRepository.findAll().forEach(teams::add);
        return teams;
    }

    @Override
    public Set<Cyclist> getCyclistsCode(String code) {
        Team team = teamRepository.findByCode(code);
        return team.getCyclists();
    }

    @Override
    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public Team updateTeam(Long id, Team team) {
        team.setId(id);
        return teamRepository.save(team);
    }

    @Override
    public Team deteleTeam(Long id) {
        var team = teamRepository.findById(id);
        if (team.isPresent()) {
            teamRepository.delete(team.get());
            return team.get();
        } else {
            return null;
        }
    }
}
