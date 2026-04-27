package finalkeyword;

public class StudentUse {

	public static void main(String[] args) {
		Student s1 = new Student("Shivani Rathore", 24);
		System.out.println(s1);
		// finalkeyword.Student@<hashcode>  (prints reference)
		// s1.converisonFactor = 0.90; ❌ not allowed (final variable)
	}
}