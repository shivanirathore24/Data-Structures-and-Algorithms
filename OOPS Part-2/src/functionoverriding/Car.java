package functionoverriding;

// method overriding → same method in child class
public class Car extends Vehicle {
    int numDoors;

    @Override
    public void print() {
        System.out.println("Car: color=" + getColor() + ", maxSpeed=" + maxSpeed + ", numDoors=" + numDoors);
    }
}