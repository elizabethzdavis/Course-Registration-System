import java.util.ArrayList;

//Tom Magnan & Elizabeth Davis

public class Course {

private String courseName;
private String courseID;
private Instructor instructor;
private ArrayList<String> students = new ArrayList<String>();
	
	public Course (String n, String num) {
		courseName = n;
		courseID   = num;
	}
	public void addStudent(String id) {
		//String x = s.getUsername();
		students.add(id);
		//System.out.println("This runs");
	}
	public void removeStudent(String id) {
		boolean x = students.remove(id);
		if (!x) System.out.println("This Student is not in the Course");
	}
	public void printRoster() {
		for (int i = 0 ; i < students.size() ; i++) {
			System.out.println((i+1) + ". " + students.get(i));
		}
	}
	public Instructor getInstructor() {
		if (instructor == null) {
			System.out.println("No Instructor"); return null;
		}
		else {
			return instructor;
		}
	}
	public String getCourseName() {
		return courseName;
	}
	public String getCourseID() {
		return courseID;
	}
	public void setInstructor(Instructor i) {
		instructor = i;
	}
	public void removeInstructor() {
		instructor = null;
	}
	public int getNumStudents() {
		return students.size();
	}
	
	//When getting Instructor, have "Unassigned" if not added
}
