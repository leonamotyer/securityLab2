package ca.sait.crs.exceptions;

/**
 * Thrown if student can't be created.
 * @author Leona Motyer <leona.motyer@edu.sait.ca>
 * @since May 22 2025
 */
public class CannotCreateStudentException extends Exception {
    public CannotCreateStudentException(String message) {
        super(message);
    }
}
