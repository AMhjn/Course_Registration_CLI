import java.util.ArrayList;
import java.util.Arrays;

public class SeminarCourse extends Course{

    //Subclass Specific Attributes
    int numberOfReadingAssignments;
    public SeminarCourse(String courseCode, String title, String instructor, int maxCapacity,ArrayList<String> schedule) {
        super(courseCode, title, instructor, maxCapacity);
        this.location = "AUDITORIUM-001";
        this.schedule = schedule;
        this.numberOfReadingAssignments = 6;
    }

    public int getNumberOfReadingAssignments() {
        return numberOfReadingAssignments;
    }


    // IMPLEMENTING POLYMORPHISM (Overriding parent class method)
    @Override
    public String getDescription() {
        return "Hello Everybody."+ this.title + " is a Seminar Course. In this we will not have any Examinations. but we will have " +
                "regular Reading assignments";
    }

    @Override
    public void displayCourseCompleteInformation(){
        super.displayCourseCompleteInformation();
        System.out.println("        NUMBER OF READING ASSIGNMENTS: " + this.getNumberOfReadingAssignments());
        System.out.println();
    }
}
