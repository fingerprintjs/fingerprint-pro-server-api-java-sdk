package com.fingerprint.sdk;

/**
 * Checks on values that are substituted into the URL path.
 */
public final class PathParameters {

    private PathParameters() {
    }

    /**
     * Rejects a value that cannot be sent as a path segment addressing a resource.
     *
     * @param parameter the name of the path parameter, used to name it in the error
     * @param value the value about to be substituted into the path
     * @throws InvalidArgumentException if the value is {@code "."} or {@code ".."}
     */
    public static void validate(String parameter, String value) throws InvalidArgumentException {
        if (".".equals(value) || "..".equals(value)) {
            throw new InvalidArgumentException(parameter, value, "\".\" and \"..\" are not valid identifiers");
        }
    }
}
