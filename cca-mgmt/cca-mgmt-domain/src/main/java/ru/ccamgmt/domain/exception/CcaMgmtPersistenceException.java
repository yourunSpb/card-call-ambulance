package ru.ccamgmt.domain.exception;

/**
 * Created by Владимир on 13.10.2015.
 */
public class CcaMgmtPersistenceException extends RuntimeException {

    /**
     * Basic constructor with necessary parameters.
     * @param message message with brief description of occurred error.
     * @param cause cause of exception.
     */
    public CcaMgmtPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
