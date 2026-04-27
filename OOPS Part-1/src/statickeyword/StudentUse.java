package statickeyword;

public class StudentUse {
    public static void main(String[] args) {

        System.out.println(Student.numStudents); // 0

        // System.out.println(Student.name); ❌ non-static

        Student s1 = new Student("Shivani");
        Student s2 = new Student("Shakti");
        Student s3 = new Student("Shubman");

        System.out.println(s1.numStudents); // 3
        System.out.println(s2.numStudents); // 3
        System.out.println(Student.numStudents); // 3
    }
}