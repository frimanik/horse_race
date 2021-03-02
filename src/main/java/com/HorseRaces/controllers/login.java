package com.HorseRaces.controllers;
 import com.HorseRaces.services.UserService;
import com.HorseRaces.services.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class login {

    @Autowired
    private UserManager userManager;

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ModelAndView getLoginPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login(String login, String password) {
        ModelAndView modelAndView = new ModelAndView();
        if (userService.authUser(login, password)) {
            modelAndView.setViewName("redirect:/home");
        }
        else{
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

}