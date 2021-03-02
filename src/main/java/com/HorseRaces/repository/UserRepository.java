package com.HorseRaces.repository;

import com.HorseRaces.entity.User;

public interface UserRepository {

    int create (User user);

    User get (Long id);

    User get(String login);

    int update (User user);

    int delete (Long id);

}