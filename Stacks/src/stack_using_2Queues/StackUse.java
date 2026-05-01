package stack_using_2queues;

public class StackUse {
    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println(stack);   // stack_using_2Queues.StackUsingQueue@<hashcode>

        System.out.println(stack.pop());   // 40
        System.out.println(stack.size());  // 3
        System.out.println(stack.top());   // 30

        // remaining stack: 10, 20, 30
        while (!stack.isEmpty()) {
            System.out.println(stack.pop()); // 30 20 10
        }
    }
}