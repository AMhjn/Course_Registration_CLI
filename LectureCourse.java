import java.util.ArrayList;
import java.util.Arrays;

public class LectureCourse extends Course{

    //Subclass Specific Attributes
    int numberOfExams;
    public LectureCourse(String courseCode, String title, String instructor, int maxCapacity,ArrayList<String> schedule) {
        super(courseCode, title, instructor, maxCapacity);
        this.location = "LIFE SCIENCES-103";
        this.schedule = schedule;
        this.numberOfExams = 3;
    }

    public int getNumberOfExams() {
        return numberOfExams;
    }


    // IMPLEMENTING POLYMORPHISM (Overriding parent class method)
    @Override
    public String getDescription() {
        return "Hello Everybody."+ this.title + " is a LECTURE Course. In thi we will have 2 Midterms and 1 Final Examinations";
    }

    @Override
    public void displayCourseCompleteInformation(){
        super.displayCourseCompleteInformation();
        System.out.println("        NUMBER OF EXAMS: " + this.getNumberOfExams());
        System.out.println();
    }
}
