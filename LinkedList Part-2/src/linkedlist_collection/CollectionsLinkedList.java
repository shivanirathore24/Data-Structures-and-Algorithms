package linkedlist_collection;
import java.util.LinkedList;

public class CollectionsLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(1, 100);      // insert at index → shifts elements right
        list.addFirst(70);     // add at beginning
        list.set(0, 60);       // replace value at index (no shifting)
        list.remove();         // removes first element

        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));   // 10 100 20 30
        }

        // Optimized traversal
        for(Integer val : list){
            System.out.println(val);   // 10 100 20 30
        }

        System.out.println("First Element: " + list.getFirst());   // First Element: 10
        System.out.println("Last Element: " + list.getLast());     // Last Element: 30
        System.out.println("Size: " + list.size());                // Size: 4

        // check element
        System.out.println("Contains 20? " + list.contains(20));   // Contains 20? true

        // remove specific value
        list.remove(Integer.valueOf(100));   // removes 100

        for(Integer val : list){
            System.out.println(val);   // 10 20 30
        }
    }
}