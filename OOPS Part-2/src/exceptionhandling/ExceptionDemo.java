package exceptionhandling;

// Checked exception → must be handled or declared using throws
public class ExceptionDemo {
    public static int divide(int a, int b) throws DivideByZeroException {
        if (b == 0) {
            throw new DivideByZeroException();  // explicit exception
        }
        return a / b;
    }

    public static void main(String[] args) {
        try {
            int result = divide(10, 0);
            System.out.println(result);  // skipped if exception occurs
        } catch (DivideByZeroException e) {
            System.out.println("Divide by zero exception occurred!");
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic exception occurred!");
        } finally {
            System.out.println("Finally block executed");  // always runs
        }

        System.out.println("Main");  // always executes
    }
}