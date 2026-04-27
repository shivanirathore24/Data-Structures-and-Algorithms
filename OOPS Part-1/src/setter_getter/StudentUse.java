package setter_getter;

public class StudentUse {
    public static void main(String[] args) {
        Student s1 = new Student();

        s1.name = "Shivani Rathore";

        s1.setRollNumber(-100);
        // Invalid Roll Number!
        System.out.println(s1.name + ", " + s1.getRollNumber());
        // Shivani Rathore, 0

        s1.setRollNumber(7);
        System.out.println(s1.name + ", " + s1.getRollNumber());
        // Shivani Rathore, 7
    }
}