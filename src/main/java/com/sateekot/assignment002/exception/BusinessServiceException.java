package com.sateekot.assignment002.exception;

/**
 * @author SateeshKumar Kota
 * @date 02-02-2020
 * Exception to handle all functional requirements related exceptions.
 */
public class BusinessServiceException extends Exception {
    public BusinessServiceException(String message) {
        super(message);
    }

    // Add other constructors based on usage.
}
