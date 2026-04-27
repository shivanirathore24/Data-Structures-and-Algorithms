package constructor;

public class StudentUse {
	public static void main(String[] args){
		Student s1 = new Student("Shivani", 50);
		s1.print(); // Shivani 50

		Student s2 = new Student("Shakti");
		s2.print(); // Shakti 0

		Student s3 = new Student();
		s3.print(); // abc 10
	}
}