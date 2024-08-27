import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Student {
//    private String degree;
    private String studentId;
    private String name;
    private List<Course> enrolledCourses;

    // CUSTOM ATTRIBUTE
    private String gpa;

    Scanner sc = new Scanner(System.in);
    public Student(String studentID, String name, String Gpa) {
//        this.degree = degree;
        this.studentId = studentID;
        this.name = name;
        this.gpa = gpa;
        this.enrolledCourses = new ArrayList<>();
    }

    // Method to enroll in a course
    public void enrollCourse() {
        CourseRegistrationSystem.checkAvailableCourses();
        System.out.println("Want to enroll in any Course ? Press their Sr.No to enroll, else press anything to go to Main Menu");


        String ch = sc.next();
        try {
            int i = Integer.parseInt(ch);
            if (i <1 || i > 7){
                throw new Exception();
            }
        }
        catch (Exception e){
            System.out.println("WRONG INPUT...");
            return;
        }
        boolean enrolled = true;

        if(new ArrayList<String>(Arrays.asList("1","2","3","4","5","6","7")).contains(ch)){
            if(this.enrolledCourses.contains(CourseRegistrationSystem.courses.get(ch.charAt(0)-'1'))){
                System.out.println("SORRY, CAN NOT ENROLL. YOU ARE ALREADY ENROLLED IN THIS COURSE.");
                return;
            }
        }

        // custom enrollment restriction (CHECKING PRE_REQUISITES)
        if(!CourseRegistrationSystem.courses.get(ch.charAt(0)-'1').preRequisiteCode.equalsIgnoreCase("NO") &&
                this.enrolledCourses.stream().filter(course -> course.title.equalsIgnoreCase(CourseRegistrationSystem.courses.get(ch.charAt(0)-'1').preRequisiteCode)).count() == 0){
            System.out.println("FAILED !!! YOU NEED TO ADD PRE-REQUISITE COURSE FIRST.");
            return;
        }

        switch (ch){

            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7": this.enrolledCourses.add(CourseRegistrationSystem.courses.get(Integer.parseInt(ch)-1));
                enrolled = CourseRegistrationSystem.courses.get(Integer.parseInt(ch)-1).enrollStudent(this);
                if(!enrolled){
                    System.out.println("SORRY, Can not enroll you. Seats are full !");
                }else
                    System.out.println("SUCCESSFULLY ENROLLED !");
                break;
            default: System.out.println("Sorry, unknown choice.");
                break;
        }
        System.out.println("--------------------------------------------------------------");
        System.out.println();
    }

    // Method to display enrolled courses
    public void showEnrolledCourses() {
        System.out.println();
        System.out.println("Here are your Details:  ");
        System.out.println("--------------------------------------------------------------");
        System.out.println("Student ID : "+ this.studentId);
        System.out.println("Name : "+ this.name);
        System.out.println("Enrolled Courses: ");
        if(this.enrolledCourses.isEmpty()){
            System.out.println("NO COURSES ENROLLED.");
        }
        else{
            for(int i=0;i< this.enrolledCourses.size();i++){
                System.out.print(i+1 +". ");
                this.enrolledCourses.get(i).displayCourseCompleteInformation();
            }
        }
        System.out.println("--------------------------------------------------------------");
        System.out.println();
    }

}
