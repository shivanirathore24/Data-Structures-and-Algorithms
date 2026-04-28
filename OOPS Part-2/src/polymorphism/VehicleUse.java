package polymorphism;

import java.util.Scanner;

public class VehicleUse {
    public static void main(String[] args) {

        Vehicle v;  // parent reference

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        if (n < 10) {
            v = new Car(4, 100);   // child object
        } else {
            v = new Vehicle(100);  // parent object
        }

        v.print();  // runtime decision (dynamic binding)

        // Car c = new Vehicle(); // invalid (parent → child not allowed)
    }
}