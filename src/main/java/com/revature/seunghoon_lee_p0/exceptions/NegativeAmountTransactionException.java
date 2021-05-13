package com.revature.seunghoon_lee_p0.exceptions;

/**
 * Runtime exception to handle negative transaction amount inputs
 */
public class NegativeAmountTransactionException extends RuntimeException {
    public NegativeAmountTransactionException(String message) {
        super(message);
    }
}
