import java.util.ArrayList;
import java.util.Scanner;

//Tom Magnan & Elizabeth Davis

public class Student extends User {
	
private ArrayList<String> myCourses = new ArrayList<String>();
private Scanner in = new Scanner(System.in);

	public Student (String user, String pass, String n) {
		super(user, pass, n);	
	}
	
	public void addCourse() {
		CourseRegSystem.printCourses();
		System.out.println("Please select the course that you would like to add:");
		int i = in.nextInt();
		System.out.println("Are you sure you want to register in this course?");
		System.out.println("(1) - yes");
		System.out.println("(2) - no");
		int x = in.nextInt();
		if (x == 1) {
			myCourses.add(CourseRegSystem.getCourse(i-1).getCourseID());
			Course c = CourseRegSystem.getCourseByID(myCourses.get(i-1));
			c.addStudent(getUsername());
			System.out.println("You have now successfully enrolled in this course");
			System.out.println();
			//System.out.println("We added this course to the system");
		}	
		CourseRegSystem.runStudentFunctions(this);
	}
	
	public void dropCourse() {
		printAllCourses();
		if(myCourses.size() == 0) {
			System.out.println("You are not enrolled in any courses, therefore you can not drop any");
			System.out.println();
			CourseRegSystem.runStudentFunctions(this);
		}
		System.out.println("Please select the course that you would like to remove:");
		int i = in.nextInt();
		System.out.println("Are you sure you want to remove them?");
		System.out.println("(1) - yes");
		System.out.println("(2) - no");
		int x = in.nextInt();
		if (x == 1) {
			Course c = CourseRegSystem.getCourseByID(myCourses.get(i-1));
			c.removeStudent(getUsername());
			myCourses.remove(i - 1);
			System.out.println("You have now successfully removed this course");
			System.out.println();
			//System.out.println("We added this course to the system");
			//Course c = CourseRegSystem.getCourseByID(myCourses.get(i-1));
			//c.removeStudent(getUsername());
		}
		CourseRegSystem.runStudentFunctions(this);
	}

	public void printMyCourses() {
		int size = myCourses.size();
		System.out.print("Number of Courses: " + size);
		System.out.println();
		for(int i = 0; i < size; i++) {
			Course c = CourseRegSystem.getCourseByID(myCourses.get(i));
			if (!c.equals(null)) {
				String name = c.getCourseName();
				System.out.println("(" + (i+1) + ") " + name);
			}
			//How to remove for future issues...or just leave?
		}
		System.out.println();
		CourseRegSystem.runStudentFunctions(this);
	}
	
	public void printAllCourses() {
		int size = myCourses.size();
		System.out.print("Number of Courses: " + size);
		System.out.println();
		for(int i = 0; i < size; i++) {
			Course c = CourseRegSystem.getCourseByID(myCourses.get(i));
			if (!c.equals(null)) {
				String name = c.getCourseName();
				System.out.println("(" + (i+1) + ") " + name);
			}
			//How to remove for future issues...or just leave?
		}
		System.out.println();
		//CourseRegSystem.runStudentFunctions(this);
	}
	
}

/** Current Issues:
 *  If a class is removed...fix reference to non-existent course without error
 */