package com.example.admin.emc.domain.adapter.builder.Exception;

/**
 * Created by admin on 8/14/2016.
 */
public class AdapterBuilderException extends Exception {
    public AdapterBuilderException() {
    }

    public AdapterBuilderException(String message) {
        super(message);
    }

    public AdapterBuilderException(String message, Throwable cause) {
        super(message, cause);
    }

    public AdapterBuilderException(Throwable cause) {
        super(cause);
    }

}
