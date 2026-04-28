package abstractkeyword;

public class VehicleUse {
    public static void main(String[] args) {
        BMW b = new BMW();
        /*
        Vehicle's Constructor   // parent constructor called first
        Car's Constructor       // then child constructor
        */

        b.print(); // Car: numDoors=4, numGears=5
        System.out.println(b.getCompany()); // BMW
        System.out.println(b.isMotorized()); // true
    }
}