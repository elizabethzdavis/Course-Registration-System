//Tom Magnan & Elizabeth Davis

public class Admin extends User {
	
	public Admin (String user, String pass, String n) {
		super(user, pass, n);
		
	}
	
	public String getUsername() {
		return "admin";
	}
	
	public String getPassword() {
		return "password";
	}
	/*
	public String addCourse() {
		CourseRegSystem.addCourse();
	}
	
	public String dropCourse() {
		CourseRegSystem.dropCourse();
	}
	
	public String addInstructor() {
		CourseRegSystem.addInstructor();
	}
	
	public String dropInstructor() {
		CourseRegSystem.dropInstructor();
	}
	
	public String addStudent() {
		CourseRegSystem.addStudent();
	}
	
	public String dropStudent() {
		CourseRegSystem.dropStudent();
	}
	*/
}
