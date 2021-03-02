package com.HorseRaces.entity;

import java.sql.Date;

public class Bet{
    private Long id;
    private int quantity;
    private int multiplier;
    private String created_at;

    public Bet(Long id, int quantity, int multiplier, String created_at){
        this.id = id;
        this.quantity=quantity;
        this.multiplier=multiplier;
        this.created_at = created_at;
    }

    public long getId(){
        return id;
    }

    public void setId(Long id) {this.id = id; }

    public long getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public int getMultiplier(){
        return multiplier;
    }

    public void setMultiplier(int multiplier) { this.multiplier = multiplier; }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) { this.created_at = created_at; }

    public void getOwner(int Owner){}



}