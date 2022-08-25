package com.co.sofka.service.interfaces;

import com.co.sofka.domain.Cyclist;
import com.co.sofka.domain.Team;

import java.util.Set;

public interface ITeam {

    public Set<Team> getTeams();

    public Set<Cyclist> getCyclistsCode(String code);

    public Team createTeam(Team team);

    public Team updateTeam(Long id, Team team);

    public Team deteleTeam(Long id);

}
