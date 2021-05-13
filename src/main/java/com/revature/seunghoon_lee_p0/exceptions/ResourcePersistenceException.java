package com.revature.seunghoon_lee_p0.exceptions;

/**
 * Runtime exception to handle database communication error
 */
public class ResourcePersistenceException extends RuntimeException {

    public ResourcePersistenceException(String message) {
        super(message);
    }

}
