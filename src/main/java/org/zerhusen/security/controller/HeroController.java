package org.zerhusen.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zerhusen.heroes.Hero;
import org.zerhusen.security.service.HeroService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by kamran on 11/28/2017.
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HeroController {

    @Autowired
    private HeroService heroService;


    @GetMapping("/allheros")
    public List<Hero> allheros(){
        return heroService.findAll();
    }

    @PostMapping(value = "/allheros")
    public String createhero(@RequestBody Hero hero){

        heroService.saveHero(hero);
    return null;
    }

    @DeleteMapping (value = "/allheros/{id}")
    public String DeleteHero(@PathVariable long id){

        heroService.delete(id);
        return null;
    }

    @CrossOrigin
    @RequestMapping("/heros")
    @ResponseBody
    public List<Hero> heros(HttpServletResponse response){


        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        return heroService.findAll();
    }

    @RequestMapping("findByName/{name}")
    public Hero findByName(@PathVariable String name){
      return heroService.findByName(name);

    }
}
