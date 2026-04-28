package protectedmodifier;
import functionoverriding.Vehicle;

public class Truck extends Vehicle {
    int maxLoadingCapacity;

    @Override
    public void print() {
        System.out.println("Truck: color=" + getColor() + ", maxSpeed=" + maxSpeed + ", maxLoadingCapacity=" + maxLoadingCapacity);
    }
    // protected → accessible in subclass even outside package
}