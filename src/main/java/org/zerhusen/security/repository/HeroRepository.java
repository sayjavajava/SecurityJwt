package org.zerhusen.security.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.zerhusen.heroes.Hero;

/**
 * Created by kamran on 11/28/2017.
 */
@Repository
public interface HeroRepository extends CrudRepository<Hero,Long> {

   Hero findByName( String name);

}
