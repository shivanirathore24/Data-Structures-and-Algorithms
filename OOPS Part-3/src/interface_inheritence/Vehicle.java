package interface_inheritence;

public class Vehicle implements VehicleInterface {
    @Override
    public boolean isMotorized() {
        return false;
    }

    @Override
    public String getCompany() {
        return "Generic Vehicle";
    }

    void print() {
        System.out.println("Vehicle: PI=" + PI);
    }
}