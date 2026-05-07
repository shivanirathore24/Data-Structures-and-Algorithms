package usingInorderPreorder_buildBT;
import java.util.LinkedList;
import java.util.Queue;

/*
Problem Statement:
Given inorder and preorder traversal arrays, construct the binary tree.
*/

public class BinaryTreeUse {
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
                System.out.print("L:" + front.left.data);   // left
            } else {
                System.out.print("L:-1");
            }

            if (front.right != null) {
                nodesToPrint.add(front.right);
                System.out.print(",R:" + front.right.data);   // right
            } else {
                System.out.print(",R:-1");
            }

            System.out.println();
        }
    }

    // O(n^2)
    public static BinaryTreeNode<Integer> buildTreeUsingInorderPreorder(int[] preOrder, int[] inOrder) {
        return buildTreeFromPreInHelper(preOrder, inOrder, 0, preOrder.length - 1, 0, inOrder.length - 1);
    }

    public static BinaryTreeNode<Integer> buildTreeFromPreInHelper(int[] preOrder, int[] inOrder,
                                                                   int siPre, int eiPre, int siIn, int eiIn) {
        if (siPre > eiPre) {
            return null;   // no node
        }

        int rootData = preOrder[siPre];   // root from preorder
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);

        int rootIndex = -1;
        for (int i = siIn; i <= eiIn; i++) {
            if (inOrder[i] == rootData) {
                rootIndex = i;   // find root in inorder
                break;
            }
        }

        int siPreLeft = siPre + 1;
        int siInLeft = siIn;
        int eiInLeft = rootIndex - 1;

        int leftSize = eiInLeft - siInLeft + 1;

        int eiPreLeft = siPreLeft + leftSize - 1;
        int siPreRight = eiPreLeft + 1;
        int eiPreRight = eiPre;

        int siInRight = rootIndex + 1;
        int eiInRight = eiIn;

        root.left = buildTreeFromPreInHelper(preOrder, inOrder,
                siPreLeft, eiPreLeft, siInLeft, eiInLeft);   // left subtree

        root.right = buildTreeFromPreInHelper(preOrder, inOrder,
                siPreRight, eiPreRight, siInRight, eiInRight); // right subtree

        return root;
    }

    public static void main(String[] args) {
        int inOrder[] = {4, 2, 5, 1, 3};
        int preOrder[] = {1, 2, 4, 5, 3};

        BinaryTreeNode<Integer> root = buildTreeUsingInorderPreorder(preOrder, inOrder);
        printLevelwise(root);   // e.g. 1:L2,R3 ...
    }
}

/*
Time Complexity:
O(n^2)
- Searching root in inorder

Space Complexity:
O(h)
- Recursive stack

Explanation:
- Root is first element of preorder
- Split inorder into left and right parts
- Recursively build subtrees
*/

/*
Sample Input 1:
Inorder:
2 1 3
Preorder:
1 2 3

Tree 1:
   1
  / \
 2   3

Sample Output 1:
1:L:2,R:3
2:L:-1,R:-1
3:L:-1,R:-1


Sample Input 2:
Inorder:
4 2 5 1 3
Preorder:
1 2 4 5 3

Tree 2:
     1
   /   \
  2     3
 / \
4   5

Sample Output 2:
1:L:2,R:3
2:L:4,R:5
3:L:-1,R:-1
4:L:-1,R:-1
5:L:-1,R:-1


Sample Input 3:
Inorder:
4 2 1 3
Preorder:
1 2 4 3

Tree 3:
    1
   / \
  2   3
 /
4

Sample Output 3:
1:L:2,R:3
2:L:4,R:-1
3:L:-1,R:-1
4:L:-1,R:-1
 */