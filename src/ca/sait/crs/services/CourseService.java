package ca.sait.crs.services;

import ca.sait.crs.contracts.Course;
import ca.sait.crs.exceptions.CannotCreateCourseException;
import ca.sait.crs.factories.CourseFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Manages courses
 * @author Leona Motyer <leona.motyer@edu.sait.ca>
 * @since May 22 2025
 */
public final class CourseService {
    /**
     * Path to courses.csv file.
     */
    public static final String COURSES_CSV = "res/courses.csv";

    /**
     * Holds Course instances.
     */
    private ArrayList<Course> courses;

    /**
     * Initializes CourseService instance
     * @throws FileNotFoundException Thrown if COURSES_CSV file can't be found.
     */
    public CourseService() throws FileNotFoundException {
        this.courses = new ArrayList<>();

        this.load();
    }

    /**
     * Finds course with code
     * @param code Course code
     * @return Course instance or null if not found.
     */
    public Course find(String code) {
        for (Course course : this.courses) {
            if (course.getCode().equals(code)) {
                return course;
            }
        }

        return null;
    }

    /**
     * Gets copy of courses array list.
     * @return Array list of courses.
     */
    public ArrayList<Course> getCourses() {
        return this.courses;
    }
	
	/**
	 * Loads courses from CSV file.
	 * @throws FileNotFoundException Thrown if file can't be found.
	 */
	private void load() throws FileNotFoundException {
	    final File file = new File(COURSES_CSV);
	    final Scanner scanner = new Scanner(file);
	    final CourseFactory factory = new CourseFactory();
	
	    while (scanner.hasNextLine()) {
	        final String line = scanner.nextLine();
	        final String[] parts = line.split(",");
	
	        if (parts.length != 3) {
	            continue;
	        }
	
	        try {
	            final String code = parts[0];
	            final String name = parts[1];
	            final int credits = Integer.parseInt(parts[2]);
	            
	            final Course course = factory.build(code, name, credits);
	            this.courses.add(course);
	        } catch (NumberFormatException | CannotCreateCourseException e) {
	            System.err.println("Skipping invalid course: " + ((Throwable) e).getMessage());
	        }
	    }
	
	    scanner.close();
	}
}
