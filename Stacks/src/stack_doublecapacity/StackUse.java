package stack_doublecapacity;

public class StackUse {
    public static void main(String[] args) throws StackEmptyException {
        StackUsingArray stack = new StackUsingArray(4);  // initial capacity = 4

        int arr[] = {7, 8, 5, 4, 6};
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);  // triggers resize on 5th element
        }

        System.out.println("No.of elements in stack:" + stack.size());  // No.of elements in stack:5
    }
}