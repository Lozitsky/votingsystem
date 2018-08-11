package com.kirilo.votingsystem.repositories;

import com.kirilo.votingsystem.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitizenRepo extends JpaRepository<Citizen, Integer> {
    Citizen findByName(String name);
}
