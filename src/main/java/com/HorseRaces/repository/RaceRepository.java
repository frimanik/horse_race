package com.HorseRaces.repository;

import com.HorseRaces.entity.Race;

import java.util.List;

public interface RaceRepository {

        int create (Race race);

        Race get (Long id);

        List<Race> get();

        int update (Race race);

        int delete (Long id);

    }