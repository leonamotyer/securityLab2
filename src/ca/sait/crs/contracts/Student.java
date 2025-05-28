package ca.sait.crs.contracts;

/**
 * Student contract
 * @author Leona Motyer <leona.motyer@edu.sait.ca>
 * @since May 22 2025
 */
public interface Student {
    /**
     * Gets student's name
     * @return Student name
     */
    public String getName();

    /**
     * Gets student GPA
     * @return Students GPA
     */
    public double getGpa();
}
