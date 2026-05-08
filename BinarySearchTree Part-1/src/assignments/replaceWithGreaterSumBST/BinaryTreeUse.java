package assignments.replaceWithGreaterSumBST;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
Problem Statement:
Replace every node with sum of all greater or equal nodes in BST.
*/

public class BinaryTreeUse {
    public static void printLevelwise(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return; // base case
        }

        Queue<BinaryTreeNode<Integer>> nodesToPrint = new LinkedList<>();
        nodesToPrint.add(root);

        while (!nodesToPrint.isEmpty()) {
            BinaryTreeNode<Integer> front = nodesToPrint.poll(); // current node
            System.out.print(front.data + ":");

            if (front.left != null) {
                nodesToPrint.add(front.left);
                System.out.print("L:" + front.left.data);
            } else {
                System.out.print("L:-1");
            }

            if (front.right != null) {
                nodesToPrint.add(front.right);
                System.out.print(",R:" + front.right.data);
            } else {
                System.out.print(",R:-1");
            }

            System.out.println();
        }
    }

    public static BinaryTreeNode<Integer> buildTreeUsingInorderPreorder(int[] preOrder, int[] inOrder) {
        return buildTreeFromPreInHelper(preOrder, inOrder,
                0, preOrder.length - 1,
                0, inOrder.length - 1);
    }

    public static BinaryTreeNode<Integer> buildTreeFromPreInHelper(int[] preOrder, int[] inOrder,
                                                                   int siPre, int eiPre, int siIn, int eiIn) {
        if (siPre > eiPre) {
            return null; // base case
        }

        int rootData = preOrder[siPre];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);

        int rootIndex = -1;

        for (int i = siIn; i <= eiIn; i++) {
            if (inOrder[i] == rootData) {
                rootIndex = i;
                break;
            }
        }

        int siPreLeft = siPre + 1;
        int siInLeft = siIn;
        int eiInLeft = rootIndex - 1;

        int leftSubtreeLength = eiInLeft - siInLeft + 1;

        int eiPreLeft = siPreLeft + leftSubtreeLength - 1;

        int siPreRight = eiPreLeft + 1;
        int eiPreRight = eiPre;

        int siInRight = rootIndex + 1;
        int eiInRight = eiIn;

        BinaryTreeNode<Integer> left = buildTreeFromPreInHelper(
                preOrder, inOrder,
                siPreLeft, eiPreLeft,
                siInLeft, eiInLeft);

        BinaryTreeNode<Integer> right = buildTreeFromPreInHelper(
                preOrder, inOrder,
                siPreRight, eiPreRight,
                siInRight, eiInRight);

        root.left = left;
        root.right = right;

        return root;
    }

    // O(n)
    public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root) {
        replacewithLargerNodesSum(root, 0);
    }

    private static int replacewithLargerNodesSum(BinaryTreeNode<Integer> root, int sum) {
        if (root == null) {
            return sum; // base case
        }

        sum = replacewithLargerNodesSum(root.right, sum); // right subtree

        sum += root.data;
        root.data = sum; // replace node

        sum = replacewithLargerNodesSum(root.left, sum); // left subtree
        return sum;
    }

    // O(n)
    public static void replaceWithLargerNodesSum2(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
        BinaryTreeNode<Integer> curr = root;

        int sum = 0;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.right;
            }

            curr = stack.pop();

            sum += curr.data;
            curr.data = sum; // replace node

            curr = curr.left;
        }
    }

    public static void main(String[] args) {
        // predefined BST
        int inOrder[] = {2, 5, 6, 7, 8, 10};
        int preOrder[] = {8, 5, 2, 6, 7, 10};

        BinaryTreeNode<Integer> root = buildTreeUsingInorderPreorder(preOrder, inOrder);
        printLevelwise(root);
        replaceWithLargerNodesSum(root);

        System.out.println("After replacing :"); // After replacing :
        printLevelwise(root);
    }
}

/*
Time Complexity:
O(n)
- Each node visited once

Space Complexity:
O(h)
- Recursion / stack height

Explanation:
- Traverse BST in reverse inorder
- Keep running sum of greater nodes
- Replace current node with sum
*/

/*
Sample Input 1:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1

BST 1:
        8
      /   \
     5     10
    / \
   2   6
        \
         7

Before Replace:
8:L:5,R:10
5:L:2,R:6
10:L:-1,R:-1
2:L:-1,R:-1
6:L:-1,R:7
7:L:-1,R:-1

After Replace:
18:L:36,R:10
36:L:38,R:31
10:L:-1,R:-1
38:L:-1,R:-1
31:L:-1,R:25
25:L:-1,R:-1


Sample Input 2:
15 10 20 8 12 17 25 -1 -1 -1 -1 -1 -1 -1 -1

BST 2:
          15
        /    \
      10      20
     /  \    /  \
    8   12  17  25

Before Replace:
15:L:10,R:20
10:L:8,R:12
20:L:17,R:25
8:L:-1,R:-1
12:L:-1,R:-1
17:L:-1,R:-1
25:L:-1,R:-1

After Replace:
77:L:99,R:45
99:L:107,R:89
45:L:62,R:25
107:L:-1,R:-1
89:L:-1,R:-1
62:L:-1,R:-1
25:L:-1,R:-1
*/