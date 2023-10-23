package org.example.utils;

public final class MyOwnRuntimeException extends RuntimeException {

    public MyOwnRuntimeException(final String message) {
            super(message);
        }

    public MyOwnRuntimeException(final String message, final Throwable cause) {
            super(message, cause);
        }
    }