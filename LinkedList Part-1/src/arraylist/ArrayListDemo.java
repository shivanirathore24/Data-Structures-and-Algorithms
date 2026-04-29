package arraylist;

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        // ArrayList → dynamic array (resizable)
        ArrayList<Integer> arr = new ArrayList<>(20);
        arr.add(10);
        arr.add(30);
        arr.add(50);

        // insert at index → shifts elements right
        arr.add(1, 60);

        // print using index-based loop
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
        // 10 60 30 50

        // enhanced for loop → direct access (no index)
        for (int i : arr) {
            System.out.println(i);
        }
        // 10 60 30 50
    }
}

/*
ArrayList → dynamic size (unlike array)
add(index, value) → inserts element and shifts existing elements
Enhanced for loop → simpler traversal, no index access
*/