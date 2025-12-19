package com.devfrank.controlregistromatricula.repositories;

import com.devfrank.controlregistromatricula.entities.AppUser;

public interface UserRepository extends BaseCrudRepository<AppUser, Integer> {

    AppUser findOneByUsername(String username);
}
