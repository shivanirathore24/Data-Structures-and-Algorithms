package thiskeyword;

public class StudentUse {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Shivani Rathore";

        System.out.println("s1 " + s1);
        // s1 thiskeyword.Student@<hashcode>

        s1.setRollNumber(6);
        // this thiskeyword.Student@<same hashcode as s1>

        System.out.println(s1.name + ", " + s1.getRollNumber());
        // Shivani Rathore, 6


        Student s2 = new Student();
        s2.name = "Shivani Rathore";

        System.out.println("s2 " + s2);
        // s2 thiskeyword.Student@<hashcode>

        s2.setRollNumber(6);
        // this thiskeyword.Student@<same hashcode as s2>

        System.out.println(s2.name + ", " + s2.getRollNumber());
        // Shivani Rathore, 6
    }
}