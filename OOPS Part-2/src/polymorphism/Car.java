package polymorphism;

// runtime polymorphism → method decided at runtime
public class Car extends Vehicle {
    int numDoors;

    public Car(int numDoors, int maxSpeed) {
        super(maxSpeed);
        System.out.println("Car's Constructor");
        this.numDoors = numDoors;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Car: numDoors=" + numDoors);
    }
}