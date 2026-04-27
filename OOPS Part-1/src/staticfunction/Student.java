package staticfunction;

public class Student {
    public String name;
    final private int rollNumber;
    double cgpa;
    final static double CONVERSION_FACTOR = 0.95;  // constant (class-level)
    static int numStudents;  // shared count

    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
        numStudents++;  // updates shared count
    }

    public Student() {
        name = "Shiv";
        numStudents++;
        this.rollNumber = numStudents;
    }

    // static function → can access only static data
    public static int getNumStudent() {
        // rollNumber not accessible (non-static)
        return numStudents;
    }

    public void print() {
        System.out.println(name + " " + rollNumber);
    }
}