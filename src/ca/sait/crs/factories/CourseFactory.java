package ca.sait.crs.factories;

import ca.sait.crs.contracts.Course;
import ca.sait.crs.exceptions.CannotCreateCourseException;
import ca.sait.crs.models.OptionalCourse;
import ca.sait.crs.models.RequiredCourse;

/**
 * Creates course instances.
 * @author Leona Motyer <leona.motyer@edu.sait.ca>
 * @since May 22 2025
 */
public final class CourseFactory {

    public CourseFactory() {
    }

    /**
     * Builds a Course instance
     * @param code Course code
     * @param name Name of course
     * @param credits Number of credits for course
     * @return RequiredCourse or OptionalCourse instance
     * @throws CannotCreateCourseException if validation fails
     */
    public Course build(String code, String name, int credits) throws CannotCreateCourseException {
        if (!this.validateCode(code)) {
            throw new CannotCreateCourseException("Course code is invalid.");
        }

        if (!this.validateName(name)) {
            throw new CannotCreateCourseException("Course name is invalid.");
        }

        if (!this.validateCredits(credits)) {
            throw new CannotCreateCourseException("Course credits must be non-negative.");
        }

        if (credits > 0) {
            return new RequiredCourse(code, name, credits);
        } else {
            return new OptionalCourse(code, name);
        }
    }

    /**
     * Checks the course code is valid.
     * @param code Course code
     * @return True if the course code matches pattern: 3 to 5 letters followed by a dash and 3 digits
     */
    private boolean validateCode(String code) {
        // Allow formats like "ABCD-123" or "ABCD123"
        return code != null && code.matches("^[A-Za-z]{3,5}-\\d{3}$");
    }

    /**
     * Validates course name
     * @param name Course name
     * @return True if course name is non-empty
     */
    private boolean validateName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    /**
     * Validates course credits
     * @param credits Course credits
     * @return True if credits are non-negative
     */
    private boolean validateCredits(int credits) {
        return credits >= 0;
    }
}