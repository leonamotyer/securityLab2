package ca.sait.crs.services;

import java.util.ArrayList;

import ca.sait.crs.contracts.*;
import ca.sait.crs.exceptions.CannotCreateRegistrationException;
import ca.sait.crs.factories.RegistrationFactory;

/**
 * Registers student with course.
 * @author Leona Motyer <leona.motyer@edu.sait.ca>
 * @since May 22 2025
 */
public final class RealRegistrationService implements RegistrationService {
    /**
     * List of registrations
     */
    private final ArrayList<Registration> registrations;

    /**
     * Initializes service
     */
    public RealRegistrationService() {
        this.registrations = new ArrayList<>();
    }

    /**
     * Registers student with course
     * @param student Student instance to register
     * @param course Course instance to register for
     * @return Created registration
     * @throws CannotCreateRegistrationException if registration cannot be created
     */
    @Override
    public Registration register(Student student, Course course) throws CannotCreateRegistrationException {
        final RegistrationFactory factory = new RegistrationFactory();
        final Registration registration = factory.build(course, student);
        
        this.registrations.add(registration);
        return registration;
    }

    /**
     * Gets all registrations
     * @return Copy of registrations list
     */
    @Override
    public ArrayList<Registration> getRegistrations() {
        return new ArrayList<>(this.registrations);
    }
}