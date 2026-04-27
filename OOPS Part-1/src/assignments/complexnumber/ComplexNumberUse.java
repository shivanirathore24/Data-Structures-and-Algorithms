package assignments.complexnumber;
import java.util.Scanner;

public class ComplexNumberUse {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int real1 = s.nextInt();
        int imaginary1 = s.nextInt();

        int real2 = s.nextInt();
        int imaginary2 = s.nextInt();

        ComplexNumbers c1 = new ComplexNumbers(real1, imaginary1);
        ComplexNumbers c2 = new ComplexNumbers(real2, imaginary2);

        int choice = s.nextInt();

        if (choice == 1) {
            c1.plus(c2);
            c1.print(); // sum
        } else if (choice == 2) {
            c1.multiply(c2);
            c1.print(); // product
        }
    }
}