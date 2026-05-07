package levelwiseInputPrint_BT;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeUse {
    // O(n)
    public static BinaryTreeNode<Integer> takeInputLevelwise()  // level order input
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter root Data: ");   // root input
        int rootData = s.nextInt();

        if (rootData == -1) {
            return null;   // empty tree
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        Queue<BinaryTreeNode<Integer>> pendingChildren = new LinkedList<>();
        pendingChildren.add(root);

        while (!pendingChildren.isEmpty()) {
            BinaryTreeNode<Integer> front = pendingChildren.poll();   // current node

            System.out.println("Enter left child of " + front.data);
            int left = s.nextInt();

            if (left != -1) {
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(left);
                front.left = leftChild;
                pendingChildren.add(leftChild);   // enqueue left
            }

            System.out.println("Enter right child of " + front.data);
            int right = s.nextInt();

            if (right != -1) {
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(right);
                front.right = rightChild;
                pendingChildren.add(rightChild);   // enqueue right
            }
        }
        return root;
    }

    // O(n)
    public static void printLevelwise(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;   // base case
        }

        Queue<BinaryTreeNode<Integer>> nodesToPrint = new LinkedList<>();
        nodesToPrint.add(root);

        while (!nodesToPrint.isEmpty()) {
            BinaryTreeNode<Integer> front = nodesToPrint.poll();   // current node

            System.out.print(front.data + ":");

            if (front.left != null) {
                nodesToPrint.add(front.left);
                System.out.print("L:" + front.left.data);   // left child
            } else {
                System.out.print("L:-1");   // no left
            }

            if (front.right != null) {
                nodesToPrint.add(front.right);
                System.out.print(",R:" + front.right.data);   // right child
            } else {
                System.out.print(",R:-1");   // no right
            }

            System.out.println();
        }
    }


    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelwise();
        printLevelwise(root);
    }
}

/*
Sample Input 1:
1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1

Tree 1:
     1
   /   \
  2     3
 / \   / \
4   5 6   7

Sample Output 1:
1:L:2,R:3
2:L:4,R:5
3:L:6,R:7
4:L:-1,R:-1
5:L:-1,R:-1
6:L:-1,R:-1
7:L:-1,R:-1


Sample Input 2:
1 2 3 -1 4 -1 -1 -1 -1

Tree 2:
     1
   /   \
  2     3
   \
    4

Sample Output 2:
1:L:2,R:3
2:L:-1,R:4
3:L:-1,R:-1
4:L:-1,R:-1
*/