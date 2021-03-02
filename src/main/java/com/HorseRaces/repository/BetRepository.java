package com.HorseRaces.repository;

import com.HorseRaces.entity.Bet;

public interface BetRepository {

    int create (Bet bet);

    Bet get (Long id);

    int update (Bet bet);

    int delete (Long id);

}
