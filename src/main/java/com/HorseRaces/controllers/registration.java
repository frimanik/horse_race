package com.HorseRaces.controllers;
 import com.HorseRaces.entity.User;
import com.HorseRaces.services.UserService;
import com.HorseRaces.services.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class registration {
    @Autowired
    private UserManager userManager;

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public ModelAndView registrationPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping("/registration")
    public ModelAndView registrationSet(User user) {
        ModelAndView modelAndView = new ModelAndView();
           if(userService.checkUnique(user.getLogin()))
            userService.regUser(user);
        return modelAndView;
    }


}

