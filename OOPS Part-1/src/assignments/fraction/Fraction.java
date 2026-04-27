package assignments.fraction;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();  // keeps fraction in simplest form
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setDenominator(int denominator) {
        if (denominator == 0) {
            denominator = 1;  // avoids invalid fraction
        }
        this.denominator = denominator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void simplify() {
        int gcd = 1;
        int smaller = Math.min(numerator, denominator);

        // finds gcd using iteration
        for (int i = 2; i <= smaller; i++) {
            if (numerator % i == 0 && denominator % i == 0) {
                gcd = i;
            }
        }
        numerator = numerator / gcd;
        denominator = denominator / gcd;
    }

    public void print() {
        System.out.println(numerator + "/" + denominator);
    }

    // instance method → modifies current object
    public void add(Fraction f2) {
        this.numerator = this.numerator * f2.denominator + this.denominator * f2.numerator;
        this.denominator = this.denominator * f2.denominator;
        simplify();
    }

    // static method → returns new object (does not modify originals)
    public static Fraction add(Fraction f1, Fraction f2) {
        int newNum = f1.numerator * f2.denominator + f1.denominator * f2.numerator;
        int newDeno = f1.denominator * f2.denominator;
        return new Fraction(newNum, newDeno);
    }
}