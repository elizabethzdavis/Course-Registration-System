//Tom Magnan & Elizabeth Davis

import java.util.ArrayList;
import java.util.Scanner;

public class Instructor extends User {
	
private ArrayList<String> myCourses = new ArrayList<String>();
private Scanner in = new Scanner(System.in);

	
	public Instructor (String user, String pass, String n) {
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
			c.setInstructor(this);
			//myCourses.add(CourseRegSystem.getCourse(i-1).getCourseID());
			System.out.println("You have now successfully enrolled in this course");
			System.out.println();
		}
		CourseRegSystem.runInstructorFunctions(this);
	}
	
	public void dropCourse() {
		printAllCourses();
		if(myCourses.size() == 0) {
			System.out.println("You are not enrolled in any courses, therefore you can not drop any");
			System.out.println();
			CourseRegSystem.runInstructorFunctions(this);
		}
		System.out.println("Please select the course that you would like to remove:");
		int i = in.nextInt();
		System.out.println("Are you sure you want to remove them?");
		System.out.println("(1) - yes");
		System.out.println("(2) - no");
		int x = in.nextInt();
		if (x == 1) {
			Course c = CourseRegSystem.getCourseByID(myCourses.get(i-1));
			c.removeInstructor();
			myCourses.remove(i - 1);
			System.out.println("You have now successfully removed this course");
			System.out.println();
			//Course c = CourseRegSystem.getCourseByID(myCourses.get(i-1));
			//c.removeInstructor();
		}
		CourseRegSystem.runInstructorFunctions(this);
	}
	
	public void printMyCourses() {
		int size = myCourses.size();
		System.out.print("Number of Courses: " + size);
		System.out.println();
		for(int i = 0; i < size; i++) {
			String name = CourseRegSystem.getCourseByID(myCourses.get(i)).getCourseName();
			System.out.println("(" + (i+1) + ") " + name);
		}
		System.out.println();
		CourseRegSystem.runInstructorFunctions(this);
	}
	
	public void printAllCourses() {
		int size = myCourses.size();
		System.out.print("Number of Courses: " + size);
		System.out.println();
		for(int i = 0; i < size; i++) {
			String name = CourseRegSystem.getCourseByID(myCourses.get(i)).getCourseName();
			System.out.println("(" + (i+1) + ") " + name);
		}
		System.out.println();
		//CourseRegSystem.runInstructorFunctions(this);
	}
	
	public void printNumStudents() {
		for (int i = 0 ; i < myCourses.size() ; i++) {
			int x = i + 1;
			System.out.println(x + ". " + myCourses.get(i));
		}
		System.out.println("Enter Number of Course: ");
		int n = in.nextInt();
		String ns = myCourses.get(n-1);
		int num = CourseRegSystem.getCourseByID(ns).getNumStudents();
		System.out.println("There are " + num + " students.");
		CourseRegSystem.runInstructorFunctions(this);
	}

}
