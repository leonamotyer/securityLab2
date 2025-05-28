package ca.sait.crs.contracts;


import ca.sait.crs.exceptions.CannotCreateRegistrationException;
import ca.sait.crs.contracts.Registration;

import java.util.ArrayList;
import java.util.List;

/**
 * Registration service
 * @author Leona Motyer <leona.motyer@edu.sait.ca>
 * @since May 22 2025
 */
public interface RegistrationService {
    /**
     * Registers student with course
     * @param student Student
     * @param course Course
     * @return Registration model or null.
     */
    Registration register(Student student, Course course) throws CannotCreateRegistrationException;

    /**
     * Gets registrations.
     * @return All registrations
     */
    List<Registration> getRegistrations();
}
