package superkeyword;

// super → refers to parent class
public class Car extends Vehicle {
    int numDoors;
    int carMaxSpeed;

    @Override
    public void print() {
        super.print();  // calls parent method
        System.out.println("Car: numDoors=" + numDoors);
    }

    public void printMaxSpeed() {
        super.maxSpeed = 15;   // parent variable
        this.carMaxSpeed = 100; // current class variable

        System.out.println(this.carMaxSpeed + " " + super.maxSpeed);
        // 100 15
    }
}