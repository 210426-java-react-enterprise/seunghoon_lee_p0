package com.revature.seunghoon_lee_p0.exceptions;

/**
 * Runtime exception to avoid transaction which occurs overdrafting
 */
public class OverdarftException extends RuntimeException {
    public OverdarftException(String message) {
        super(message);
    }
}
