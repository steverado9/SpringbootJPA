package com.steverado.bootjpa.controller;

import com.steverado.bootjpa.dao.AlienRepo;
import com.steverado.bootjpa.model.Alien;
import org.apache.el.parser.AstGreaterThan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @RequestMapping("/aliens")
    @ResponseBody
    public String getALiens() {
        //converting the returned iterable to string
        return repo.findAll().toString() ;
    }

    @RequestMapping("/alien/{aid}")
    @ResponseBody
    public String getALien(@PathVariable("aid") int aid) {
        //converting the returned iterable to string
        return repo.findById(aid).toString() ;
    }

//    @RequestMapping("/getAlien")
//    public ModelAndView getALien(@RequestParam int aid) {
//        ModelAndView mv = new ModelAndView("showAlien");
//        Alien alien = repo.findById(aid).orElse(new Alien());
//
//        System.out.println(repo.findByTech("Java"));
//        System.out.println(repo.findByAidGreaterThan(102));
//        System.out.println(repo.findByTechSorted("java"));
//
//        mv.addObject(alien);
//        return mv;
//    }
}
