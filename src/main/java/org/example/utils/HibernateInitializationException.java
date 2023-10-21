package org.example.utils;

final class HibernateInitializationException extends RuntimeException {
    HibernateInitializationException(final String message, final Throwable cause) {
            super(message, cause);
        }
    }