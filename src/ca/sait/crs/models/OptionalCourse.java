package ca.sait.crs.models;

import ca.sait.crs.contracts.Course;

/**
 * Represents an optional (zero credit) course.
 * @author Leona Motyer <leona.motyer@edu.sait.ca>
 * @since May 22 2025
 */
public final class OptionalCourse implements Course {
    /**
     * Course code
     */
    private final String code;

    /**
     * Name of course
     */
    private final String name;

    /**
     * Initializes instance
     * @param code Course code (must not be empty)
     * @param name Course name (must not be empty)
     * @throws IllegalArgumentException if any parameter is invalid
     */
    public OptionalCourse(String code, String name) {
        if (code == null || code.trim().isEmpty()) {
            throw new IllegalArgumentException("Course code cannot be null or empty");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Course name cannot be null or empty");
        }
        
        this.code = code;
        this.name = name;
    }

    /**
     * Gets course code
     * @return Course code
     */
    @Override
    public String getCode() {
        return this.code;
    }

    /**
     * Gets course name
     * @return Course name
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * String representation of course
     * @return Formatted course information
     */
    public String toString() {
        return String.format("%s (%s)", this.getName(), this.getCode());
    }
}