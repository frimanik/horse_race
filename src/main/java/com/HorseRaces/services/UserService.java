package com.HorseRaces.services;

import  com.HorseRaces.entity.User;

public interface UserService {

    User getById(Long id);

    void regUser(User user);

    boolean authUser(String login, String password);

    boolean checkPassword(User user,String password);

    boolean checkUnique(String login);

    String hash(String password);

}
