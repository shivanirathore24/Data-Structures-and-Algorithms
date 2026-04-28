package interface_inheritence;

public class VehicleUse {
    public static void main(String[] args) {
        Vehicle v = new Vehicle();
        v.print(); // Vehicle: PI=3.14

        VehicleInterface vI;
        vI = new Car();
        System.out.println(vI.getCompany()); // Car Company
        System.out.println(vI.isMotorized()); // true
    }
}