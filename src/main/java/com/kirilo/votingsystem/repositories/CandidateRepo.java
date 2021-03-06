package com.kirilo.votingsystem.repositories;

import com.kirilo.votingsystem.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepo extends JpaRepository<Candidate, Integer> {
    Candidate findById(int id);
}
