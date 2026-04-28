package abstractkeyword;

public abstract class Car extends Vehicle {
    int numDoors;
    int numGears;

    public Car() {
        System.out.println("Car's Constructor");
        numDoors = 4;
        numGears = 5;
    }

    public Car(int numDoors, int maxSpeed) {
        super(maxSpeed);
        System.out.println("Car's Constructor");
        this.numDoors = numDoors;
    }

    public void print() {
        System.out.println("Car: numDoors=" + numDoors + ", numGears=" + numGears);
    }

    public void printMaxSpeed() {
        maxSpeed = 150;
        System.out.println(maxSpeed + " " + maxSpeed);
    }

    @Override
    public boolean isMotorized() {
        return true;
    }
}