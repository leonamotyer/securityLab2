package ca.sait.crs.factories;

import ca.sait.crs.contracts.Course;
import ca.sait.crs.contracts.Registration;
import ca.sait.crs.contracts.Student;
import ca.sait.crs.exceptions.CannotCreateRegistrationException;

/**
 * Creates Registration instances.
 * @author Leona Motyer <leona.motyer@edu.sait.ca>
 * @since May 22 2025
 */
public final class RegistrationFactory {

    public RegistrationFactory() {
    }

    /**
     * Builds a Registration instance.
     * @param course Course
     * @param student Student
     * @return Registration instance
     * @throws CannotCreateRegistrationException Thrown if parameters are invalid.
     */
    public Registration build(Course course, Student student) throws CannotCreateRegistrationException {
        // Do not check if students is eligible for registration here.
        // Only validate basic object integrity

        if (!this.validateCourse(course)) {
            throw new CannotCreateRegistrationException("Course is invalid.");
        }

        if (!this.validateStudent(student)) {
            throw new CannotCreateRegistrationException("Student is invalid.");
        }

        return new ca.sait.crs.models.Registration(course, student);
    }

    /**
     * Validates a course.
     * @param course Course
     * @return True if course is valid (non-null)
     */
    private boolean validateCourse(Course course) {
        return course != null;
    }

    /**
     * Validates a student.
     * @param student Student
     * @return True if student is valid (non-null with valid name and GPA)
     */
    private boolean validateStudent(Student student) {
        return student != null 
            && student.getName() != null 
            && !student.getName().trim().isEmpty() 
            && student.getGpa() >= 0.0 
            && student.getGpa() <= 4.0;
    }
}