package com.HorseRaces.repository;

import com.HorseRaces.entity.Horse;
import com.HorseRaces.entity.Race;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public class RaceRepositoryImpl implements RaceRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Race> raceRowMapper = (rowStr,rowNum) -> new Race(
            rowStr.getLong("id"),
            rowStr.getString("date")
            );

    @Override
    public int create(Race race){
        String sql = "insert into races (id,date) values(?,?)" ;
        return jdbcTemplate.update(sql,
                race.getId(),
                race.getDate()
                );
    }

    @Override
    public Race get(Long id){
        String sql = "select id,date from races  where id=?";
        String sql_horses = "select horses.color,horses.id from horse_races inner join horses on horse_races.horse_id=horses.id where horse_races.race_id=?";
        Race race = jdbcTemplate.queryForObject(sql,raceRowMapper,id);
        race.setHorses(jdbcTemplate.queryForList(sql_horses, Horse.class,id));
        return race;
    }


    public List<Race> get(){
        String sql = "select id,date from races";
        return jdbcTemplate.query(sql,raceRowMapper);
    }


    @Override
    public int update(Race race){
        String sql ="update races set date=?  where id=?";
        return jdbcTemplate.update(sql,
                race.getDate(),
                race.getId());
    }
    @Override
    public int delete(Long id){
        String sql = "delete races from races where id=?";
        return jdbcTemplate.update(sql,id);
    }
}
