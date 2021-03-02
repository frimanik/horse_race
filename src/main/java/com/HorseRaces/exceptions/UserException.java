package com.HorseRaces.exceptions;



import com.HorseRaces.entity.User;

public class UserException extends Exception {

    public UserException() {
    }

    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String toString() {
        return this.getMessage();
    }
}
