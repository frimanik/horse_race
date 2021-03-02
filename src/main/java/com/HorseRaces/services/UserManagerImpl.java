package com.HorseRaces.services;

import com.HorseRaces.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Service
public class UserManagerImpl implements UserManager {

    private User user;

    @Override
    public User getUser(){
         return user;
    }

    @Override
    public void setUser(User user){
    this.user = user;
    }

    @Override
    public Boolean authorized() {
        return user==null;
    }
}
