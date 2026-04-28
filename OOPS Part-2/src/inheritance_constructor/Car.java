package inheritance_constructor;

// constructor chaining → child calls parent constructor
public class Car extends Vehicle {
    int numDoors;

    public Car(int numDoors, int maxSpeed) {
        super(maxSpeed);  // calls parent constructor
        System.out.println("Car's Constructor");
        this.numDoors = numDoors;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Car: numDoors=" + numDoors);
    }

    public void printMaxSpeed() {
        super.maxSpeed = 15;
        System.out.println(maxSpeed + " " + super.maxSpeed); // 15 15
    }
}