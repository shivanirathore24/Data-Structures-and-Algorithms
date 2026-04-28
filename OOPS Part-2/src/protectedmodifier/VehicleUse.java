package protectedmodifier;
import functionoverriding.Vehicle;

public class VehicleUse {
    public static void main(String[] args) {
        Vehicle v = new Vehicle();
        // v.maxSpeed = 10;  // protected → not accessible via object outside package
    }
}