package com.kirilo.votingsystem.controller;

import com.kirilo.votingsystem.entity.Citizen;
import com.kirilo.votingsystem.repositories.CitizenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class CitizensRestController {
    @Autowired
    CitizenRepo citizenRepo;

    @RequestMapping("/doAction")
    public String doAction() {

        Citizen citizen = new Citizen(11002, "Bob");
        citizenRepo.save(citizen);
        return "Succes";
    }

    @RequestMapping("/doLogin")
    public String doLogin(@RequestParam String name) {
        if (name.isEmpty()) {
            return doAction();
        }
        return "do login for " + name;
    }
}
