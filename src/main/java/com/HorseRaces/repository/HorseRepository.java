package com.HorseRaces.repository;

import com.HorseRaces.entity.Horse;

import java.util.List;

public interface HorseRepository {

    int create (Horse horse);

    Horse get (Long id);

    List<Horse> get();

    int update (Horse horse);

    int delete (Long id);

}
