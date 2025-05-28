package ca.sait.crs.models;

import ca.sait.crs.contracts.Course;

/**
 * Represents a required (for credit) course.
 * @author Leona Motyer <leona.motyer@edu.sait.ca>
 * @since May 22 2025
 */
public final class RequiredCourse implements Course {
    /**
     * Course code
     */
    private final String code;

    /**
     * Course name
     */
    private final String name;

    /**
     * Course credits
     */
    private final int credits;

    /**
     * Initializes instance
     * @param code Course code
     * @param name Course name
     * @param credits Course credits (must be positive)
     * @throws IllegalArgumentException if any parameter is invalid
     */
    public RequiredCourse(String code, String name, int credits) {
        if (code == null || code.trim().isEmpty()) {
            throw new IllegalArgumentException("Course code cannot be null or empty");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Course name cannot be null or empty");
        }
        if (credits <= 0) {
            throw new IllegalArgumentException("Credits must be positive");
        }
        
        this.code = code;
        this.name = name;
        this.credits = credits;
    }

    /**
     * Gets course code
     * @return Course code
     */
    @Override
    public String getCode() {
        return code;
    }

    /**
     * Gets course name
     * @return Course name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Gets course credits
     * @return Credits value
     */
    public int getCredits() {
        return credits;
    }

    /**
     * String representation of course
     * @return Formatted course information
     */
    @Override
    public String toString() {
        return String.format("%s (%s)", this.getName(), this.getCode());
    }
}