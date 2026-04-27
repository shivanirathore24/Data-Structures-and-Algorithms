package assignments.fraction;

public class FractionUse {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(4, 6);
        f1.print(); // 2/3

        Fraction f2 = new Fraction(4, 8);
        f1.add(f2);      // instance method → modifies f1
        f1.print();      // 7/6

        Fraction f3 = Fraction.add(f1, f2);  // static method → new object
        f3.print(); // 5/3
    }
}