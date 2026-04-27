package finalkeyword;

public class Student {
    public String name;
    final private int rollNumber;
    // final → value cannot be changed after initialization

    double cgpa;
    final double converisonFactor = 0.95;  // constant → fixed value

    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;  // must be assigned once
    }
}