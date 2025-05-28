package ca.sait.crs.models;

import ca.sait.crs.contracts.Course;
import ca.sait.crs.contracts.Student;

/**
 * Represents a registration.
 * @author Leona Motyer <leona.motyer@edu.sait.ca>
 * @since May 22 2025
 */
public final class Registration implements ca.sait.crs.contracts.Registration {
    /**
     * Associated course
     */
    private final Course course;
    
    /**
     * Associated student
     */
    private final Student student;

    /**
     * Initializes instance.
     * @param course Course instance (must not be null)
     * @param student Student instance (must not be null)
     * @throws IllegalArgumentException if parameters are invalid
     */
    public Registration(Course course, Student student) {
        if (course == null) {
            throw new IllegalArgumentException("Course cannot be null");
        }
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        
        this.course = course;
        this.student = student;
    }

    /**
     * Gets the course.
     * @return Registered course
     */
    @Override
    public Course getCourse() {
        return course;
    }

    /**
     * Gets the student
     * @return Registered student
     */
    @Override
    public Student getStudent() {
        return student;
    }
}