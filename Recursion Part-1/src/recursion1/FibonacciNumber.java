package recursion1;

public class FibonacciNumber {
    public static int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        int fib_n_1 = fib(n - 1);
        int fib_n_2 = fib(n - 2);
        int output = fib_n_1 + fib_n_2;
        return output;
    }

    public static void main(String[] args) {
        System.out.println(fib(7));
    }
}

/*
Time Complexity:
O(2^n)
- Each call makes two recursive calls
- Exponential growth

Space Complexity:
O(n) → recursion stack
- Maximum depth = n

Explanation:
- base case: fib(1) = 1, fib(2) = 1
- break problem → fib(n) = fib(n-1) + fib(n-2)
- recursively compute smaller Fibonacci numbers
- combine results to get final answer
 */
