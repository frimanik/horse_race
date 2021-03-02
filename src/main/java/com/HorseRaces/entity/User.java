package com.HorseRaces.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;


public class User{

    private Long id;
    private int account;
    private String FULL_NAME;
    private String Role;
    @NotNull
    @Size(min=5)
    private String login;
    @NotNull
    @Size(min=5)
    private String password;

    public User(Long id,String FULL_NAME,String login,String password,int account,String Role){
        this.id = id;
        this.FULL_NAME = FULL_NAME;
        this.login = login;
        this.password =password;
        this.account=account;
        this.Role =Role;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id) {this.id = id;}

    public int getAccount(){return account;}

    public void setAccount(int account) { this.account = account; }

    public String getRole(){return Role;}

    public void setRole(String Role) {this.Role = Role; }

    public String getName(){
        return FULL_NAME;
    }

    public void setName(String FULL_NAME){this.FULL_NAME = FULL_NAME;}

    public String getLogin(){return login;}

    public void  setLogin(String login) {this.login = login;}

    public String getPassword(){return password;}

    public void setPassword(String password){this.password = password;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {return Objects.hash(id);}
}