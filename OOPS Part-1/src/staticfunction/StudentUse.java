package staticfunction;

public class StudentUse {
    public static void main(String[] args) {
        Student s1 = new Student("Shivani", 7);
        Student s2 = new Student("Shakti", 8);
        Student s3 = new Student();
        System.out.println(Student.getNumStudent()); // 3
    }
}
