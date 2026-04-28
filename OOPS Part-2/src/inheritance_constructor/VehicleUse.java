package inheritance_constructor;

public class VehicleUse {
    public static void main(String[] args) {
        Car c = new Car(4, 100);
        c.print();

        // Output:
        // Vehicle's Constructor
        // Car's Constructor
        // Vehicle: color=null, maxSpeed=100
        // Car: numDoors=4

    }
}
