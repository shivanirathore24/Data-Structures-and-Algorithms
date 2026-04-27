package statickeyword;

public class Student {
	public String name;
	final private int rollNumber;
	double cgpa;

	final static double CONVERSION_FACTOR = 0.95;
	// static final → constant (class-level)

	static int numStudents;  // shared among all objects

	public Student(String name){
		this.name = name;
		numStudents++; // increments shared count
		this.rollNumber = numStudents; // unique per object
	}
}