package ca.sait.crs.exceptions;

/**
 * Thrown when course can't be created.
 * @author Leona Motyer <leona.motyer@edu.sait.ca>
 * @since May 22 2025
 */
public class CannotCreateCourseException extends Exception {
    public CannotCreateCourseException(String message) {
        super(message);
    }
}
