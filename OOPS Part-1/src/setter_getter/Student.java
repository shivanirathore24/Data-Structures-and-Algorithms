package setter_getter;

public class Student {
    String name;
    private int rollNumber;  // private data → cannot access directly

    // Getter → read private data
    public int getRollNumber() {
        return rollNumber;
    }

    // Setter → update private data with validation
    public void setRollNumber(int rollNumber) {
        if (rollNumber <= 0) {
            System.out.println("Invalid Roll Number!");
            return;
        }
        this.rollNumber = rollNumber;
    }
}