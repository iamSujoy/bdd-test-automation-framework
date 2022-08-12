package com.swaglabs.exceptions;

public class EmptyCartException extends Exception {
    public EmptyCartException(String msg) {
        super(msg);
    }
}
