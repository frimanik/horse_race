package com.HorseRaces.repository;

import com.HorseRaces.entity.Bet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class BetRepositoryImpl implements BetRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private RowMapper<Bet> betRowMapper = (rowStr, rowNum) -> new Bet(
            rowStr.getLong("id"),
            rowStr.getInt("quantity"),
            rowStr.getInt("multiplier"),
            rowStr.getString("created_at")
    );

    @Override
    public int create (Bet bet)        {
            String sql = "insert into bets (id,quantity,multiplier,created_at)" +
                    " values(?,?,?,?)";
        return jdbcTemplate.update(sql,
                bet.getId(),
                bet.getMultiplier(),
                bet.getQuantity(),
                bet.getCreated_at());
    }

    @Override
    public Bet get (Long id){
        String sql = "select id,quantity,multiplier,created_at from bets where  id=?";
        return jdbcTemplate.queryForObject(sql,betRowMapper,id);
    }

    @Override
    public int update (Bet bet){
        String sql = "update bets set multiplier=?,quantity=?,created_at=? where id=?";

        return jdbcTemplate.update(sql,
                bet.getMultiplier(),
                bet.getQuantity(),
                bet.getCreated_at(),
                bet.getId());
    }

    @Override
    public int delete(Long id) {
        String sql = "delete bets from bets where id=?";
        return jdbcTemplate.update(sql,id);
    }

}

