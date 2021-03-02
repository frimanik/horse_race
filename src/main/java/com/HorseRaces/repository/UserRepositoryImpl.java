package com.HorseRaces.repository;

import com.HorseRaces.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private RowMapper<User>user=(rowStr,rowNum)->new User(
            rowStr.getLong("id"),
            rowStr.getString("FULL_NAME"),
            rowStr.getString("login"),
            rowStr.getString("password"),
            rowStr.getInt("account"),
            rowStr.getString("role")
    );

    @Override
    public int create (User user){
        String sql = "insert into users (FULL_NAME,login,password,role,account)" +
               " values(?,?,?,?,?)";

        return jdbcTemplate.update(sql,
                user.getName(),
                user.getLogin(),
                user.getPassword(),
                user.getRole(),
                user.getAccount());
    }

    @Override
    public User get(Long id){
        String sql = "select id,FULL_NAME,login,password,role,account from users where id=?";
        return jdbcTemplate.queryForObject(sql,user,id);
    }

    @Override
    public User get(String login){
        String sql = "Select id, FULL_NAME," +
                "login,password,role,account from users where login = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{login}, user);
    }

    @Override
    public int update (User user){
        String sql ="update users set FULL_NAME=?, login=?, password=?, account=?, role=? where id=?";

        return jdbcTemplate.update(sql,
                user.getName(),
                user.getLogin(),
                user.getPassword(),
                user.getAccount(),
                user.getRole(),
                user.getId());
    }

    @Override
    public int delete (Long id){
        String sql ="delete users from users where id=?";
        return jdbcTemplate.update(sql,id);
    }


   /* public int LoginExists(String login){
        String sql = "select * from users WHERE username=?";
        return jdbcTemplate.qeueryForObject(sql, new Object[] {login}, String.class);
    }
*/
}
