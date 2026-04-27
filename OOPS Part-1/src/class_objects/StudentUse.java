package class_objects;

public class StudentUse {
    public static void main(String[] args) {
        // Objects → instances of class
        Student s1 = new Student();
        Student s2 = new Student();

        System.out.println(s1);
        // class_objects.Student@<hashcode>
        // Prints object reference (not actual data)

        s1.name = "Shivani Rathore";
        s1.rollNumber = 10;
        System.out.println(s1.name + " " + s1.rollNumber);
        // Shivani Rathore 10

        s2.name = "Shiv Shakti";
        s2.rollNumber = 50;
        System.out.println(s2.name + " " + s2.rollNumber);
        // Shiv Shakti 50
    }
}