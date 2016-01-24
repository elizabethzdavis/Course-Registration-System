//Tom Magnan & Elizabeth Davis

import java.util.ArrayList;
import java.util.Scanner;


public class CourseRegSystem {

private static ArrayList<Course> allCourses   = new ArrayList<Course>();
private static ArrayList<Student> allStudents = new ArrayList<Student>();
private static ArrayList<Instructor> allInstructors = new ArrayList<Instructor>();
private static boolean exit;
private static Scanner in = new Scanner(System.in);

	
	public static void main (String[] args) {
		exit = false;
		while(!exit) {
			Login();
		}
		System.out.println("Thank you for using our system.");
		System.out.println("Have a great Day!");
	}
	public static void Login(){
		
		//Somehow save to return to screen so multiple things can be added
		System.out.println("Welcome to GW's New Course Registration System.");
		System.out.println("Please Specify your user type:");
		System.out.println("(1) Administrator (2) Instructor (3) Student (4) Exit");
		int type = in.nextInt();
		if (type == 4) {
			System.out.println("Thank you for using our system.");
			System.out.println("Have a great Day!");
			System.exit(0);
		}
		if (type > 4) {
			System.out.println("Invalid entry, please try again.");
			Login();
		}
		System.out.println("Username:");
		String user = in.next();
		System.out.println("Password:");
		String pass = in.next();

		
		switch(type) {
		case 1:
			//Admin
			//System.out.println("Welcome Admin:");
			Admin a = new Admin(user, pass, "Admin");
			if (!user.equals(a.getUsername())) {
				System.out.println("You're Username is not correct.");	
				Login();
				return;
			}
			if (!pass.equals(a.getPassword())) {
				System.out.println("You're Password is not correct.");
				Login();
				return;
			}
			System.out.println("Welcome " + a.getName() + ":");
			
			//After success...complete
			runAdminFunctions();
			boolean end = false;
			while (!end) {
				System.out.println("Would you like to do anything else?");
				System.out.println("(1) - Yes (2) - No");
				int x = in.nextInt();
				if (x == 1) {
					runAdminFunctions();
				}
				else {
					end = true;
				}
			}
			break;
		case 2:
			//Instructor
			for (int i = 0 ; i < allInstructors.size() ; i++) {
				if (user.equals(allInstructors.get(i).getUsername())) {
					if (pass.equals(allInstructors.get(i).getPassword())) {
						//Continue
						Instructor inst = allInstructors.get(i);
						System.out.println("Welcome Professor " + inst.getName() + ":");
						
						//After success...complete
						runInstructorFunctions(inst);
						boolean end1 = false;
						while (!end1) {
							System.out.println("Would you like to do anything else?");
							System.out.println("(1) - Yes (2) - No");
							int x = in.nextInt();
							if (x == 1) {
								runInstructorFunctions(inst);
							}
							else {
								end1 = true;
								Login();
							}
						}
					}
				}
			}
			System.out.println("You're Username and/or Password is not correct.  Please try again.");
			Login();
			break;
		case 3:
			//Student
			for (int i = 0 ; i < allStudents.size() ; i++) {
				if (user.equals(allStudents.get(i).getUsername())) {
					if (pass.equals(allStudents.get(i).getPassword())) {
						//Continue
						Student stu = allStudents.get(i);
						System.out.println("Welcome Mr./Ms. " + stu.getName() + ":");
						
						//After success...complete
						runStudentFunctions(stu);
						boolean end1 = false;
						while (!end1) {
							System.out.println("Would you like to do anything else?");
							System.out.println("(1) - Yes (2) - No");
							int x = in.nextInt();
							if (x == 1) {
								runStudentFunctions(stu);
							}
							else {
								end1 = true;
								Login();
							}
						}
					}
				}
			}
			System.out.println("You're Username and/or Password is not correct.  Please try again.");
			Login();
			break;
		default:
			System.out.println("Invalid input, please try again.");
			return;
		}	
	}
	
	//**************ADMIN***************//
	public static void runAdminFunctions() {
		System.out.println("What would you like to do?");
		System.out.println("1 - Add a User");
		System.out.println("2 - Remove a User");
		System.out.println("3 - Create a Course");
		System.out.println("4 - Remove a Course");
		System.out.println("5 - Exit");
		int selection = in.nextInt();
		switch(selection){
		//Go to new method for each case
		case 1:
			//Add User
			//What type of User
			addUser();
			break;
		case 2:
			//Remove a User
			//What type of User
			removeUser();
			break;
		case 3:
			//Create a Course
			addCourse();
			break;
		case 4:
			//Remove a Course
			removeCourse();
			break;
		case 5:
			Login();
			break;
		default:
			System.out.println("invalid input, try again");
		}
		return;
	}
	
	//**************STUDENT***************//
	public static void runStudentFunctions(Student s) {
		System.out.println("What would you like to do?");
		System.out.println("1 - Enroll in a Course");
		System.out.println("2 - Drop a Course");
		System.out.println("3 - List Courses");
		System.out.println("4 - Exit");
		int selection = in.nextInt();
		switch(selection){
		//Go to new method for each case
		case 1:
			//Enroll in course
			s.addCourse();
			break;
		case 2:
			//Drop a course
			s.dropCourse();
			break;
		case 3:
			//Print Their Courses
			s.printMyCourses();
			addCourse();
			break;
		case 4:
			Login();
			break;
		default:
			System.out.println("Invalid input, plase try again.");
			runStudentFunctions(s);
		}
		return;
	}
	
	//*************INSTRUCTOR*******************//
	//CHANGE INFO IN SWITCH to fit Instructor
	public static void runInstructorFunctions(Instructor p) {
		System.out.println("What would you like to do?");
		System.out.println("1 - Enroll in a Course");
		System.out.println("2 - Remove a Course");
		System.out.println("3 - List Courses");
		System.out.println("4 - Exit");
		int selection = in.nextInt();
		
		switch(selection){
		case 1:
			p.addCourse();
			break;
		case 2:
			p.dropCourse();
			break;
		case 3:
			p.printMyCourses();
			break;
		case 4:
			Login();
			break;
		default:
			System.out.println("Invalid input, please try again.");
			runInstructorFunctions(p);
		}
		return;
	}
	
	public static void addUser() {
		System.out.println("What type User would you like to create?");
		System.out.println("1 - Instructor");
		System.out.println("2 - Student");
		int selection = in.nextInt();
		switch(selection) {
		case 1:
			//Create an Instructor
			addInstructor();
			break;
		case 2:
			//Create Student
			addStudent();
			break;
		default:
			break;
		}
	}
	
	public static void removeUser() {
		System.out.println("What type User would you like to remove?");
		System.out.println("1 - Instructor");
		System.out.println("2 - Student");
		int selection = in.nextInt();
		switch(selection) {
		case 1:
			//Remove an Instructor
			removeInstructor();
			break;
		case 2:
			//Remove Student
			removeStudent();
			break;
		default:
			break;
		}
	}
	
	public static void addCourse() {
		System.out.println("Enter course name:");
		String name = in.next();
		in.nextLine();
		System.out.println("Enter courseID:");
		//System.out.println();
		String courseID = in.next();
		in.nextLine();
		Course courseName = new Course(name, courseID);
		allCourses.add(courseName);
	}
	
	public static void addInstructor() {
		System.out.println("Enter username:");
		String username = in.next();
		System.out.println("Enter password:");
		String password = in.next();
		System.out.println("Enter Instructor's Last Name:");
		String name = in.next();
		Instructor in = new Instructor(username, password, name);
		allInstructors.add(in);
	}
	
	public static void addStudent() {
		System.out.println("Enter username:");
		String username = in.next();
		System.out.println("Enter password:");
		String password = in.next();
		System.out.println("Enter Student's Name:");
		String name = in.next();
		in.nextLine();
		Student s = new Student(username, password, name);
		allStudents.add(s);
	}
	
	public static void printCourses() {
		int size = allCourses.size();
		/*if (size == 0) {
			System.out.println("There are no Courses to remove.");
			System.out.println();
			runAdminFunctions();
		} */
		System.out.println("Courses:");
		for(int i = 0; i < size; i++) {
			String cID = allCourses.get(i).getCourseName();
			System.out.println("(" + (i + 1) + ") " + cID);
		}
	}
	
	public static void printInstructors() {
		int size = allInstructors.size();
		/*if (size == 0) {
			System.out.println("There are no Instructors to remove");
			runAdminFunctions();
		} */
		System.out.println("Instructors:");
		for(int i = 0; i < size; i++) {
			String in = allInstructors.get(i).getName();
			System.out.println("(" + (i + 1) + ") " + in);
		}
	}
	
	public static void printStudents() {
		int size = allStudents.size();
		/*if (size == 0) {
			System.out.println("There are no Students to remove");
			runAdminFunctions();
		} */
		System.out.println("Students:");
		for(int i = 0; i < size; i++) {
			String st = allStudents.get(i).getName();
			System.out.println("(" + (i + 1) + ") " + st);
		}
	}
	
	public static void removeCourse() {
		printCourses();
		if (allCourses.size() == 0) {
			System.out.println("There are no Courses to remove.");
			System.out.println();
			runAdminFunctions();
			return;
		}
		System.out.println("Please select the course that you would like to remove:");
		int i = in.nextInt();
		System.out.println("Are you sure you want to remove them?");
		System.out.println("(1) - yes");
		System.out.println("(2) - no");
		int x = in.nextInt();
		if (x == 1) allCourses.remove(i - 1);
		return;
	}
	
	public static void removeInstructor() {
		printInstructors();
		if(allInstructors.size() == 0) {
			System.out.println("There are no Instructors to remove");
			System.out.println();
			runAdminFunctions();
			return;
		}
		System.out.println("Please select the instructor that you would like to remove:");
		int i = in.nextInt();
		System.out.println("Are you sure you want to remove them?");
		System.out.println("(1) - yes");
		System.out.println("(2) - no");
		int x = in.nextInt();
		if(x == 1) allInstructors.remove(i - 1);
		//return;
	}

	public static void removeStudent() {
		printStudents();
		if (allStudents.size() == 0) {
			System.out.println("There are no Students to remove");
			System.out.println();
			runAdminFunctions();
			return;
		}
		System.out.println("Please select the student that you would like to remove:");
		int i = in.nextInt();
		System.out.println("Are you sure you want to remove them?");
		System.out.println("(1) - yes");
		System.out.println("(2) - no");
		int x = in.nextInt();
		if(x == 1) allStudents.remove(i - 1);
		return;
	}
	
	public static Course getCourse(int i) {
		return allCourses.get(i);
	}
	
	public static Course getCourseByID(String id) {
		for (int i = 0 ; i < allCourses.size() ; i++) {
			if (id.equals(allCourses.get(i).getCourseID())) {
				return allCourses.get(i);
			}
		}
		return null;
		
		
	}
	
	public static void testWork() {
		System.out.println("It does work..");
	}
}

/** Issues:
 * - Will only Instructors add themselves to the courses, or can Admin?
 */
