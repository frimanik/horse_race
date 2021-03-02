package com.HorseRaces.services;

import com.HorseRaces.entity.User;
import com.HorseRaces.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserManagerImpl userManagerImpl;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<User> userRowMapper=(rowStr, rowNum)->new User(
            rowStr.getLong("id"),
            rowStr.getString("FULL_NAME"),
            rowStr.getString("login"),
            rowStr.getString("password"),
            rowStr.getInt("account"),
            rowStr.getString("role")
    );

    @Override
    public User getById(Long id){
        return userRepository.get(id);
    }

    @Override
    public void regUser(User user){
        user.setLogin(user.getLogin());
        user.setPassword(hash(user.getPassword()));
        user.setName(user.getName());
        user.setAccount(user.getAccount());
        user.setRole(user.getRole());
        userRepository.create(user);
    }

    @Override
    public String hash(String password) {
        return password;
    }

    @Override
    public boolean authUser(String login,String password){
        User currentUser;

        try {
            currentUser = userRepository.get(login);
        }
        catch (Exception exc){
            return false;
        }
        if(checkPassword(currentUser, password)){
            userManagerImpl.setUser(currentUser);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean checkPassword(User user,String password){return user.getPassword().equals(hash(password));}

    @Override
    public boolean checkUnique(String login){
        User user;
        try {
             user = userRepository.get(login);
            }
        catch (EmptyResultDataAccessException e){
            return true;
        }
       return user==null;
    }

}


