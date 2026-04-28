package inheritance;

// Car inherits properties & methods of Vehicle
public class Car extends Vehicle {
    int numDoors;

    public void printCar() {
        System.out.println("Car: color=" + getColor() + ", maxSpeed=" + maxSpeed + ", numDoors=" + numDoors);
    }
}