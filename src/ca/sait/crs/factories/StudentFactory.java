package ca.sait.crs.factories;

import ca.sait.crs.contracts.Student;
import ca.sait.crs.exceptions.CannotCreateStudentException;

/**
 * Creates student instances.
 * @author Leona Motyer <leona.motyer@edu.sait.ca>
 * @since May 22 2025
 */
public final class StudentFactory {
    public StudentFactory() {
    }

    /**
     * Builds a Student instance
     * @param name Name of student
     * @param gpa Student's GPA
     * @return Student instance
     * @throws CannotCreateStudentException if validation fails
     */
    public Student build(String name, double gpa) throws CannotCreateStudentException {
        if (!this.validateName(name))
            throw new CannotCreateStudentException("Student name is invalid.");

        if (!this.validateGpa(gpa))
            throw new CannotCreateStudentException("Student GPA is invalid.");

        return new ca.sait.crs.models.Student(name, gpa);
    }

    /**
     * Validates student name
     * @param name Student name
     * @return True if name is valid
     */
    private boolean validateName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    /**
     * Validates student GPA
     * @param gpa Student GPA
     * @return True if GPA is valid
     */
    private boolean validateGpa(double gpa) {
        return gpa >= 0.0 && gpa <= 4.0;
    }
}