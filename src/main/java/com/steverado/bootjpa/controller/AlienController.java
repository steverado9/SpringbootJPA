package com.steverado.bootjpa.controller;

import com.steverado.bootjpa.dao.AlienRepo;
import com.steverado.bootjpa.model.Alien;
import org.apache.el.parser.AstGreaterThan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
public class AlienController {

    @Autowired
    AlienRepo repo;

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @DeleteMapping("/alien/{aid}")
    public String deleteAlien(@PathVariable int aid) {
        Alien a = repo.getById(aid);

        repo.delete(a);

        return "deleted";
    }

    @PostMapping(path ="/alien", consumes = {"application/json"})
    public Alien addALien(@RequestBody Alien alien) {
        repo.save(alien);
        return alien;
    }

    @GetMapping("/aliens")
    public List<Alien> getALiens() {
        //converting the returned iterable to string
        return repo.findAll() ;
    }

    @PutMapping(path ="/alien", consumes = {"application/json"})
    public Alien saveOrUpdateALien(@RequestBody Alien alien) {
        repo.save(alien);
        return alien;
    }

    @GetMapping("/alien/{aid}")
    public Alien getALien(@PathVariable("aid") int aid) {
        //converting the returned iterable to string
        return repo.findById(aid).orElseThrow(() -> new RuntimeException("Alien not found"));
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
