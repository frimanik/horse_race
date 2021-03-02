package com.HorseRaces.repository;
import com.HorseRaces.entity.Horse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HorseRepositoryImpl implements HorseRepository {
    @Autowired //what is autowired??

    JdbcTemplate jdbcTemplate;

    private RowMapper<Horse> horseRowMapper = (rowStr, rowNum) -> new Horse(
            rowStr.getLong("id"),
            rowStr.getString("color")
    );

    @Override
    public int create(Horse horse) {        String sql = "insert into horses (id,color) values(?,?)";
        return jdbcTemplate.update(sql,
                horse.getId(),
                horse.getColor());
    }

    @Override
    public Horse get(Long id) {
        String sql = "select id, color  from  horses where id=?";
        return jdbcTemplate.queryForObject(sql, horseRowMapper, id);
    }
    @Override
    public List<Horse> get(){
        String sql = "select id,color from horses";
        return jdbcTemplate.query(sql,horseRowMapper);
    }

    @Override
    public int update(Horse horse) {
        String sql = "update horses set color=? where id=?";
        return jdbcTemplate.update(sql,
                horse.getColor(),
                horse.getId());
    }
    @Override
    public int delete(Long id){
        String sql ="delete horses from horses where id=?";
        return jdbcTemplate.update(sql,id);
    }


}