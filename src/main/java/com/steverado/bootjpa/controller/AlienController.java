package com.steverado.bootjpa.controller;

import com.steverado.bootjpa.dao.AlienRepo;
import com.steverado.bootjpa.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

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

    @RequestMapping("/getAlien")
    public ModelAndView getALien(@RequestParam int aid) {
        ModelAndView mv = new ModelAndView("showAlien");
        Alien alien = repo.findById(aid).orElse(new Alien());
        mv.addObject(alien);
        return mv;
    }
}
