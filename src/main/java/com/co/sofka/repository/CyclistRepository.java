package com.co.sofka.repository;

import com.co.sofka.domain.Cyclist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CyclistRepository extends CrudRepository<Cyclist, Long> {
}