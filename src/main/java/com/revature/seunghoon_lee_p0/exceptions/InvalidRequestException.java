package com.revature.seunghoon_lee_p0.exceptions;

/**
 * Runtime exception to handle invalid user inputs
 */
public class InvalidRequestException extends RuntimeException {

    public InvalidRequestException(String message) {
        super(message);
    }

}
