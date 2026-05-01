package stack_doublecapacity;

public class StackUsingArray {
    private int data[];
    private int topIndex;

    public StackUsingArray()  // default constructor
    {
        data = new int[10];     // default size
        topIndex = -1;          // empty stack
    }

    public StackUsingArray(int size) {
        data = new int[size];   // custom size
        topIndex = -1;
    }

    // O(1)
    public int size() {
        return topIndex + 1;    // number of elements
    }

    // O(1)
    public boolean isEmpty() {
        return topIndex == -1;  // check empty
    }

    // O(1) amortized → resize O(n)
    public void push(int elem) {
        if (topIndex == data.length - 1) {
            doubleCapacity();   // resize when full
        }
        data[++topIndex] = elem;  // insert element
    }

    // O(n)
    private void doubleCapacity() {
        System.out.println("Size of stack before Doubling Capacity:" + data.length);
        // Size of stack before Doubling Capacity:4

        int temp[] = data;
        data = new int[2 * temp.length];   // double size

        for (int i = 0; i < temp.length; i++) {
            data[i] = temp[i];  // copy elements
        }

        System.out.println("Size of stack before after Capacity:" + data.length);
        // Size of stack before after Capacity:8
    }

    // O(1)
    public int top() throws StackEmptyException {
        if (topIndex == -1) {
            throw new StackEmptyException();  // underflow
        }
        return data[topIndex];  // return top
    }

    // O(1)
    public int pop() throws StackEmptyException {
        if (topIndex == -1) {
            throw new StackEmptyException();  // underflow
        }
        int temp = data[topIndex--];  // remove top
        return temp;
    }
}