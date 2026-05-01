package stack_using_linkedlist;

public class StackUse {
    public static void main(String[] args) throws StackEmptyException {
        StackUsingLL<String> stack1 = new StackUsingLL<String>();

        String arr1[] = {"MS Dhoni", "Neeraj Chopra", "Shubman Gill", "Shivani Rathore"};

        System.out.println("Push Operation : ");
        for (int i = 0; i < arr1.length; i++) {
            stack1.push(arr1[i]);   // pushing elements
        }

        System.out.println();

        System.out.println("Pop Operation :");
        while (!stack1.isEmpty()) {
            System.out.println(stack1.pop());
            // Shivani Rathore
            // Shubman Gill
            // Neeraj Chopra
            // MS Dhoni
        }

        System.out.println();

        StackUsingLL<Integer> stack = new StackUsingLL<Integer>();
        int arr[] = {7, 8, 5, 4, 6};

        System.out.println("Push Operation : ");
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);   // pushing elements
        }

        System.out.println("Pop Operation :");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop()); // 6 4 5 8 7
        }
    }
}