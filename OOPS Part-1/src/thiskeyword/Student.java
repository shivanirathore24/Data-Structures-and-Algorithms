package thiskeyword;

public class Student {
    String name;
    private int rollNumber;

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        if (rollNumber <= 0) {
            return;
        }
        // this → refers to current object
        System.out.println("this " + this);
        this.rollNumber = rollNumber;
    }
}