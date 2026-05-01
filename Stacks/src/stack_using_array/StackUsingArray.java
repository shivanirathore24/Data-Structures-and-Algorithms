package stack_using_array;

public class StackUsingArray {
    private int data[];
    private int topIndex;

    public StackUsingArray() {
        data = new int[10];     // default size
        topIndex = -1;          // empty stack
    }

    public StackUsingArray(int size) {
        data = new int[size];   // custom size
        topIndex = -1;
    }

    // O(1) → direct calculation
    public int size() {
        return topIndex + 1;   // number of elements
    }

    // O(1) → single comparison
    public boolean isEmpty() {
        // if (topIndex == -1) {
        //    return true;
        // } else {
        //    return false;
        // }
        return topIndex == -1;  // check empty
    }

    // O(1) → constant insert
    public void push(int elem) throws StackFullException {
        // if stack is full
        if (topIndex == data.length - 1) {
            throw new StackFullException();  // overflow
        }

        // topIndex++;
        // data[topIndex] = elem;
        data[++topIndex] = elem;  // insert element
    }

    // O(1) → direct access
    public int top() throws StackEmptyException {
        // if stack is empty
        if (topIndex == -1) {
            throw new StackEmptyException();  // underflow
        }
        return data[topIndex];  // return top
    }

    // O(1) → constant removal
    public int pop() throws StackEmptyException {
        // if stack is empty
        if (topIndex == -1) {
            throw new StackEmptyException();  // underflow
        }

        // int temp = data[topIndex];
        // topIndex--;
        int temp = data[topIndex--];  // remove top
        return temp;
    }
}