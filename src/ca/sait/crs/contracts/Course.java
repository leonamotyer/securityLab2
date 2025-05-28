package ca.sait.crs.contracts;

/**
 * Course contract
 * @author Leona Motyer <leona.motyer@edu.sait.ca>
 * @since May 22 2025
 */
public interface Course {
    /**
     * Gets the course code
     * @return Course code
     */
    String getCode();

    /**
     * Gets name of course
     * @return Name of course
     */
    String getName();
}
