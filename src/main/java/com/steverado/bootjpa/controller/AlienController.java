package com.steverado.bootjpa.controller;

import com.steverado.bootjpa.dao.AlienRepo;
import com.steverado.bootjpa.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AlienController {

    @Autowired
    AlienRepo repo;

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/addAlien")
    public String addALien(Alien alien) {
        repo.save(alien);
        return "home";
    }
}
