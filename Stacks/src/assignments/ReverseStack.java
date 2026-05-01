package assignments;
import java.util.Stack;

/*
Problem Statement:
You are given two stacks. One is filled and the other is empty.
Reverse the filled stack using the empty stack.
*/

public class ReverseStack{
    // O(n)
    public static void reverseStack1(Stack<Integer> input, Stack<Integer> extra) {
        // move all elements to extra
        while (!input.isEmpty()) {
            extra.push(input.pop());
        }
        // move back to input (reversed)
        while (!extra.isEmpty()) {
            input.push(extra.pop());
        }
    }

    // O(n^2)
    public static void reverseStack2(Stack<Integer> input, Stack<Integer> extra) {
        if (input.size() <= 1) {
            return;   // base case
        }

        int lastElement = input.pop();   // remove top

        reverseStack2(input, extra);   // recursive call

        // move all elements to extra
        while (!input.isEmpty()) {
            extra.push(input.pop());
        }

        input.push(lastElement);   // insert at bottom

        // move back to input
        while (!extra.isEmpty()) {
            input.push(extra.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> extra = new Stack<>();

        int arr[] = {1, 2, 3, 4, 5, 6};

        for (int elem : arr) {
            stack.push(elem);
        }

        System.out.println("Before reverse: " + stack);
        // Before reverse: [1, 2, 3, 4, 5, 6]

        reverseStack1(stack, extra);

        System.out.println("After reverse (method1): " + stack);
        // After reverse (method1): [6, 5, 4, 3, 2, 1]

        // reset stack
        stack.clear();
        for (int elem : arr) {
            stack.push(elem);
        }

        reverseStack2(stack, extra);

        System.out.println("After reverse (method2): " + stack);
        // After reverse (method2): [6, 5, 4, 3, 2, 1]
    }
}

/*
Time Complexity:
reverseStack1 → O(n)
- Each element moved twice

reverseStack2 → O(n^2)
- Each recursion shifts elements

Space Complexity:
O(n)
- Extra stack + recursion stack

Explanation:
reverseStack1:
- Move all elements to extra → reverse order
- Move back → final reversed stack

reverseStack2:
- Remove top element
- Recursively reverse remaining
- Insert removed element at bottom
- Restore order using extra stack
*/

/*
Sample Input 1:
1 2 3 4 5 10

Sample Output 1:
10 5 4 3 2 1

Sample Input 2:
7 8 2 4 9

Sample Output 2:
9 4 2 8 7
*/