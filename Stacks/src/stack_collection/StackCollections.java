package stack_collection;
import java.util.Stack;

public class StackCollections {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int arr[] = {7, 8, 2, 4, 9};

        for (int elem : arr) {
            stack.push(elem);   // push elements
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop()); // 9 4 2 8 7
        }

//      stack.push(10);
//      stack.push(20);
//      System.out.println(stack.size());   // 2
//      System.out.println(stack.peek());   // 20
//      System.out.println(stack.pop());    // 20
//      System.out.println(stack.isEmpty()); // false
    }
}