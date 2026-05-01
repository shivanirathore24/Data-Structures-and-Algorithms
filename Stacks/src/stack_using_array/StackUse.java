package stack_using_array;

public class StackUse {
    public static void main(String[] args) throws StackFullException, StackEmptyException {
        StackUsingArray stack = new StackUsingArray(40);  // initialize stack

        int arr[] = {7, 8, 5, 4, 6};
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);  // push elements
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());  // 6 4 5 8 7
        }

        try {
            stack.top();  // accessing top on empty stack
        } catch (StackEmptyException e) {
            System.out.println("Stack is empty, so can't return topmost Element !");
            // Stack is empty, so can't return topmost Element !
        }

        // stack.pop();  // exception propagated
    }
}