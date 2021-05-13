package com.revature.seunghoon_lee_p0.exceptions;

public class NegativeAmountTransactionException extends RuntimeException {
    public NegativeAmountTransactionException(String message) {
        super(message);
    }
}
