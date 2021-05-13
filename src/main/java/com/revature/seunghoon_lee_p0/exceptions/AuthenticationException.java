package com.revature.seunghoon_lee_p0.exceptions;

/**
 * Runtime exception to handle wrong username and password input
 */
public class AuthenticationException extends RuntimeException {

    public AuthenticationException(String message) {
        super(message);
    }

}
