package com.HorseRaces.services;

import com.HorseRaces.entity.User;

public interface UserManager {

    User getUser();

    void setUser(User user);

    Boolean authorized();

}
