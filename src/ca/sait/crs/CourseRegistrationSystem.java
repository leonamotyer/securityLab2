package ca.sait.crs;

import ca.sait.crs.contracts.*;
import ca.sait.crs.exceptions.*;
import ca.sait.crs.factories.*;
import ca.sait.crs.services.*;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Course Registration System
 * @author Leona Motyer <leona.motyer@edu.sait.ca>
 * @since May 22 2025
 */
public class CourseRegistrationSystem {
    private final Scanner scanner;
    private final CourseService courseService;
    private final RegistrationService registrationService;
    private final StudentFactory studentFactory;

    public CourseRegistrationSystem() throws FileNotFoundException {
        this.scanner = new Scanner(System.in);
        this.courseService = new CourseService();
        this.studentFactory = new StudentFactory();
        
        // Create real registration service
        RealRegistrationService realService = new RealRegistrationService();
        
        // Wrap real service with proxy
        this.registrationService = new ProxyRegistrationService(realService);
    }


    /**
     * Starts the CRS
     * Do not modify this method!
     */
    public void start() {
        System.out.println("Course Registration System");
        System.out.println();

        int option = - 1;

        while (option != 4) {
            System.out.println("Option\tDescription");
            System.out.println("1\tList courses");
            System.out.println("2\tList registrations");
            System.out.println("3\tRegister");
            System.out.println("4\tExit");
            System.out.println();

            System.out.print("Enter option: ");
            option = this.scanner.nextInt();

            this.scanner.nextLine();

            switch (option) {
                case 1: {
                    this.listCourses();
                    break;
                }

                case 2: {
                    this.listRegistrations();
                    break;
                }

                case 3: {
                    this.register();
                    break;
                }

                default: {
                    break;
                }
            }
        }

        System.out.println("Exiting...");

    }

    /**
     * Lists the courses.
     * Do not modify this method!
     */
    private void listCourses() {
        System.out.println("Code\tName");
        System.out.println();

        for (Course course : this.courseService.getCourses()) {
            System.out.printf("%s\t%s\n", course.getCode(), course.getName());
        }

        System.out.println();
    }

    /**
     * Lists the registrations.
     * Do not modify this method!
     */
    private void listRegistrations() {
        System.out.println("Course Code\tName");
        System.out.println();

        for (Registration registration : this.registrationService.getRegistrations()) {
            System.out.printf("%s\t%s\n", registration.getCourse().getCode(), registration.getStudent().getName());
        }

        System.out.println();
    }

    /**
     * Registers a student with a course.
     */
    private void register() {
        System.out.print("Enter course code: ");
        String courseCode = this.scanner.nextLine();

        Course course = this.courseService.find(courseCode);

        System.out.print("Enter student name: ");
        String studentName = this.scanner.nextLine();

        System.out.print("Enter student GPA: ");
        double studentGpa = this.scanner.nextDouble();
        this.scanner.nextLine();  // Consume newline character

        try {
            // Use StudentFactory to create validated student instance
            Student student = this.studentFactory.build(studentName, studentGpa);

            Registration registration = this.registrationService.register(student, course);

            System.out.println("Student \"" + student.getName() + 
                               "\" has been registered in \"" + 
                               course.getCode() + " - " + course.getName() + 
                               "\" course.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Please try again.");
        }
    
    }
}
