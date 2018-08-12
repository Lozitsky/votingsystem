package com.kirilo.votingsystem.controller;

import com.kirilo.votingsystem.entity.Candidate;
import com.kirilo.votingsystem.entity.Citizen;
import com.kirilo.votingsystem.repositories.CandidateRepo;
import com.kirilo.votingsystem.repositories.CitizenRepo;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class VotingController {
    public final Logger logger = Logger.getLogger(VotingController.class);

    @Autowired
    CandidateRepo candidateRepo;
    @Autowired
    CitizenRepo citizenRepo;

    @RequestMapping("/")
    public String goToVote() {
        logger.info("Returning vote.html file");
        return "vote.html";
    }

    @RequestMapping("/doLogin")
    public String doLogin(@RequestParam String name, Model model, HttpSession session) {
        logger.info("getting citizen from database");

        Citizen citizen = citizenRepo.findByName(name);

        logger.info("putting citizen into session");

        session.setAttribute("citizen", citizen);

        if (!citizen.isVoted()) {
            logger.info("putting candidates into model");
            List<Candidate> candidates = candidateRepo.findAll();
            model.addAttribute("candidates", candidates);

            return "/performVote.html";
        } else {
            return "/alreadyVoted.html";
        }
    }

    @RequestMapping("/voteFor")
    public String voteFor(@RequestParam int id, HttpSession session) {
        Citizen citizen = (Citizen) session.getAttribute("citizen");
        if (!citizen.isVoted()) {
            citizen.setVoted(true);
            citizenRepo.save(citizen);
            Candidate candidate = candidateRepo.findById(id);
            logger.info("voting for candidate " + candidate.getName());
            candidate.setNumberOfVotes(candidate.getNumberOfVotes() + 1);
            candidateRepo.save(candidate);
            return "voted.html";
        }

        return "/alreadyVoted.html";
    }
}
