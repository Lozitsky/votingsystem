package com.kirilo.votingsystem.controller;

import com.kirilo.votingsystem.entity.Citizen;
import com.kirilo.votingsystem.repositories.CandidateRepo;
import com.kirilo.votingsystem.repositories.CitizenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VotingController {
    @Autowired
    CandidateRepo candidateRepo;
    @Autowired
    CitizenRepo citizenRepo;

    @RequestMapping("/")
    public String goToVote() {
        return "vote.html";
    }

    @RequestMapping("/doLogin")
    public String doLogin(@RequestParam String name) {
        Citizen citizen = citizenRepo.findByName(name);

        if (!citizen.isVoted()) {
            return "/performVote.html";
        } else {
            return "/alreadyVoted.html";
        }
    }
}
