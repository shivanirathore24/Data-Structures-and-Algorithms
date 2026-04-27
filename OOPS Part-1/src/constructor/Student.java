package constructor;

public class Student {
	public String name;
	private int rollNumber;

	// Parameterized constructor → initialize both fields
	public Student(String name, int rollNumber){
		this.name = name;
		this.rollNumber = rollNumber;
	}

	// Constructor overloading → only name provided
	public Student(String name){
		this.name = name;
		// rollNumber remains default (0)
	}

	// Default constructor → assigns default values
	public Student(){
		this.name = "Shiv";
		this.rollNumber = 10;
	}

	public void print(){
		System.out.println(name + " " + rollNumber);
	}
}