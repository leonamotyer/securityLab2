package ca.sait.crs.exceptions;

/**
 * Thrown when registration can't be created. * @author Leona Motyer <leona.motyer@edu.sait.ca>
 * @since May 22 2025
 */
public class CannotCreateRegistrationException extends Exception {
    public CannotCreateRegistrationException(String message) {
        super(message);
    }
}
