package interface_inheritence;

// multiple inheritance using interfaces
public class Car extends Vehicle implements VehicleInterface, CarInterface {
    @Override
    public boolean isMotorized() {
        return true;
    }

    @Override
    public String getCompany() {
        return "Car Company";
    }

    @Override
    public int numGears() {
        return 5;
    }

    void print() {
        System.out.println("Car: PI=" + PI);
    }
}