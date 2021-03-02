package com.HorseRaces.controllers;
 import com.HorseRaces.entity.Horse;
import com.HorseRaces.entity.Race;
import com.HorseRaces.repository.HorseRepository;
import com.HorseRaces.repository.RaceRepositoryImpl;
import com.HorseRaces.services.UserService;
import com.HorseRaces.services.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class raceController {

    @Autowired
    private UserManager userManager;

    @Autowired
    private UserService userService;

    @Autowired
    private RaceRepositoryImpl raceRepository;

    @Autowired
    private HorseRepository horseRepository;

    @Autowired
    private Race raceObj;
     @GetMapping("/raceController")
        ModelAndView view(ModelAndView modelAndView){
        modelAndView.setViewName("/raceController");
        raceObj.setId(raceObj.getId());
        modelAndView.addObject(raceObj);
        modelAndView.addObject("raceObj",raceRepository.get(raceObj.getId()));
        return modelAndView;
    }

 }
