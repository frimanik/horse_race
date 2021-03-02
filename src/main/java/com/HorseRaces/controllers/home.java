package com.HorseRaces.controllers;
import com.HorseRaces.entity.Race;
import com.HorseRaces.entity.User;
import com.HorseRaces.repository.RaceRepository;
import com.HorseRaces.repository.RaceRepositoryImpl;
import com.HorseRaces.repository.UserRepository;
import com.HorseRaces.services.UserManager;
import com.HorseRaces.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
@RequestMapping("home")
public class home {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserManager userManager;

    @Autowired
    private RaceRepository raceRepository;

    private Race raceObj;

    @RequestMapping("/home")

    public String Home() {
        return "home";
    }

    @GetMapping
        public ModelAndView getHome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        List<Race> races = raceRepository.get();
        modelAndView.addObject(races);
        modelAndView.addObject("races",raceRepository.get());
        return modelAndView;
    }


    /*
        @GetMapping("/home/raceController")
        public ModelAndView setRace( Long id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/home");
        raceObj.setId(id);
        modelAndView.addObject(raceObj);
        modelAndView.addObject("raceObj",raceRepository.get(id));
        modelAndView.setViewName("redirect:/raceController");
        return modelAndView;
    } */
}
