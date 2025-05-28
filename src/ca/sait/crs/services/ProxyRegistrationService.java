package ca.sait.crs.services;

import ca.sait.crs.contracts.Course;
import ca.sait.crs.contracts.Registration;
import ca.sait.crs.contracts.RegistrationService;
import ca.sait.crs.contracts.Student;
import ca.sait.crs.exceptions.CannotCreateRegistrationException;

import java.util.ArrayList;
import java.util.List;

/**
 * Proxy service for handling course registrations.
 * @author Leona Motyer <leona.motyer@edu.sait.ca>
 * @since May 22 2025
 */
public final class ProxyRegistrationService implements RegistrationService {
    /**
     * Real registration service instance (immutable reference)
     */
    private final RegistrationService realService;

    /**
     * Initializes proxy with real registration service.
     * @param realService The actual registration service to delegate to
     */
    public ProxyRegistrationService(RegistrationService realService) {
        this.realService = realService;
    }

    /**
     * Registers a student for a course after validating GPA eligibility.
     * @param student Student to register
     * @param course Course to register for
     * @return Registration instance
     * @throws CannotCreateRegistrationException if student's GPA is 2.0 or lower
     */
    @Override
    public Registration register(Student student, Course course) throws CannotCreateRegistrationException {
        // Check GPA requirement before proceeding
        if (student.getGpa() <= 2.0) {
            throw new CannotCreateRegistrationException(
                "Student GPA must be greater than 2.0 to register for courses"
            );
        }

        // Delegate to real service if eligibility check passes
        return realService.register(student, course);
    }

    /**
     * Gets list of registrations from real service.
     * @return List of registrations
     */
    @Override
    public List<Registration> getRegistrations() {
        return realService.getRegistrations();
    }
}