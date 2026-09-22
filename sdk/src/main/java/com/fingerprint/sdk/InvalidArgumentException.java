package com.fingerprint.sdk;

/**
 * Thrown before a request is sent when an argument passed to an operation cannot be used. It
 * reports the name of the parameter that was rejected, the value it was given, and why that value
 * is not accepted.
 */
public class InvalidArgumentException extends ApiException {
    private static final long serialVersionUID = 1L;

    /**
     * The code identifying this error. Unlike the values of {@link com.fingerprint.model.ErrorCode},
     * it is raised by this SDK and never originates from the Server API.
     */
    public static final String ERROR_CODE = "InvalidArgument";

    private final String parameter;
    private final String value;

    public InvalidArgumentException(String parameter, String value, String message) {
        // The same status code the SDK uses for its other pre-request parameter checks, since no
        // response is involved.
        super(400, String.format("Invalid value \"%s\" for %s: %s", value, parameter, message));
        this.parameter = parameter;
        this.value = value;
    }

    /**
     * Get the name of the parameter that was rejected.
     *
     * @return the parameter name
     */
    public String getParameter() {
        return parameter;
    }

    /**
     * Get the rejected value.
     *
     * @return the rejected value
     */
    public String getValue() {
        return value;
    }

    /**
     * Get the code identifying this error.
     *
     * @return always {@link #ERROR_CODE}
     */
    public String getErrorCode() {
        return ERROR_CODE;
    }
}
