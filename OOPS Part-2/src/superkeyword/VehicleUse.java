package superkeyword;

public class VehicleUse {
    public static void main(String[] args) {
        Car c = new Car();

        c.setColor("black");
        c.maxSpeed = 100;   // parent property
        c.numDoors = 4;

        c.print();
        // Vehicle: color=black, maxSpeed=100
        // Car: numDoors=4

        c.printMaxSpeed(); // 100 15
    }
}