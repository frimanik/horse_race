package com.HorseRaces.exceptions;


public class LoginException extends RuntimeException {

    LoginException(Throwable cause){
        super("User not authorised", cause);
    }

    @Override
    public String toString() {
        return this.getMessage();
    }
}
