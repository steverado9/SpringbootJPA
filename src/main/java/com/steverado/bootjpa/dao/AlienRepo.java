package com.steverado.bootjpa.dao;

import com.steverado.bootjpa.model.Alien;
import org.springframework.data.repository.CrudRepository;

public interface AlienRepo extends CrudRepository<Alien, Integer> {
}
