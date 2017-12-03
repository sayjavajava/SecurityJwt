package org.zerhusen.security.service;

import org.zerhusen.heroes.Hero;
import org.zerhusen.security.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerhusen.security.repository.HeroRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kamran on 11/27/2017.
 */
@Service
public class HeroService {


    @Autowired
   private HeroRepository heroRepository;

    public List<Hero> findAll(){

     Iterable<Hero> list=    heroRepository.findAll();
     List<Hero> listofhero = new ArrayList<>();
     list.forEach(listofhero :: add);
     return listofhero;
    }
    public Hero findByName(String name){
        return heroRepository.findByName(name);
    }
    public void saveHero(Hero hero){
        heroRepository.save(hero);
}

    public void delete(long id) {

    heroRepository.delete(id);
    }
}
