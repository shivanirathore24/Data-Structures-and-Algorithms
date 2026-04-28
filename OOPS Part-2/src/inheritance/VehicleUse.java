package inheritance;

public class VehicleUse {

    public static void main(String[] args) {
        Vehicle v = new Vehicle();
        v.setColor("red");
        v.maxSpeed = 80;
        v.print(); // Vehicle: color=red, maxSpeed=80

        Car c = new Car();
        c.setColor("black");
        c.maxSpeed = 100;
        c.numDoors = 4;
        c.printCar(); // Car: color=black, maxSpeed=100, numDoors=4

        Bicycle b = new Bicycle();
        b.print(); // Vehicle: color=null, maxSpeed=0
    }
}