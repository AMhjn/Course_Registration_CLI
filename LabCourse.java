import java.util.ArrayList;
import java.util.Arrays;

public class LabCourse extends Course{

    //Subclass Specific Attributes
    int numberOfLabExperiments;

    // DEFAULT CONSTRUCTOR
    LabCourse(){

    }

    // PARAMETERIZED CONSTRUCTOR (Different number of Parameters)
    public LabCourse(String courseCode, String title, String instructor, int maxCapacity, String preRequisiteCode, ArrayList<String> schedule) {
        super(courseCode, title, instructor, maxCapacity);
        this.location = "LAB-101 ";
        this.schedule = schedule;
        this.numberOfLabExperiments = 12;
        this.preRequisiteCode = preRequisiteCode;
    }

    public int getNumberOfLabExperiments() {
        return numberOfLabExperiments;
    }


    // IMPLEMENTING POLYMORPHISM (Overriding parent class method)
    @Override
    public String getDescription() {
        return "Hello Everybody."+ this.title + " is a LAB Course. In thiS we will have only 1 LAB VIVA and PRACTICAL EXAM.";
    }

    @Override
    public void displayCourseCompleteInformation(){
        super.displayCourseCompleteInformation();
        System.out.println("        NUMBER OF LAB EXPERIMENTS: " + this.getNumberOfLabExperiments());
        System.out.println();
    }

}
