package createClass_BST;

/*
Problem Statement:
Use BST class operations like insert, search and remove.
*/

public class BSTUse {
    public static void main(String[] args) {
        BST b = new BST();
        b.insert(5);
        b.insert(2);
        b.insert(7);
        b.insert(1);
        b.insert(3);
        b.insert(6);
        b.insert(8);

        System.out.println("Initial BST:"); // Initial BST:
        b.printTree();
        System.out.println();

        System.out.println("Search 5 : " + b.search(5)); // true

        b.remove1(5);

        System.out.println("Search 5 after deletion : " + b.search(5)); // false
        System.out.println();

        System.out.println("BST after remove1(5):"); // BST after remove1(5):
        b.printTree();
        System.out.println();

        System.out.println("Size : " + b.size()); // 6
        System.out.println();

        System.out.println("Before remove2(2):"); // Before remove2(2):
        b.printTree();

        b.remove2(2);
        System.out.println();

        System.out.println("After remove2(2):"); // After remove2(2):
        b.printTree();
    }
}

/*
Time Complexity:
- Insert : O(h)
- Search : O(h)
- Remove : O(h)

Space Complexity:
O(h)
- Recursive stack height

Explanation:
- Insert maintains BST property
- Search compares data recursively
- Remove handles 0, 1 and 2 child cases
*/

/*
Sample Output:

Initial BST:
5:L:2,R:7
2:L:1,R:3
1:
3:
7:L:6,R:8
6:
8:

Search 5 : true

Search 5 after deletion : false

BST after remove1(5):
6:L:2,R:7
2:L:1,R:3
1:
3:
7:L:-1,R:8
8:

Size : 6

Before remove2(2):
6:L:2,R:7
2:L:1,R:3
1:
3:
7:L:-1,R:8
8:

After remove2(2):
6:L:3,R:7
3:L:1,R:-1
1:
7:L:-1,R:8
8:
*/