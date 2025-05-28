package ca.sait.crs.models;

/**
 * Represents a student.
 * @author Leona Motyer <leona.motyer@edu.sait.ca>
 * @since May 22 2025
 */
public final class Student implements ca.sait.crs.contracts.Student {
    /**
     * Name of student
     */
    private String name;

    /**
     * Students GPA (between 0.00 and 4.00)
     */
    private double gpa;

    /**
     * Initializes instance.
     * @param name Name of student
     * @param gpa Student's GPA
     */
    public Student(String name, double gpa) {
        this.setName(name);
        this.setGpa(gpa);
    }

    /**
     * Gets student's name
     * @return Name of student
     */
    public String getName() {
        return name;
    }

    /**
     * Gets students GPA
     * @return GPA
     */
    public double getGpa() {
        return gpa;
    }

    /**
     * Sets the students name.
     * @param name Name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the students GPA
     * @param gpa GPA
     */
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    /**
     * Transforms Student instance to String
     * @return Student's name
     */
    @Override
    public String toString() {
        return this.getName();
    }
}
