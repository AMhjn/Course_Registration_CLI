import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Course {

    protected String courseCode;
    protected String title;
    protected String instructor;
    protected int maxCapacity;

    // CUSTOM ATTRIBUTES
    protected List<Student> enrolledStudents;
    protected String location;
    protected List<String> schedule;
    protected  String description;
    protected  String preRequisiteCode;


    //  Default Constructor


    // Default Constructor
    public Course() {
    }

    // Parameterised Constructor
    public Course(String courseCode, String title, String instructor, int maxCapacity) {
        this.courseCode = courseCode;
        this.title = title;
        this.instructor = instructor;
        this.maxCapacity = maxCapacity;
        this.enrolledStudents = new ArrayList<>();
        this.location = "To be decided...";
        this.schedule = new ArrayList<>(Arrays.asList("To be decided"));
        this.description= "";
        this.preRequisiteCode = "NO";
    }

    // Method to enroll a student
    public boolean enrollStudent(Student student) {
        if (this.enrolledStudents.size() < maxCapacity) {
            this.enrolledStudents.add(student);
            return true;
        }
        System.out.println("SORRY, SEATS ARE FULL. CAN NOT ENROLL NOW.");
        return false;
    }

    // Method to check available seats
    public int availableSeats() {
        return this.maxCapacity - this.enrolledStudents.size();
    }

    // Method to generate class schedule
    public String generateSchedule() {
        String schedule = "";
        for(String s : this.schedule){
            schedule += s +"       ";
        }
        return schedule;
    }

    public String getDescription(){
        return this.description;
    }

    public  void displayCourseCompleteInformation(){
        System.out.println(this.title.toUpperCase());
        System.out.println("        DESCRIPTION: " + this.getDescription());
        System.out.println("        COURSE CODE: " + this.courseCode);
        System.out.println("        INSTRUCTOR: " + this.instructor);
        System.out.println("        MAXIMUM CAPACITY: " + this.maxCapacity);
        System.out.println("        AVAILABLE SEATS: " + this.availableSeats());
        System.out.println("        LOCATION: " + this.location);
        System.out.println("        SCHEDULE: " + this.generateSchedule());
        System.out.println("        PRE-REQUISITE COURSE: " + this.preRequisiteCode);
    }

}
