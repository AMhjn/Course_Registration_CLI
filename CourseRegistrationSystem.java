import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CourseRegistrationSystem {

    static ArrayList<Course> courses = new ArrayList<Course>();
    static Scanner sc = new Scanner(System.in);
    public static void initialiseCourses(){
        courses.add(new LectureCourse("CSE101", "Physics Theory", "Prof. Garrett", 2,new ArrayList<>(Arrays.asList("MONDAY @ 2:30 PM","THURSDAY @ 2:30 PM"))));
        courses.add(new SeminarCourse("CE201", "Advanced Computer Architecture Seminar", "Prof. White", 2,new ArrayList<>(Arrays.asList("TUESDAY @ 1:00 PM","THURSDAY @ 1:00 PM"))));
        courses.add(new LabCourse("CSE201", "Physics Lab", "Dr. Brown", 1,"Physics Theory",new ArrayList<>(Arrays.asList("WEDNESDAY @ 3:00 PM"))));
        courses.add(new LectureCourse("CSE687", "OOD Theory", "Dr. Smith", 1,new ArrayList<>(Arrays.asList("MONDAY @ 8:00 AM","WEDNESDAY @ 8:00 AM "))));
        courses.add(new LabCourse("CSE500", "OOD Lab", "Dr.Bow", 1,"OOD Theory",new ArrayList<>(Arrays.asList("FRIDAY @ 10:AM"))));
        courses.add(new LectureCourse("CSE687", "Intro To AI", "Dr. ABC", 1,new ArrayList<>(Arrays.asList("MONDAY @ 5:00 PM","THURSDAY @ 5:00 PM"))));
        courses.add(new LectureCourse("CSE500", "APFM", "Dr.DEF", 2,new ArrayList<>(Arrays.asList("TUESDAY @ 8:00 AM","THURSDAY @ 8:00 AM "))));

    }

    public static void checkAvailableCourses() {
        System.out.println("--------------------------------------------------------------");
        System.out.println();
        System.out.println("AVAILABLE COURSES : ");
        for(int i=0;i<courses.size();i++){
            if(courses.get(i).availableSeats() > 0){
                System.out.print(i+1 + String.format("%-" + 15 + "s", ". ["+ courses.get(i).getClass().toString().split("C")[0].split(" ")[1] +"]"));
                System.out.print(String.format("%-" + 40 + "s", courses.get(i).title));
                System.out.print(String.format("%-"+25+ "s","AVAILABLE SEATS = " + courses.get(i).availableSeats()));
                System.out.println("Pre-Requisite Course : " + courses.get(i).preRequisiteCode);
            }
        }
    }

    public static void showAllCourses() {
        System.out.println("--------------------------------------------------------------");
        System.out.println();
        System.out.println("ALL COURSES : ");
        for(int i=0;i<courses.size();i++){
                System.out.print(i+1 + String.format("%-" + 15 + "s", ". ["+ courses.get(i).getClass().toString().split("C")[0].split(" ")[1] +"]"));
                System.out.print(String.format("%-" + 40 + "s", courses.get(i).title));
                System.out.print(String.format("%-"+25+ "s","AVAILABLE SEATS = " + courses.get(i).availableSeats()));
                System.out.println("Pre-Requisite Course : " + courses.get(i).preRequisiteCode);
        }
    }

    public static void main(String[] args) {

        // Create some sample courses
        boolean keepGoingForNextStudent = true;

        initialiseCourses();


        while (keepGoingForNextStudent) {
            boolean keepGoingForSameStudent = true;
            System.out.println();
            System.out.println("--------------------------------------------------------------");
            System.out.println("HELLO, WELCOME TO SYRACUSE UNIVERSITY COURSE REGISTRATION SYSTEM  :)");
            System.out.println("--------------------------------------------------------------");
            System.out.println();
            System.out.println("Please Enter your Details to go ahead !");
            System.out.print("Enter your Student ID : ");
            String sID = sc.next();
            System.out.print("Enter your Name : ");
            String sName = sc.next();
            System.out.print("Enter your GPA : ");
            String sGpa = sc.next();

            // PRE_REQUISITE OF GPA
            try{
                if(Float.parseFloat(sGpa) < 3.0){
                    System.out.println();
                    System.out.println("Sorry, You can not Register. GPA should be atleast 3.0");
                    System.out.println("LOGGING YOU OUT !!!");
                    continue;
                }
                else if(Float.parseFloat(sGpa) > 4.0){
                    System.out.println();

                    System.out.println("Sorry, Maximum GPA is 4.0");
                    System.out.println("LOGGING YOU OUT !!!");

                    continue;
                }
            }
            catch (Exception e){
                System.out.println("WRONG INPUT...");
                continue;
            }

            Student s = new Student(sID,sName,sGpa);

            while(keepGoingForSameStudent){
                System.out.println();
                System.out.println("You can have a look at the options down below and enter the code below to do that action ...");
                System.out.println("--------------------------------------------------------------");
                System.out.println("MAIN MENU :");
                System.out.println("1. Check Available Courses: ");
                System.out.println("2. Enroll in Courses:");
                System.out.println("3. View Courses Enrolled & User Details:   ");
                System.out.println("4. View Details of All Courses: ");
                System.out.println("5. Log out: ");

                System.out.print("Enter your choice : ");
                String choice = sc.next();

                switch (choice) {
                    case "1":
                        checkAvailableCourses();
                        break;
                    case "2":
                        boolean continueEnrolling = true;
                        while(continueEnrolling){
                            s.enrollCourse();
                            System.out.println();
                            System.out.println("WANT TO ENROLL IN MORE COURSES? PRESS y/Y or Anything else to go to Main Menu:");
                            String inp = sc.next();
                            if(!(inp.charAt(0)== 'y' || inp.charAt(0) =='Y')){
                                continueEnrolling = false;
                            }
                        }
                        break;
                    case "3":
                        s.showEnrolledCourses();
                        break;
                    case "4":
                        showAllCourses();
                        System.out.println("Press the Sr.No of course to view its Details : ");
                        String courseIndex = sc.next();
                        try {
                            int i = Integer.parseInt(courseIndex);
                            if (i <1 || i > 7){
                                throw new Exception();
                            }
                        }
                        catch (Exception e){
                            System.out.println("SORRY, WRONG INPUT...");
                            return;
                        }
                        courses.get((int)courseIndex.charAt(0)-'1').displayCourseCompleteInformation();
                        break;
                    case "5":
                        keepGoingForSameStudent = false;
                        break;
                    default:
                        System.out.println("SORRY,WRONG INPUT.");
                        break;
                }

            }


            System.out.println();
            System.out.println("You have Logged out.");
            System.out.println("Thanks for using our system. See you soon !");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------");

            System.out.println("TO DO A NEW STUDENT REGISTRATION, PRESS y/Y. or Anything else to exit from portal.");
            String input = sc.next();

            if(!(input.charAt(0) == 'y' || input.charAt(0) == 'Y')){
                keepGoingForNextStudent = false;
            }

        }
    }

}
