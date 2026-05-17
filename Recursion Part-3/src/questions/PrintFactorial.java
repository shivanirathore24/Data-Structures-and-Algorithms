package questions;

/*
Problem Statement:
Print factorial using recursion in two ways.
*/

public class PrintFactorial {
    // O(n)
    public static void factorial1(int n) {
        int output = factorialHelper(n);
        System.out.println(output); // 120
    }

    // O(n)
    public static int factorialHelper(int input) {
        // base case
        if (input == 0) {
            return 1;
        }
        return input * factorialHelper(input - 1);
    }

    // O(n)
    public static void factorial2(int input, int answer) {
        // base case
        if (input == 0) {
            System.out.println(answer); // 120
            return;
        }
        answer = answer * input;
        factorial2(input - 1, answer);
    }

    public static void main(String[] args) {
        int n = 5;
        factorial1(n);    // way 1
        factorial2(n, 1);  // way 2
    }
}

/*
Time Complexity:
O(n)
- Recursive call runs n times

Space Complexity:
O(n)
- Recursive stack stores function calls

Explanation:
- factorial1() returns factorial value recursively
- factorial2() uses accumulator variable
- Base case returns or prints 1
*/

/*
Sample Input 1:
5

Sample Output 1:
120

Sample Input 2:
4

Sample Output 2:
24
*/