In this CLI Assignment, I have implemented the required as follows :

A) Course Class Implementation
    1) Designed the base class "Course" with
        - fundamental attributes : courseCode , title , instructor, maxCapacity;
        - custom attributes : enrolledStudents , location , schedule , description , preRequisiteCode

    2) Implemented methods for:
        - enrolling students :  enrollStudent()
        - checking available seats :  availableSeats()
        - generating class schedules: generateSchedule()

B) Subclasses for Course Types
    1) Created subclasses:
        - LabCourse, SeminarCourse,LectureCourse and inherited them from the base class(Course).
    2) Extended each subclass with specific attributes and methods like
        - numberOfLabExperiments,  and getNumberOfLabExperiments()
        - numberOfExams , and  getNumberOfExams()
        - numberOfReadingAssignments , and getNumberOfReadingAssignments()
    3) Effective use of polymorphism to override methods where necessary :
        - Implemented Polymorphism by overriding getDescription() and displayCourseCompleteInformation() of Parent class

C) Enrollment System
    1) Implemented a flexible enrollment system accommodating variations in prerequisites like:
        - Lab courses have a pre-requisite Theory course. (can not enroll in Lab  thCourse, if corresponding Theory course is not Added)
        - Student must have a GPA > 3.0, to register new courses.
    2) Handled enrollment restrictions (e.g., maximum capacity),
        - When the seats are full, You won't see that course in Available Courses, and won't be able to enroll in it.
        - You can't enroll in a course if you are already enrolled.
        - Pre-Requisite course must be added to enroll in dependent course
    3) Use of polymorphism to customize enrollment logic.
        - Override following methods of Parent class in Sub-classes to have different/specific behavior for each subclass:
            *) getDescription() and
            *) displayCourseCompleteInformation()
    4) Introduction of at least 1 custom enrollment restriction.
        - Can not enroll in a course, if its pre-requisite course is not enrolled.
        - Student must have a GPA > 3.0, to register new courses.
    5) Proper error handling and user feedback during the enrollment process.
        - Proper Error Handling and Feedback Messages are provided to Students to have clear communication like :
            *) SUCCESSFULLY ENROLLED
            *) SORRY, FAILED. YOU ARE ALREADY ENROLLED IN THIS COURSE.
            *) YOU CAN NOT REGISTER, GPA MUST BE GREATER THAN 3.0

D) Student Class Implementation
    1) Designed the student class with attributes like
        - studentId , name, gpa , enrolledCourses.
    2) Properly handled an individual student registrations.
        - If already enrolled in any subject, can not register again.
        - Student can see only their user information and Their courses enrolled information).

E) Command Line Interface (CLI) for Students
    1) Effectively used polymorphism  where ever required to provide a consistent interface for different course types.
        - Override getDescription() and displayCourseCompleteInformation() of Parent class in Sub-classes to use the specific attributes of subclass
    2) students can retrieve details of the courses they have enrolled in.
        - By selecting the 3rd option in MAIN MENU, students can view the courses they are enrolled in.
    3) Students can see any course information if they want to see before registration.
        - By selecting the 4th option, students can view all the information of all the courses they want to look.